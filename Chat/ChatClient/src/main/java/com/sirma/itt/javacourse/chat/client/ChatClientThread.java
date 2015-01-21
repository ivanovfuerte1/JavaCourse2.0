package com.sirma.itt.javacourse.chat.client;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.chat.commonfiles.ConstantsChat;
import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

/**
 * The class {@link ChatClientThread} contains methods for running a new thread for each client.
 */
public class ChatClientThread extends Thread {
	private ClientConnectorFrame client;
	private String nickname;
	private static final Logger LOGGER = LogManager.getLogger(ChatClientThread.class);

	/**
	 * Constructs a new thread for each client.
	 * 
	 * @param client
	 *            the client to construct a thread for
	 */
	public ChatClientThread(ClientConnectorFrame client) {
		this.client = client;
	}

	/**
	 * Notifies the client when a new message is sent.
	 */
	public synchronized void notifyClient() {
		notify();
	}

	@Override
	public void run() {
		synchronized (this) {
			Socket socket;
			try {
				socket = new Socket(ConstantsChat.LOCAL_HOST, ConstantsChat.TARGET_PORT);
				ObjectTransfer objectTransfer = new ObjectTransfer(socket);
				Message message = objectTransfer.readObject();
				client.setInfo(message.getMessageContents());
				do {
					try {
						wait();
					} catch (InterruptedException e) {
						LOGGER.error("A thread is interrupted while sleeping", e);
					}
					message.setNickname(nickname);
					objectTransfer.writeObject(message);
					message = objectTransfer.readObject();
					client.setInfo(message.getMessageContents());
					if ("You are connected.".equals(message.getMessageContents())) {
						new ClientCommunicatorFrame(nickname, objectTransfer).setVisible(true);
						client.dispose();
						break;
						// interrupt();
					}
				} while (message != null);
			} catch (IOException e) {
				LOGGER.error(ConstantsChat.INPUT_OUTPUT_FAIL, e);
			}
			client.setInfo(ConstantsChat.SERVER_STOPPED);
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
