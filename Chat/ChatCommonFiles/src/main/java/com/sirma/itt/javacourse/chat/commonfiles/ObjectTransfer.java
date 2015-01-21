package com.sirma.itt.javacourse.chat.commonfiles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ObjectTransfer} contains methods for transferring data from server to client and
 * vice versa.
 */
public class ObjectTransfer {
	private Socket socket;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private static final Logger LOGGER = LogManager.getLogger(ObjectTransfer.class);

	/**
	 * Construct an object of {@link ObjectTransfer} assigning input and output streams of a client
	 * to its variables.
	 * 
	 * @param socket
	 *            the socket of the current client
	 */
	public ObjectTransfer(Socket socket) {
		this.socket = socket;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			LOGGER.error("An input-output operation is failed or interrupted", e);
		}
	}

	/**
	 * Closes the streams used.
	 */
	public void closeStreams() {
		try {
			objectInputStream.close();
			objectOutputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads a message from server to client or vice versa.
	 * 
	 * @return the message read
	 */
	public Message readObject() {
		Message message = null;
		try {
			message = (Message) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			LOGGER.error("no definition for the class with the specified name could be found", e);
		} catch (IOException e) {
			LOGGER.error("An input-output operation is failed or interrupted", e);
		}
		return message;
	}

	/**
	 * Sends a message from server to client or vice versa.
	 * 
	 * @param message
	 *            the message to send
	 */
	public void writeObject(Message message) {
		try {
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
		} catch (IOException e) {
			LOGGER.error("An input-output operation is failed or interrupted", e);
		}
	}

}
