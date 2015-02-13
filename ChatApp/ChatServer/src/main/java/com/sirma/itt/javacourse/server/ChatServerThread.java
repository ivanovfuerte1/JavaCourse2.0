package com.sirma.itt.javacourse.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ChatServerThread} contains a method for connecting new clients and saving them
 * to its list.
 */
public class ChatServerThread extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ChatServerThread.class);
	private ServerSocket serverSocket;
	private ChatServerFrame chatServerFrame;
	private Map<String, ObjectTransfer> clients = new LinkedHashMap<>();
	private List<ObjectTransfer> unregisteredUsers = new ArrayList<>();

	/**
	 * Constructs an object of {@link ChatServerThread}.
	 * 
	 * @param chatServerFrame
	 *            the frame of the server
	 */
	public ChatServerThread(ChatServerFrame chatServerFrame) {
		this.chatServerFrame = chatServerFrame;
	}

	@Override
	public void run() {
		try {
			this.serverSocket = new ServerSocket(ConstantsChat.TARGET_PORT);
			while (true) {
				ObjectTransfer objectTransfer = new ObjectTransfer(serverSocket.accept());
				unregisteredUsers.add(objectTransfer);
				new Thread(new User(objectTransfer, this, clients)).start();
			}
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * @param objectTransfer
	 *            a
	 * @param nickname
	 *            a
	 */
	public void registerUser(ObjectTransfer objectTransfer, String nickname) {
		clients.put(nickname, objectTransfer);
		Message connectionMessage = new Message();
		connectionMessage.setType("You are connected.");
		objectTransfer.writeObject(connectionMessage);
		Message message = makeListOfClients();
		message.setType("userList");
		for (Entry<String, ObjectTransfer> client : clients.entrySet()) {
			client.getValue().writeObject(message);
		}
		chatServerFrame.setTextFieldContent("Client " + nickname + " connected.");
		chatServerFrame.setTextFieldContent("A new thread for " + nickname + " started.");
		unregisteredUsers.remove(objectTransfer);
	}

	/**
	 * @param objectTransfer
	 *            a
	 * @param nickname
	 *            a
	 */
	public void unregisterUser(ObjectTransfer objectTransfer, String nickname) {
		clients.remove(nickname);
		Message message = makeListOfClients();
		message.setNickname(nickname);
		message.setType("userDisconnected");
		for (Entry<String, ObjectTransfer> client : clients.entrySet()) {
			client.getValue().writeObject(message);
		}
		chatServerFrame.setTextFieldContent("Client " + nickname + " disconnected.");

	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		try {
			serverSocket.close();
			for (Entry<String, ObjectTransfer> client : clients.entrySet()) {
				client.getValue().closeStreams();
			}
			for (ObjectTransfer objectTransfer : unregisteredUsers) {
				objectTransfer.closeStreams();
			}
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * Makes a list of clients and assigns it to the contents of a message.
	 * 
	 * @return a message containing the actual list of clients
	 */
	private Message makeListOfClients() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String nickname : clients.keySet()) {
			stringBuilder.append(nickname);
			stringBuilder.append(ConstantsChat.LINE_SEPARATOR);
		}
		Message listOfClients = new Message();
		listOfClients.setMessageContents(stringBuilder.toString());
		return listOfClients;
	}

	/**
	 * Getter method for chatServerFrame.
	 *
	 * @return the chatServerFrame
	 */
	public ChatServerFrame getChatServerFrame() {
		return chatServerFrame;
	}
}
