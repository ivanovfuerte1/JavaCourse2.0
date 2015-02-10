package com.sirma.itt.javacourse.networking.clientserverconversation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ClientDateDisplay} contains methods for displaying the current date on a new
 * window.
 */
public class ClientDateDisplay extends JFrame {

	private static final int SERVER_PORT = 2002;
	private static final String LOCALHOST = "localhost";
	private static final long serialVersionUID = 4469088764885447439L;
	private JTextField tempTextField;
	private static final Logger LOGGER = LogManager.getLogger(ClientDateDisplay.class);

	/**
	 * Constructs an object of {@link ClientDateDisplay}, initializing its components.
	 */
	public ClientDateDisplay() {
		initComponents();
	}

	/**
	 * Initializes the components of the user interface.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		JButton connect = new JButton();
		JButton closeConnection = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Date Display");

		setBounds(100, 100, 325, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tempTextField.setBounds(10, 30, 290, 40);
		add(tempTextField);
		closeConnection.setText("Close Connection");
		closeConnection.setBounds(10, 80, 140, 40);
		add(closeConnection);
		closeConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Connection closed.");
			}
		});
		connect.setText("Connect");
		connect.setBounds(160, 80, 140, 40);
		add(connect);
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				displayDate();
			}
		});
	}

	/**
	 * Displays the current date.
	 */
	public void displayDate() {
		try (Socket socket = new Socket(LOCALHOST, SERVER_PORT);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()))) {
			tempTextField.setText("Hello! " + in.readLine());
		} catch (UnknownHostException e) {
			tempTextField.setText("The host is unknown");
			LOGGER.error("The host is unknown", e);
		} catch (IOException e) {
			tempTextField.setText("An I/O operation is failed or interrupted");
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

	/**
	 * Returns the text of the text field.
	 * 
	 * @return the text from the text field
	 */
	public String getText() {
		return tempTextField.getText();
	}

}
