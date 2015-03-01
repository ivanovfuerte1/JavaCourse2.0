package com.sirma.itt.javacourse.client;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientCommunicationModel} contains a method for reading messages, displaying
 * their sender and content.
 */
public class ClientCommunicationModel extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ClientCommunicationModel.class);
	private ClientCommunicationView clientCommunicatorView;
	private ObjectTransfer objectTransfer;
	private String nickname;

	/**
	 * Constructs a new thread assigning values for window and streams container.
	 * 
	 * @param clientCommunicatorView
	 *            the window for communication of the current client
	 * @param objectTransfer
	 *            the object having the streams of the current socket
	 * @param nickname
	 *            the nickname of the client
	 */
	public ClientCommunicationModel(ClientCommunicationView clientCommunicatorView,
			ObjectTransfer objectTransfer, String nickname) {
		this.clientCommunicatorView = clientCommunicatorView;
		this.objectTransfer = objectTransfer;
		this.nickname = nickname;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Message message = objectTransfer.readObject();
				if (ConstantsChat.STOP_READING.equals(message.getMessageContents())) {
					break;
				}
				if (ConstantsChat.TEXT_MESSAGE.equals(message.getType())) {
					clientCommunicatorView.setOutputMessageAreaContent(message.getNickname()
							+ ConstantsChat.COLON + message.getMessageContents());
				}
				if (ConstantsChat.NEW_USER.equals(message.getType())) {
					clientCommunicatorView.setOutputMessageAreaContent(ConstantsChat.CLIENT
							+ message.getNickname() + ConstantsChat.CONNECTED);
					clientCommunicatorView.setListOfClientsContent(message.getMessageContents());
				}
				if (ConstantsChat.USER_LIST.equals(message.getType())) {
					clientCommunicatorView.setListOfClientsContent(message.getMessageContents());
				}
				if (ConstantsChat.USER_DISCONNECTED.equals(message.getType())) {
					clientCommunicatorView.setOutputMessageAreaContent(ConstantsChat.CLIENT
							+ message.getNickname() + ConstantsChat.LEFT);
					clientCommunicatorView.setListOfClientsContent(message.getMessageContents());
				}
			}
		} catch (IOException e) {
			LOGGER.error(ConstantsChat.NO_ACTIVE_CONNECTION, e);
			clientCommunicatorView.setListOfClientsContent(ConstantsChat.EMPTY_STRING);
			clientCommunicatorView.setOutputMessageAreaContent(ConstantsChat.NO_ACTIVE_CONNECTION);
		}
	}

	/**
	 * Sets the content for the message of the current thread.
	 * 
	 * @param text
	 *            the content to set
	 */
	public synchronized void sendMessage(String text) {
		Message message = new Message().attachNickname(nickname).attachContents(text);
		message.setType(ConstantsChat.TEXT_MESSAGE);
		objectTransfer.writeObject(message);
	}

	/**
	 * Disconnects a client.
	 */
	public synchronized void disconnectClient() {
		objectTransfer.writeObject(new Message().attachNickname(nickname).attachContents(
				ConstantsChat.STOP_THREAD));
		objectTransfer.closeStreams();
		interrupt();
	}
}
