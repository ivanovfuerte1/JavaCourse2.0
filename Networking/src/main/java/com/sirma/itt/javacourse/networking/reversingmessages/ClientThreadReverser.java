package com.sirma.itt.javacourse.networking.reversingmessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ClientThreadReverser} contains methods for running a new thread for each client.
 */
public class ClientThreadReverser extends Thread {
	private ClientReverser client;
	private String messageToReverse;
	private Socket socket;
	private static final Logger LOGGER = LogManager.getLogger(ClientThreadReverser.class);

	/**
	 * Constructs a new thread for each client.
	 * 
	 * @param client
	 *            the client to construct a thread for
	 */
	public ClientThreadReverser(ClientReverser client) {
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
			try (Socket socket = new Socket(ConstantsReverser.LOCAL_HOST,
					ConstantsReverser.TARGET_PORT);
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);) {
				this.socket = socket;
				String message;
				message = bufferedReader.readLine();
				client.setInfo(message);
				do {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					socketWriter.println(messageToReverse);
					message = bufferedReader.readLine();
					client.setInfo(message);
				} while (message != null);
			} catch (IOException e) {
				LOGGER.error(ConstantsReverser.INPUT_OUTPUT_FAIL, e);
			}
			client.setInfo(ConstantsReverser.SERVER_STOPPED);
		}
	}

	/**
	 * Returns the message to reverse.
	 * 
	 * @return the message to reverse
	 */
	public String getMessageToReverse() {
		return messageToReverse;
	}

	/**
	 * Sets a new message to reverse.
	 * 
	 * @param messageToReverse
	 *            the new message to reverse
	 */
	public void setMessageToReverse(String messageToReverse) {
		if (ConstantsReverser.END_REVERSING.equals(messageToReverse)) {
			try {
				socket.close();
			} catch (IOException e) {
				LOGGER.error(ConstantsReverser.INPUT_OUTPUT_FAIL, e);
			}
			interrupt();
		}
		this.messageToReverse = messageToReverse;
	}

}
