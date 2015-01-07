package com.sirma.itt.javacourse.networking.clientinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ServerThread} contains a methods for getting clients and sending them messages.
 */
public class ServerThread extends Thread {
	private List<Socket> connectedClients = new ArrayList<>();
	private ServerSocket serverSocket;
	private static final int TARGET_PORT = 2004;
	private Server server;
	private static final Logger LOGGER = LogManager.getLogger(ServerThread.class);

	/**
	 * Constructs an object for the current server.
	 * 
	 * @param server
	 *            the server to construct object for
	 */
	public ServerThread(Server server) {
		this.server = server;
		try {
			this.serverSocket = new ServerSocket(TARGET_PORT);
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	@Override
	public void run() {
		Socket socket = null;
		PrintWriter socketWriter = null;
		try {
			while (true) {
				socket = serverSocket.accept();
				connectedClients.add(socket);
				server.setTempTextField("Client ¹ " + connectedClients.size() + " is added");
				new ListThread(connectedClients).start();
				socketWriter = new PrintWriter(socket.getOutputStream(), true);
				socketWriter.println("You are client ¹ " + connectedClients.size());
			}
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		} finally {
			try {
				socket.close();
				socketWriter.close();
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
