package com.sirma.itt.javacourse.client;

import com.sirma.itt.javacourse.common.MediatorInterface;
import com.sirma.itt.javacourse.common.User;

/**
 * The class {@link UserImplementation} contains methods for sending and receiving messages to the
 * current client.
 */
public class UserImplementation extends User {
	private ClientCommunicationFrame frame;

	/**
	 * Constructs an object of the class {@link UserImplementation} assigning a frame for
	 * communication to it.
	 * 
	 * @param mediatorInterface
	 *            the mediator of the current client
	 * @param nickname
	 *            the nickname of the current client
	 * @param frame
	 *            the communication frame of the current client
	 */
	public UserImplementation(MediatorInterface mediatorInterface, String nickname, ClientCommunicationFrame frame) {
		super(mediatorInterface, nickname);
		this.frame = frame;
	}

	@Override
	public void send(String message) {
		frame.setOutputFieldContent(this.getNickname() + ": Sending message= " + message);
		MediatorInterface myMediatorInterface = this.getMediatorInterface();
		myMediatorInterface.sendMessage(message);
	}

	@Override
	public void receive(String message) {
		frame.setOutputFieldContent(this.getNickname() + ": Received message:" + message);
	}

}
