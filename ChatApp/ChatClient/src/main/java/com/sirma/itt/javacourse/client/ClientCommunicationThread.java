package com.sirma.itt.javacourse.client;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientCommunicationThread} contains a method for reading messages, displaying
 * their sender and content.
 */
public class ClientCommunicationThread extends Thread {
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
		Message listOfClients = objectTransfer.readObject();
		clientCommunicatorFrame.setListOfClientsContent(listOfClients.getMessageContents());
		while (true) {
			Message message = objectTransfer.readObject();
			if (message == null || "Stop reading".equals(message.getMessageContents())) {
				break;
			}
			clientCommunicatorFrame.setOutputFieldContent(message.getNickname() + ": "
					+ message.getMessageContents());
			Message list = objectTransfer.readObject();
			clientCommunicatorFrame.setListOfClientsContent(list.getMessageContents());
		}
	}

	/**
	 * Sets the content for the message of the current thread.
	 * 
	 * @param message
	 *            the content to set
	 */
	public synchronized void sendMessage(String message) {
		objectTransfer.writeObject(new Message(nickname, message));
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
