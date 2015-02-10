package com.sirma.itt.javacourse.networking.clientinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ListThread} contains method for sending information to all connected clients.
 */
public class ListThread extends Thread {
	private List<Socket> connectedClients;
	private static final Logger LOGGER = LogManager.getLogger(ListThread.class);

	/**
	 * Informs all connected clients when a new client connects.
	 * 
	 * @param connectedClients
	 *            list containing all connected clients
	 */
	public ListThread(List<Socket> connectedClients) {
		this.connectedClients = connectedClients;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (int i = 0; i < connectedClients.size() - 1; i++) {
			try {
				PrintWriter printWriter = new PrintWriter(
						connectedClients.get(i).getOutputStream(), true);
				printWriter.println("Client ¹ " + connectedClients.size() + " connected");
			} catch (IOException e) {
				LOGGER.error("An I/O operation is failed or interrupted", e);
			}
		}
	}
}
