package com.sirma.itt.javacourse.client;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Mediator;
import com.sirma.itt.javacourse.common.MediatorInterface;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;
import com.sirma.itt.javacourse.common.User;

/**
 * The class {@link ClientConnectionThread} contains methodS for communication among clients.
 */
public class ClientConnectionThread extends User implements Runnable {
	private ClientConnectionFrame client;
	private String nickname;
	private MediatorInterface mediatorInterface;
	private Message welcomeMessage;
	private static final Logger LOGGER = LogManager.getLogger(ClientConnectionThread.class);

	/**
	 * Constructs a new thread for each client.
	 * 
	 * @param client
	 *            the client to construct a thread for
	 * @param mediatorInterface
	 *            the mediator of the current client
	 * @param nickname
	 *            the nickname of the current client
	 */
	public ClientConnectionThread(MediatorInterface mediatorInterface, String nickname,
			ClientConnectionFrame client) {
		super(mediatorInterface, nickname);
		this.client = client;
		this.mediatorInterface = mediatorInterface;
	}

	/**
	 * Notifies the client when a new message is sent.
	 */
	public synchronized void notifyClient() {
		notify();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		synchronized (this) {
			Socket socket;
			Message message = new Message();
			try {
				socket = new Socket(ConstantsChat.LOCAL_HOST, ConstantsChat.TARGET_PORT);
				ObjectTransfer objectTransfer = new ObjectTransfer(socket);
				welcomeMessage = objectTransfer.readObject();
				// THIS IS WELCOME MESSAGE - 1ST. NEXT ROWS IMPLEMENT MEDIATOR.
				mediatorInterface = new Mediator();
				mediatorInterface.addUser(this);
				receive(welcomeMessage.getMessageContents());
				while (true) {
					try {
						wait();
					} catch (InterruptedException e) {
						LOGGER.error("A thread is interrupted while sleeping", e);
					}
					message.setNickname(nickname);
					objectTransfer.writeObject(message);
					// NICKNAME SENT -> NICKNAME APPROVAL/DENIAL RECEIVED
					message = objectTransfer.readObject();
					if (message.getMessageContents().contains(nickname)) {
						client.setInfo(message.getMessageContents());
					}
					if ("You are connected.".equals(message.getMessageContents())) {
						client.setInfo(message.getMessageContents());
						ClientCommunicationFrame clientCommunicationFrame = new ClientCommunicationFrame(
								nickname, objectTransfer);
						clientCommunicationFrame.setVisible(true);
						// INITIALIZE COMMUNICATION THREAD HERE. IN THIS CASE OBJECT TRANSFER WOULD
						// NOT BE NEEDED IN COMUNICATION FRAME.
						client.dispose();
						break;
					}
				}
			} catch (IOException e) {
				LOGGER.error(ConstantsChat.INPUT_OUTPUT_FAIL, e);
				// HERE CAN BE DISPLAYED A WINDOW, EXPLAINING THAT THE SERVER HAS STOPPED
				client.setInfo(ConstantsChat.SERVER_STOPPED);
			}
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

	@Override
	public void send(String message) {
	}

	@Override
	public void receive(String message) {
		System.out
				.println(this.getNickname() + ": Received Message="
						+ welcomeMessage.getMessageContents() + ".Destination: "
						+ welcomeMessage.getType());
		client.setInfo(welcomeMessage.getMessageContents());

	}

}
