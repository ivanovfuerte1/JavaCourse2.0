package com.sirma.itt.javacourse.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.common.ConstantsChat;

/**
 * The class {@link ChatServerThread} contains a method for connecting new clients and saving them
 * to its list.
 */
public class ChatServerThread extends Thread {
	private ServerSocket serverSocket;
	private ChatServerFrame chatServerFrame;
	private static final Logger LOGGER = LogManager.getLogger(ChatServerThread.class);

	/**
	 * Constructs an object of {@link ChatServerThread}.
	 * 
	 * @param chatServerFrame
	 *            the frame of the server
	 */
	public ChatServerThread(ChatServerFrame chatServerFrame) {
		this.chatServerFrame = chatServerFrame;
		try {
			this.serverSocket = new ServerSocket(ConstantsChat.TARGET_PORT);
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	@Override
	public void run() {
		Socket socket = null;
		try {
			while (true) {
				socket = serverSocket.accept();
				new Thread(new NewChatClient(null, null, socket, chatServerFrame)).start();
			}
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

}
