package com.sirma.itt.javacourse.networking.reversingmessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link NewClient} contains a method for sending reversed messages to clients.
 */
public class NewClient extends Thread {
	private Socket socket;
	private static final Logger LOGGER = LogManager.getLogger(NewClient.class);

	/**
	 * Creates a new object of {@link NewClient}.
	 * 
	 * @param socket
	 *            the socket to which the client is connected.
	 */
	public NewClient(Socket socket) {
		this.socket = socket;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		PrintWriter socketWriter = null;
		BufferedReader socketReader = null;
		try {
			socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketWriter = new PrintWriter(socket.getOutputStream(), true);
			socketWriter.println("Welcome");
			while (true) {
				String tempText = socketReader.readLine();
				tempText = new StringBuffer(tempText).reverse().toString();
				socketWriter.println(tempText);
			}
		} catch (SocketException e) {
			LOGGER.error("Server is closed", e);
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				socket.close();
				socketWriter.close();
				socketReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
