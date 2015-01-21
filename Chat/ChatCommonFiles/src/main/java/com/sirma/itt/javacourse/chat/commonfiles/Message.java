package com.sirma.itt.javacourse.chat.commonfiles;

import java.io.Serializable;

/**
 * The class {@link Message} contains methods for setting and getting the nickname of the sender and
 * contents of the message.
 */
public class Message implements Serializable {
	private static final long serialVersionUID = -8391118387173751652L;
	private String messageContents;
	private String nickname;

	/**
	 * Default constructor.
	 */
	public Message() {
	}

	/**
	 * Constructs an object of {@link Message} assigning nickname and contents to its variables.
	 * 
	 * @param nickname
	 *            the nickname of the sender
	 * @param messageContents
	 *            the content of the message
	 */
	public Message(String nickname, String messageContents) {
		this.nickname = nickname;
		this.messageContents = messageContents;
	}

	/**
	 * Returns the content of the current message.
	 * 
	 * @return the content of the current message
	 */
	public String getMessageContents() {
		return messageContents;
	}

	/**
	 * Sets content of the current message.
	 * 
	 * @param messageContents
	 *            the content to set to the current message
	 */
	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}

	/**
	 * Returns the nickname of the sender of the message.
	 * 
	 * @return the nickname of the sender of the message
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Set the nickname of the sender of the message.
	 * 
	 * @param nickname
	 *            the nickname of the current sender of the message
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
