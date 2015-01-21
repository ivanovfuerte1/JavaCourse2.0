package com.sirma.itt.javacourse.chat.server;

import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.chat.commonfiles.Language;
import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

/**
 * The class {@link NewChatClient} contains a method for sending welcome message to a new client and
 * communicating all connected clients for the event.
 */
public class NewChatClient extends Thread {
	private ObjectTransfer objectTransfer;
	private Map<ObjectTransfer, String> connectedClients;
	// private Locale currentLocale = new Locale("en", "US");
	// private ResourceBundle messages = ResourceBundle.getBundle("ChatBundle", currentLocale);
	private ResourceBundle messages = Language.getMessages();

	private static final Logger LOGGER = LogManager.getLogger(NewChatClient.class);

	/**
	 * Creates a new object of {@link NewChatClient}.
	 * 
	 * @param objectTransfer
	 *            the object for reading and writing assigned to the current client
	 * @param connectedClients
	 *            a map of all connected clients
	 */
	public NewChatClient(ObjectTransfer objectTransfer, Map<ObjectTransfer, String> connectedClients) {
		this.objectTransfer = objectTransfer;
		this.connectedClients = connectedClients;
	}

	@Override
	public void run() {
		boolean existentNickname = false;
		String currentNickname;
		Message message;
		objectTransfer.writeObject(new Message("", messages.getString("Welcome")));
		try {
			while (true) {
				message = objectTransfer.readObject();
				currentNickname = message.getNickname();
				for (String nickname : connectedClients.values()) {
					if (nickname.equalsIgnoreCase(currentNickname)) {
						message.setMessageContents(currentNickname + " "
								+ messages.getString("alreadyExists"));
						new IncorrectNicknameFrame().setVisible(true);
						// THIS ROW DOESN'T SEEM TO WORK
						objectTransfer.writeObject(message);
						existentNickname = true;
						break;
					}
				}
				if (!existentNickname) {
					break;
				}
			}
			connectedClients.put(objectTransfer, currentNickname);
			message.setMessageContents("You are connected.");
			objectTransfer.writeObject(message);
		} catch (NullPointerException e) {
			LOGGER.error("There is no message to read.", e);
		}
		new NewChatCommunication(objectTransfer, connectedClients).start();
	}
}
