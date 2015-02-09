package com.sirma.itt.javacourse.networking.reversingmessages;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ServerThreadReverser} contains a method for connecting new clients and saving
 * them to its list.
 */
public class ServerThreadReverser extends Thread {
	private List<Socket> connectedClients = new ArrayList<>();
	private ServerSocket serverSocket;
	public static final int TARGET_PORT = 2004;
	private static final Logger LOGGER = LogManager.getLogger(ServerThreadReverser.class);

	/**
	 * Constructs an object of {@link ServerThreadReverser}.
	 */
	public ServerThreadReverser() {
		try {
			this.serverSocket = new ServerSocket(TARGET_PORT);
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		Socket socket = null;
		try {
			while (true) {
				socket = serverSocket.accept();
				connectedClients.add(socket);
				new NewClient(socket).start();
			}
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				LOGGER.error("An I/O operation is failed or interrupted", e);
			}
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
