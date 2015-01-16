package com.sirma.itt.javacourse.chat.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

public class ClientWriteThread extends Thread {
	private String nickname;
	private Message message = new Message();
	private ObjectTransfer objectTransfer;
	private static final Logger LOGGER = LogManager.getLogger(ClientWriteThread.class);
	boolean clientFinished = false;

	public ClientWriteThread(String nickname, ObjectTransfer objectTransfer) {
		this.nickname = nickname;
		this.objectTransfer = objectTransfer;
		System.out.println(nickname);
		System.out.println(message.getMessageContents());
	}

	public synchronized void setMessage(String message) {
		// this.message = message;
		// this.message.setNickname(nickname);
		this.message = new Message(nickname, message);
		// this.message.setMessageContents(message);
		notify();
	}

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
