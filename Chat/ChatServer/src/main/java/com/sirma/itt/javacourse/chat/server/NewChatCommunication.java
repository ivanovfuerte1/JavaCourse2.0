package com.sirma.itt.javacourse.chat.server;

import java.util.Map;

import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

public class NewChatCommunication extends Thread {
	Map<ObjectTransfer, String> connectedClients;
	ObjectTransfer objectTransfer;

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
			if (message == null || message.getMessageContents().equals("Stop thread")) {
				connectedClients.remove(objectTransfer);
				objectTransfer.writeObject(new Message("", "Stop reading"));

				break;
			}
			for (ObjectTransfer client : connectedClients.keySet()) {
				client.writeObject(message);
				client.writeObject(listOfClients);
			}
		}
	}

}
