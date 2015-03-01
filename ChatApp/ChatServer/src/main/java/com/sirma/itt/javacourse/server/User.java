package com.sirma.itt.javacourse.server;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link User} contains a method for sending welcome message to a new client and
 * realizing communication with the other clients.
 */
public class User implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(User.class);
	private ObjectTransfer objectTransfer;
	private Map<String, ObjectTransfer> connectedClients;
	private ChatServerModel chatServerModel;
	private String nickname;

	/**
	 * Constructs a new object of the class {@link User} assigning values to its variables.
	 * 
	 * @param objectTransfer
	 *            the object for manipulating the streams of the client
	 * @param chatServerModel
	 *            the frame of the server
	 * @param connectedClients
	 *            a map of the connected clients
	 */
	public User(ObjectTransfer objectTransfer, ChatServerModel chatServerModel,
			Map<String, ObjectTransfer> connectedClients) {
		this.chatServerModel = chatServerModel;
		this.objectTransfer = objectTransfer;
		this.connectedClients = connectedClients;
	}

	@Override
	public void run() {
		boolean existentNickname = false;
		ResourceBundle translation = Language.getTranslation();
		Message welcomeMessage = new Message().attachContents(translation
				.getString(ConstantsChat.WELCOME));
		Message message;
		Message connected = new Message();
		welcomeMessage.setType(ConstantsChat.NEW_USER);
		objectTransfer.writeObject(welcomeMessage);
		try {
			while (true) {
				message = objectTransfer.readObject();
				nickname = message.getNickname();
				for (String client : connectedClients.keySet()) {
					if (client.equalsIgnoreCase(nickname)) {
						message.setType(ConstantsChat.EXISTENT_NICKNAME);
						objectTransfer.writeObject(message);
						existentNickname = true;
						break;
					}
					existentNickname = false;
				}
				if (!existentNickname) {
					chatServerModel.registerUser(objectTransfer, nickname);
					break;
				}
			}
			connectedClients.put(nickname, objectTransfer);
			objectTransfer.writeObject(connected);
		} catch (IOException e) {
			LOGGER.error(ConstantsChat.NO_ACTIVE_CONNECTION, e);
		}
		communicate();
	}

	/**
	 * Realizes the communication among clients as well as sending the list of clients.
	 */
	public void communicate() {
		try {
			while (true) {
				Message message = objectTransfer.readObject();
				for (Entry<String, ObjectTransfer> client : connectedClients.entrySet()) {
					if (ConstantsChat.TEXT_MESSAGE.equals(message.getType())) {
						client.getValue().writeObject(message);
					}
				}
			}
		} catch (IOException e) {
			LOGGER.error(ConstantsChat.NO_ACTIVE_CONNECTION, e);
			chatServerModel.unregisterUser(objectTransfer, nickname);
			connectedClients.remove(nickname);
		}

	}
}
