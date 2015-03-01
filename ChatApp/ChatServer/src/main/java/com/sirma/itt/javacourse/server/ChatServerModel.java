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
 * The class {@link ChatServerModel} contains a method for connecting new clients and saving them to
 * its list.
 */
public class ChatServerModel extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ChatServerModel.class);
	private ServerSocket serverSocket;
	private ChatServerView chatServerView;
	private Map<String, ObjectTransfer> clients = new LinkedHashMap<>();
	private List<ObjectTransfer> unregisteredUsers = new ArrayList<>();

	/**
	 * Constructs an object of {@link ChatServerModel}.
	 * 
	 * @param chatServerView
	 *            the frame of the server
	 */
	public ChatServerModel(ChatServerView chatServerView) {
		this.chatServerView = chatServerView;
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(ConstantsChat.TARGET_PORT);
			while (true) {
				ObjectTransfer objectTransfer = new ObjectTransfer(serverSocket.accept());
				unregisteredUsers.add(objectTransfer);
				new Thread(new User(objectTransfer, this, clients)).start();
			}
		} catch (IOException e) {
			LOGGER.error(ConstantsChat.INPUT_OUTPUT_FAIL, e);
		}
	}

	/**
	 * Registers a new client into the map of clients.
	 * 
	 * @param objectTransfer
	 *            the object for manipulating the streams of the client
	 * @param nickname
	 *            the nickname of the client
	 */
	public void registerUser(ObjectTransfer objectTransfer, String nickname) {
		clients.put(nickname, objectTransfer);
		Message connectionMessage = new Message();
		connectionMessage.setType(ConstantsChat.YOU_ARE_CONNECTED);
		objectTransfer.writeObject(connectionMessage);

		Message message = makeListOfClients();
		message.setType(ConstantsChat.USER_LIST);
		for (Entry<String, ObjectTransfer> client : clients.entrySet()) {
			client.getValue().writeObject(message);
		}
		chatServerView.setInformationAreaContent(ConstantsChat.CLIENT + nickname
				+ ConstantsChat.CONNECTED);
		chatServerView.setInformationAreaContent(ConstantsChat.NEW_THREAD + nickname
				+ ConstantsChat.STARTED);
		unregisteredUsers.remove(objectTransfer);
	}

	/**
	 * Removes a client from the list of clients.
	 * 
	 * @param objectTransfer
	 *            the object for manipulating the streams of the client
	 * @param nickname
	 *            the nickname of the client
	 */
	public void unregisterUser(ObjectTransfer objectTransfer, String nickname) {
		clients.remove(nickname);
		Message message = makeListOfClients();
		message.setNickname(nickname);
		message.setType(ConstantsChat.USER_DISCONNECTED);
		for (Entry<String, ObjectTransfer> client : clients.entrySet()) {
			client.getValue().writeObject(message);
		}
		chatServerView.setInformationAreaContent(ConstantsChat.CLIENT + nickname
				+ ConstantsChat.DISCONNECTED);
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
			LOGGER.error(ConstantsChat.INPUT_OUTPUT_FAIL, e);
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
}
