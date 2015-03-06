package com.sirma.itt.javacourse.client;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientConnectionModel} contains methodS for communication among clients.
 */
public class ClientConnectionModel {
	private ClientConnectionView clientConnectionView;
	private Message welcomeMessage;
	private static final Logger LOGGER = LogManager.getLogger(ClientConnectionModel.class);
	private Socket socket;
	private ObjectTransfer objectTransfer;

	/**
	 * Returns the objectTransfer.
	 *
	 * @return the objectTransfer
	 */
	public ObjectTransfer getObjectTransfer() {
		return objectTransfer;
	}

	/**
	 * Constructs a new thread for each client.
	 * 
	 * @param client
	 *            the client to construct a thread for
	 */
	public ClientConnectionModel(ClientConnectionView client) {
		this.clientConnectionView = client;
		connect();
	}

	/**
	 * Establishes a connection with the server.
	 */
	public void connect() {
		try {
			socket = new Socket(ConstantsChat.LOCAL_HOST, ConstantsChat.TARGET_PORT);
			objectTransfer = new ObjectTransfer(socket);
			welcomeMessage = objectTransfer.readObject();
			clientConnectionView.setInfo(welcomeMessage.getMessageContents());
		} catch (IOException e) {
			LOGGER.error(ConstantsChat.INPUT_OUTPUT_FAIL, e);
		}
	}

	/**
	 * Checks and sends user's nickname.
	 * 
	 * @param nickname
	 *            the new nickname
	 * @return the boolean result of registering the nickname
	 */
	public boolean registerNickname(String nickname) {
		Message message = new Message();
		message.setNickname(nickname);
		try {
			objectTransfer.writeObject(message);
			message = objectTransfer.readObject();
		} catch (IOException e) {
			clientConnectionView.setInfo(ConstantsChat.SERVER_STOPPED);
			LOGGER.error(ConstantsChat.INPUT_OUTPUT_FAIL, e);
		} catch (NullPointerException npe) {
			clientConnectionView.setInfo(ConstantsChat.NO_ACTIVE_CONNECTION);
			LOGGER.error(ConstantsChat.NO_ACTIVE_CONNECTION, npe);
		}
		if (ConstantsChat.YOU_ARE_CONNECTED.equals(message.getType())) {
			clientConnectionView.setInfo(message.getMessageContents());
			clientConnectionView.dispose();
			return true;
		} else if (ConstantsChat.EXISTENT_NICKNAME.equals(message.getType())) {
			clientConnectionView.setInfo(nickname + ConstantsChat.ALREADY_EXISTS);
			new IncorrectNicknameView().setVisible(true);
		}
		return false;
	}

}
