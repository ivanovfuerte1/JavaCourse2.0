package com.sirma.itt.javacourse.server;

import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.Language;
import com.sirma.itt.javacourse.common.MediatorInterface;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;
import com.sirma.itt.javacourse.common.User;

/**
 * The class {@link NewChatClient} contains a method for sending welcome message to a new client and
 * communicating all connected clients for the event.
 */
public class NewChatClient extends User implements Runnable {
	private ObjectTransfer objectTransfer;
	// CHECK THIS LATER
	private static int maxCapacity = 10;
	private static Map<ObjectTransfer, String> connectedClients = new LinkedHashMap<>(maxCapacity,
			1.0f, true);
	private ResourceBundle messages = Language.getMessages();
	private ChatServerFrame chatServerFrame;
	private static final Logger LOGGER = LogManager.getLogger(NewChatClient.class);

	/**
	 * Constructs a new object of the class {@link NewChatClient} assigning values to its variables.
	 * 
	 * @param mediatorInterface
	 *            the mediator of the current client
	 * @param nickname
	 *            the nickname of the current client
	 * @param socket
	 *            the socket of the current client
	 * @param chatServerFrame
	 *            the frame of the server
	 */
	public NewChatClient(MediatorInterface mediatorInterface, String nickname, Socket socket,
			ChatServerFrame chatServerFrame) {
		super(mediatorInterface, nickname);
		this.chatServerFrame = chatServerFrame;
		this.objectTransfer = new ObjectTransfer(socket);
	}

	@Override
	public void run() {
		boolean existentNickname = false;
		String currentNickname;
		Message message;
		Message connected = new Message();
		objectTransfer.writeObject(new Message("", messages.getString("Welcome")));
		try {
			while (true) {
				message = objectTransfer.readObject();
				currentNickname = message.getNickname();
				for (String nickname : connectedClients.values()) {
					if (nickname.equalsIgnoreCase(currentNickname)) {
						message.setMessageContents(currentNickname + " "
								+ messages.getString("alreadyExists"));
						// new IncorrectNicknameFrame().setVisible(true);
						objectTransfer.writeObject(message);
						existentNickname = true;
						break;
					}
					existentNickname = false;
				}
				if (!existentNickname) {
					connected.setMessageContents("You are connected.");
					break;
				}
			}
			connectedClients.put(objectTransfer, currentNickname);
			System.out.println("The number of onnected clients is: " + connectedClients.size());
			objectTransfer.writeObject(connected);
		} catch (NullPointerException e) {
			LOGGER.error("There is no message to read.", e);
		}
		communicate();
	}

	/**
	 * Realizes the communication among clients as well as sending the list of clients.
	 */
	private void communicate() {

		chatServerFrame.setTextFieldContent("Client " + connectedClients.get(objectTransfer)
				+ " connected.");
		chatServerFrame.setTextFieldContent("A new thread for "
				+ connectedClients.get(objectTransfer) + " started.");

		StringBuilder stringBuilder = new StringBuilder();
		final String newLine = System.lineSeparator();
		for (String nickname : connectedClients.values()) {
			stringBuilder.append(nickname);
			stringBuilder.append(newLine);
		}
		Message listOfClients = new Message();
		listOfClients.setMessageContents(stringBuilder.toString());
		objectTransfer.writeObject(listOfClients);

		while (true) {
			Message message = objectTransfer.readObject();
			if (message == null || "Stop thread".equals(message.getMessageContents())) {
				chatServerFrame.setTextFieldContent("Client "
						+ connectedClients.get(objectTransfer) + " disconnected.");
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

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receive(String message) {
		// TODO Auto-generated method stub

	}
}
