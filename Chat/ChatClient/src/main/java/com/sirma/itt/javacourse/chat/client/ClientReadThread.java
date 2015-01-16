package com.sirma.itt.javacourse.chat.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

public class ClientReadThread extends Thread {
	private ClientCommunicatorFrame clientCommunicatorFrame;
	private ObjectTransfer objectTransfer;
	StringBuilder messageString = new StringBuilder();
	private static final Logger LOGGER = LogManager.getLogger(ClientReadThread.class);

	public ClientReadThread(ClientCommunicatorFrame clientCommunicatorFrame,
			ObjectTransfer objectTransfer) {
		this.clientCommunicatorFrame = clientCommunicatorFrame;
		this.objectTransfer = objectTransfer;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Message message = objectTransfer.readObject();
				if (message.getMessageContents().equals("Stop reading")) {
					break;
				}
				System.out.println("Print ouput");
				clientCommunicatorFrame.setOutputFieldContent(message.getNickname() + ": "
						+ message.getMessageContents());
				Message list = objectTransfer.readObject();
				clientCommunicatorFrame.setListOfClientsContent(list.getMessageContents());
			}
		} catch (NullPointerException e) {
			LOGGER.error("The cast was not successful", e);
			// WHY CAN'T I ADD A SocketException DESPITE IT CAN BE THROWN FROM HERE?
			// IS THIS LOG CORRECT?
		}
	}
}
