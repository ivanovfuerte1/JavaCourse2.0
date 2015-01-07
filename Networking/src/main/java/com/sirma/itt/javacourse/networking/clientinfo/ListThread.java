package com.sirma.itt.javacourse.networking.clientinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * The class {@link ListThread} contains method for sending information to all connected clients.
 */
public class ListThread extends Thread {
	private List<Socket> connectedClients;

	/**
	 * Informs all connected clients when a new client connects.
	 * 
	 * @param connectedClients
	 *            list containing all connected clients
	 */
	public ListThread(List<Socket> connectedClients) {
		this.connectedClients = connectedClients;
	}

	@Override
	public void run() {
		for (int i = 0; i < connectedClients.size() - 1; i++) {
			try {
				PrintWriter printWriter = new PrintWriter(
						connectedClients.get(i).getOutputStream(), true);
				printWriter.println("Client ¹ " + connectedClients.size() + " connected");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
