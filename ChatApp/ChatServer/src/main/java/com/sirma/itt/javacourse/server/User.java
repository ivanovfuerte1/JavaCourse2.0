package com.sirma.itt.javacourse.server;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.Language;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link User} contains a method for sending welcome message to a new client and
 * communicating all connected clients for the event.
 */
public class User implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(User.class);
	private ObjectTransfer objectTransfer;
	private Map<String, ObjectTransfer> connectedClients;
	private ResourceBundle messages = Language.getMessages();
	private ChatServerThread chatServerThread;
	private String nickname;

	/**
	 * Constructs a new object of the class {@link User} assigning values to its variables.
	 * 
	 * @param objectTransfer
	 *            the socket of the current client
	 * @param chatServerThread
	 *            the frame of the server
	 * @param clients
	 *            a
	 */
	public User(ObjectTransfer objectTransfer, ChatServerThread chatServerThread,
			Map<String, ObjectTransfer> clients) {
		this.chatServerThread = chatServerThread;
		this.objectTransfer = objectTransfer;
		this.connectedClients = clients;
	}

	@Override
	public void run() {
		boolean existentNickname = false;
		Message welcomeMessage = new Message("", messages.getString("Welcome"));
		Message message;
		Message connected = new Message();
		objectTransfer.writeObject(welcomeMessage);
		welcomeMessage.setType("New client");
		try {
			while (true) {
				message = objectTransfer.readObject();
				nickname = message.getNickname();
				for (String client : connectedClients.keySet()) {
					if (client.equalsIgnoreCase(nickname)) {
						// message.setMessageContents(nickname + " "
						// + messages.getString("alreadyExists"));
						// new IncorrectNicknameFrame().setVisible(true);
						message.setType("Existent nickname");
						objectTransfer.writeObject(message);
						existentNickname = true;
						break;
					}
					existentNickname = false;
				}
				if (!existentNickname) {
					// connected.setMessageContents("You are connected.");
					chatServerThread.registerUser(objectTransfer, nickname);
					break;
				}
			}
			connectedClients.put(nickname, objectTransfer);
			objectTransfer.writeObject(connected);
			chatServerThread.getChatServerFrame().setTextFieldContent(
					"Client " + nickname + " connected.");
		} catch (IOException e) {
			LOGGER.error("There is no active connection", e);
		}
		communicate();
	}

	/**
	 * Realizes the communication among clients as well as sending the list of clients.
	 */
	private void communicate() {

		// Message listOfClients = makeListOfClients();
		// listOfClients.setType("userList");
		// objectTransfer.writeObject(listOfClients);
		try {
			while (true) {
				Message message = objectTransfer.readObject();
				// if (message == null || "Stop thread".equals(message.getMessageContents())) {
				// chatServerThread.getChatServerFrame().setTextFieldContent(
				// "Client " + nickname + " disconnected.");
				// connectedClients.remove(objectTransfer);
				// objectTransfer.writeObject(new Message("", "Stop reading"));
				// break;
				// }
				for (Entry<String, ObjectTransfer> client : connectedClients.entrySet()) {
					if ("textMessage".equals(message.getType())) {
						client.getValue().writeObject(message);
					}
				}
			}
		} catch (IOException e) {
			LOGGER.error("There is no active connection", e);
			chatServerThread.unregisterUser(objectTransfer, nickname);
			connectedClients.remove(nickname);
		}

	}

	// /**
	// * Makes a list of clients and assigns it to the contents of a message.
	// *
	// * @return a message containing the actual list of clients
	// */
	// private Message makeListOfClients() {
	// StringBuilder stringBuilder = new StringBuilder();
	// for (String nickname : connectedClients.keySet()) {
	// stringBuilder.append(nickname);
	// stringBuilder.append(ConstantsChat.LINE_SEPARATOR);
	// }
	// Message listOfClients = new Message();
	// listOfClients.setMessageContents(stringBuilder.toString());
	// return listOfClients;
	// }
}
