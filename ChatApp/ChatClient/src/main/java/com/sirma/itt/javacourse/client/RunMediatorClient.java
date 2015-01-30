package com.sirma.itt.javacourse.client;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link RunMediatorClient} contains a method for displaying a new window for
 * communication among clients.
 */
public class RunMediatorClient extends Thread {
	// LATER IT WILL IMPLEMENT RUNNABLE AND EXTEND USER (MAYBE)

	private ClientConnectorFrame client;
	private String nickname;
	private static final Logger LOGGER = LogManager.getLogger(RunMediatorClient.class);

	/**
	 * Constructs a new thread for each client.
	 * 
	 * @param client
	 *            the client to construct a thread for
	 */
	public RunMediatorClient(ClientConnectorFrame client) {
		this.client = client;
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
				Message welcomeMessage = objectTransfer.readObject();
				// THIS IS WELCOME MESSAGE - 1ST
				client.setInfo(welcomeMessage.getMessageContents());
				do {
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
						ClientView clientView = new ClientView(nickname, objectTransfer);
						clientView.setVisible(true);
						client.dispose();
						break;
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

	// /**
	// * Displays a new window for communication among clients.
	// *
	// * @param nickname
	// * the nickname of the new client
	// * @param mediatorInterface
	// * the mediator for selecting the destination of the sent messages
	// */
	// public void connect(String nickname, MediatorInterface mediatorInterface) {
	// // SENDING MEDIATOR TO CLIENTCONNECTORFRAME DIDN'T CHANGE ANYTHING BY NOW. ANYWAY, THE FULL
	// // CLASS IS PLANNED TO BE MOVED THERE.
	// // MediatorInterface mediatorInterface = new Mediator();
	// Socket socket = null;
	// try {
	// socket = new Socket(ConstantsChat.LOCAL_HOST, ConstantsChat.TARGET_PORT);
	// } catch (UnknownHostException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	//
	// ClientView clientView = new ClientView(nickname, new ObjectTransfer(socket));
	// clientView.setVisible(true);
	// User firstUser = new UserImplementation(mediatorInterface, nickname, clientView);
	//
	// mediatorInterface.addUser(firstUser);
	// // firstUser.send("Hello");
	// }
}
