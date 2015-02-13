package com.sirma.itt.javacourse.client;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientCommunicationThread} contains a method for reading messages, displaying
 * their sender and content.
 */
public class ClientCommunicationThread extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ClientCommunicationThread.class);
	private ClientCommunicationFrame clientCommunicatorFrame;
	private ObjectTransfer objectTransfer;
	private String nickname;

	/**
	 * Constructs a new thread assigning values for window and streams container.
	 * 
	 * @param clientCommunicatorFrame
	 *            the window for communication of the current client
	 * @param objectTransfer
	 *            the object having the streams of the current socket
	 * @param nickname
	 *            the nickname of the client
	 */
	public ClientCommunicationThread(ClientCommunicationFrame clientCommunicatorFrame,
			ObjectTransfer objectTransfer, String nickname) {
		this.clientCommunicatorFrame = clientCommunicatorFrame;
		this.objectTransfer = objectTransfer;
		this.nickname = nickname;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Message message = objectTransfer.readObject();
				if ("Stop reading".equals(message.getMessageContents())) {
					break;
				}
				if ("textMessage".equals(message.getType())) {
					clientCommunicatorFrame.setOutputFieldContent(message.getNickname() + ": "
							+ message.getMessageContents());
				}
				if ("newUser".equals(message.getType())) {
					clientCommunicatorFrame.setOutputFieldContent("A new client with "
							+ message.getNickname() + " connected.");
					clientCommunicatorFrame.setListOfClientsContent(message.getMessageContents());
				}
				if ("userList".equals(message.getType())) {
					clientCommunicatorFrame.setListOfClientsContent(message.getMessageContents());
				}
				if ("userDisconnected".equals(message.getType())) {
					clientCommunicatorFrame.setOutputFieldContent("Client " + message.getNickname()
							+ " left.");
					clientCommunicatorFrame.setListOfClientsContent(message.getMessageContents());
				}
			}
		} catch (IOException e) {
			LOGGER.error("There is no active connection", e);
			clientCommunicatorFrame.setListOfClientsContent("");
			clientCommunicatorFrame.setOutputFieldContent("There is no active connection");
		}
	}

	/**
	 * Sets the content for the message of the current thread.
	 * 
	 * @param text
	 *            the content to set
	 */
	public synchronized void sendMessage(String text) {
		Message message = new Message(nickname, text);
		message.setType("textMessage");
		objectTransfer.writeObject(message);
	}

	/**
	 * Disconnects a client.
	 */
	public synchronized void disconnectClient() {
		objectTransfer.writeObject(new Message(nickname, "Stop thread"));
		objectTransfer.closeStreams();
		interrupt();
	}
}
