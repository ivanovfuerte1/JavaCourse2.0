package com.sirma.itt.javacourse.networking.clientserverconversation;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link DateGeneratorThread} contains methods for starting and stopping the server.
 */
public class DateGeneratorThread extends Thread {
	private static final int SERVER_PORT = 2002;
	private ServerSocket serverSocket;
	private JTextField tempTextField;
	private static final Logger LOGGER = LogManager.getLogger(DateGeneratorThread.class);

	/**
	 * Starts the server passing its text field as a parameter.
	 * 
	 * @param tempTextField
	 *            the text field of the server
	 */
	public DateGeneratorThread(JTextField tempTextField) {
		this.tempTextField = tempTextField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			while (true) {
				Socket socket = serverSocket.accept();
				OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
				out.write(new Date() + "\n");
				out.close();
				socket.close();
			}
		} catch (IOException e) {
			tempTextField.setText("An I/O operation is failed or interrupted");
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * Discontinues the work of the server.
	 */
	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			tempTextField.setText("Server socket can not be closed.");
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}
}
