package com.sirma.itt.javacourse.client;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientReadThread} contains a method for reading messages, displaying their
 * sender and content.
 */
public class ClientReadThread extends Thread {
	private ClientView clientCommunicatorFrame;
	private ObjectTransfer objectTransfer;

	/**
	 * Constructs a new thread assigning values for window and streams container.
	 * 
	 * @param clientCommunicatorFrame
	 *            the window for communication of the current client
	 * @param objectTransfer
	 *            the object having the streams of the current socket
	 */
	public ClientReadThread(ClientView clientCommunicatorFrame, ObjectTransfer objectTransfer) {
		this.clientCommunicatorFrame = clientCommunicatorFrame;
		this.objectTransfer = objectTransfer;
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
			// THIS ROW SHOULD BE REMOVED VERY CAREFULLY
			Message list = objectTransfer.readObject();
			clientCommunicatorFrame.setListOfClientsContent(list.getMessageContents());
		}
	}
}
