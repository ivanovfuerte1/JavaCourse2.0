package com.sirma.itt.javacourse.networking.clientserverconversation;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JTextField;

/**
 * The class {@link StartServer} contains methods for starting and stopping the server.
 */
public class StartServer extends Thread {
	private ServerSocket serverSocket;
	private JTextField tempTextField;

	/**
	 * Starts the server passing its text field as a parameter.
	 * 
	 * @param tempTextField
	 *            the text field of the server
	 */
	public StartServer(JTextField tempTextField) {
		this.tempTextField = tempTextField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(2002);
			while (true) {
				Socket socket = serverSocket.accept();
				OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
				out.write(new Date() + "\n");
				out.close();
				socket.close();
			}
		} catch (IOException e) {
			tempTextField.setText("An I/O operation is failed or interrupted");
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
}
