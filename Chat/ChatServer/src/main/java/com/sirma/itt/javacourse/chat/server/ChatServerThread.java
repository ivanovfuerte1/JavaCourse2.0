package com.sirma.itt.javacourse.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

/**
 * The class {@link ChatServerThread} contains a method for connecting new clients and saving them
 * to its list.
 */
public class ChatServerThread extends Thread {
	private Map<ObjectTransfer, String> connectedClients = new HashMap<>();
	private ServerSocket serverSocket;
	public static final int TARGET_PORT = 2004;
	private static final Logger LOGGER = LogManager.getLogger(ChatServerThread.class);

	/**
	 * Constructs an object of {@link ChatServerThread}.
	 */
	public ChatServerThread() {
		try {
			this.serverSocket = new ServerSocket(TARGET_PORT);
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
				ObjectTransfer objectTransfer = new ObjectTransfer(socket);
				connectedClients.put(objectTransfer, "");
				new NewChatClient(objectTransfer, connectedClients).start();
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
			connectedClients.clear();
			serverSocket.close();
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

}
