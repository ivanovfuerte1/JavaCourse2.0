package com.sirma.itt.javacourse.chat.server;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

/**
 * The class {@link NewChatClient} contains a method for sending reversed messages to clients.
 */
public class NewChatClient extends Thread {
	private ObjectTransfer objectTransfer;
	Map<ObjectTransfer, String> connectedClients;

	private static final Logger LOGGER = LogManager.getLogger(NewChatClient.class);

	/**
	 * Creates a new object of {@link NewChatClient}.
	 * 
	 * @param socket
	 *            the socket to which the client is connected.
	 * @param connectedClients
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
		objectTransfer.writeObject(new Message("", "Welcome"));
		try {
			while (true) {
				message = objectTransfer.readObject();
				currentNickname = message.getNickname();
				for (String nickname : connectedClients.values()) {
					if (nickname.equalsIgnoreCase(currentNickname)) {
						message.setMessageContents(currentNickname + " already exists.");
						new IncorrectNicknameFrame().setVisible(true);
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
