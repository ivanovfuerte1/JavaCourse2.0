package com.sirma.itt.javacourse.networking.clientinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ClientThread} contains method for setting text to client's user interface.
 */
public class ClientThread extends Thread {
	private Client client;
	private static final Logger LOGGER = LogManager.getLogger(ClientThread.class);

	/**
	 * Constructs an object and associates it with a client.
	 * 
	 * @param client
	 *            the client to associate with the object
	 */
	public ClientThread(Client client) {
		this.client = client;
	}

	@Override
	public void run() {
		try (Socket socket = new Socket("localhost", 2004);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()))) {
			client.setInfo("Connected");
			String message;
			do {
				message = bufferedReader.readLine();
				client.setInfo(message);
			} while (message != null);
		} catch (UnknownHostException e) {
			LOGGER.error("The IP address of a host could not be determined", e);
		} catch (ConnectException e) {
			LOGGER.error(
					"An error occurred while attempting to connect a socket to a remote address and port",
					e);
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
		client.setInfo("Server stopped.");
	}

}
