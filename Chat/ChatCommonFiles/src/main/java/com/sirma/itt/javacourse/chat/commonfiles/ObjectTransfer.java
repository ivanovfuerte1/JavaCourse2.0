package com.sirma.itt.javacourse.chat.commonfiles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObjectTransfer {
	private Socket socket;
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	private static final Logger LOGGER = LogManager.getLogger(ObjectTransfer.class);

	public ObjectTransfer(Socket socket) {
		this.socket = socket;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			LOGGER.error("An input-output operation is failed or interrupted", e);
		}
	}

	public void closeStreams() {
		try {
			objectInputStream.close();
			objectOutputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	public void writeObject(Message message) {
		try {
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
		} catch (IOException e) {
			LOGGER.error("An input-output operation is failed or interrupted", e);
		}
	}

}
