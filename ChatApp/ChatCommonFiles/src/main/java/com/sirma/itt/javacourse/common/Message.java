package com.sirma.itt.javacourse.common;

import java.io.Serializable;

/**
 * The class {@link Message} contains methods for setting and getting the nickname of the sender,
 * contents of the message and its type.
 */
public class Message implements Serializable {
	private static final long serialVersionUID = -8391118387173751652L;
	private String messageContents;
	private String nickname;
	private String type;

	/**
	 * Default constructor.
	 */
	public Message() {
	}

	/**
	 * Attaches nickname to the message.
	 * 
	 * @param nickname
	 *            the nickname
	 * @return the message with the nickname attached.
	 */
	public Message attachNickname(String nickname) {
		setNickname(nickname);
		return this;
	}

	/**
	 * Attaches contents to the message.
	 * 
	 * @param contents
	 *            the contents of the message
	 * @return the message with the contents attached
	 */
	public Message attachContents(String contents) {
		setMessageContents(contents);
		return this;
	}

	/**
	 * Attaches type to the message.
	 * 
	 * @param type
	 *            the type of the message
	 * @return the message with the type attached
	 */
	public Message attachType(String type) {
		setType(type);
		return this;
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

	/**
	 * Returns the type of the message.
	 * 
	 * @return the type of the message
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the current message.
	 * 
	 * @param type
	 *            the type of the current message
	 */
	public void setType(String type) {
		this.type = type;
	}
}
