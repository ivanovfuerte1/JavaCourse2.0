package com.sirma.itt.javacourse.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientWriteThread} contains setting a message to send and sending it from the
 * server to the client.
 */
public class ClientWriteThread extends Thread {
	private String nickname;
	private Message message = new Message();
	private ObjectTransfer objectTransfer;
	private static final Logger LOGGER = LogManager.getLogger(ClientWriteThread.class);
	private boolean clientFinished = false;

	/**
	 * constructs an object of {@link ClientWriteThread} assigning values to its variable for
	 * nickname and ObjectTransfer.
	 * 
	 * @param nickname
	 *            the nickname of the current thread
	 * @param objectTransfer
	 *            the ObjectTransfer used for the current thread
	 */
	public ClientWriteThread(String nickname, ObjectTransfer objectTransfer) {
		this.nickname = nickname;
		this.objectTransfer = objectTransfer;
	}

	/**
	 * Sets the content for the message of the current thread.
	 * 
	 * @param message
	 *            the content to set
	 */
	public synchronized void setMessage(String message) {
		this.message = new Message(nickname, message);
		notify();
	}

	/**
	 * Disconnects a client.
	 */
	public synchronized void disconnectClient() {
		clientFinished = true;
		notify();
	}

	@Override
	public void run() {
		synchronized (this) {
			while (true) {
				try {
					wait();
					if (clientFinished) {
						objectTransfer.writeObject(new Message(nickname, "Stop thread"));
						break;
					}
				} catch (InterruptedException e) {
					LOGGER.error("The ClientWriteThread was interrupted while waiting", e);
				}
				objectTransfer.writeObject(message);
			}
		}
	}
}