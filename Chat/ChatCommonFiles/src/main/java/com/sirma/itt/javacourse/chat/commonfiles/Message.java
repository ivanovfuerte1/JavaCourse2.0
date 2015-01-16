package com.sirma.itt.javacourse.chat.commonfiles;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = -8391118387173751652L;
	private String messageContents;
	private String nickname;

	public Message() {
	}

	public Message(String nickname, String messageContents) {
		this.nickname = nickname;
		this.messageContents = messageContents;
	}

	public String getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
