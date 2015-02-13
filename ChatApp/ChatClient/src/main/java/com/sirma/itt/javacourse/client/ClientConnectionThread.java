package com.sirma.itt.javacourse.client;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientConnectionThread} contains methodS for communication among clients.
 */
public class ClientConnectionThread {
	private ClientConnectionFrame client;
	private String nickname;
	private Message welcomeMessage;
	private static final Logger LOGGER = LogManager.getLogger(ClientConnectionThread.class);
	private Socket socket;
	private ObjectTransfer objectTransfer;

	/**
	 * Constructs a new thread for each client.
	 * 
	 * @param client
	 *            the client to construct a thread for
	 */
	public ClientConnectionThread(ClientConnectionFrame client) {
		this.client = client;
		connect();
	}

	/**
	 * 
	 */
	public void connect() {
		try {
			socket = new Socket(ConstantsChat.LOCAL_HOST, ConstantsChat.TARGET_PORT);
			objectTransfer = new ObjectTransfer(socket);
			welcomeMessage = objectTransfer.readObject();
			client.setInfo(welcomeMessage.getMessageContents());
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * 
	 */
	public void sendUserInfo() {
		Message message = new Message();
		message.setNickname(nickname);
		try {
			objectTransfer.writeObject(message);
			message = objectTransfer.readObject();
		} catch (IOException e) {
			client.setInfo(ConstantsChat.SERVER_STOPPED);
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
		if ("Existent nickname".equals(message.getType())) {
			client.setInfo(nickname + "alreadyExists");
			new IncorrectNicknameFrame().setVisible(true);
		}
		if ("You are connected.".equals(message.getType())) {
			client.setInfo(message.getMessageContents());
			ClientCommunicationFrame clientCommunicationFrame = new ClientCommunicationFrame(
					nickname, objectTransfer);
			clientCommunicationFrame.setVisible(true);
			client.dispose();
		}
	}

	/**
	 * Returns the nickname of the current client.
	 * 
	 * @return the nickname of the current client
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Sets a new nickname.
	 * 
	 * @param nickname
	 *            the new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
