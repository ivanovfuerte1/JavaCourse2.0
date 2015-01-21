package com.sirma.itt.javacourse.chat.server;

import java.util.Map;

import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

/**
 * The class {@link NewChatCommunication} contains a method for running a thread for reading
 * messages from the client and sending messages to him.
 */
public class NewChatCommunication extends Thread {
	private Map<ObjectTransfer, String> connectedClients;
	private ObjectTransfer objectTransfer;

	// private ChatServerFrame chatServerFrame;

	/**
	 * Constructs a new line for communication between client and server.
	 * 
	 * @param objectTransfer
	 *            the object for transferring data between server and client
	 * @param connectedClients
	 *            the map of the connected clients
	 */
	public NewChatCommunication(ObjectTransfer objectTransfer,
			Map<ObjectTransfer, String> connectedClients) {
		this.objectTransfer = objectTransfer;
		this.connectedClients = connectedClients;
	}

	@Override
	public void run() {
		StringBuilder stringBuilder = new StringBuilder();
		final String newLine = System.lineSeparator();
		for (String nickname : connectedClients.values()) {
			stringBuilder.append(nickname);
			stringBuilder.append(newLine);
		}
		System.out.println("By now stringbuilder contains: " + stringBuilder);
		Message listOfClients = new Message();
		listOfClients.setMessageContents(stringBuilder.toString());

		while (true) {
			Message message = objectTransfer.readObject();
			if (message == null || "Stop thread".equals(message.getMessageContents())) {
				// chatServerFrame.setTextFieldContent("A client disconnected.");
				connectedClients.remove(objectTransfer);
				objectTransfer.writeObject(new Message("", "Stop reading"));
				// chatServerFrame.setTextFieldContent("Client " + objectTransfer.toString()
				// + " disconnected.");
				break;
			}
			for (ObjectTransfer client : connectedClients.keySet()) {
				client.writeObject(message);
				client.writeObject(listOfClients);
			}
		}
	}

}
