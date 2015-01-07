package com.sirma.itt.javacourse.networking.clientserverconversation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class {@link DateDisplay} contains methods for displaying the current date on a new window.
 */
public class DateDisplay extends JFrame {

	private static final long serialVersionUID = 4469088764885447439L;
	private JTextField tempTextField;

	/**
	 * Constructs an object of {@link DateDisplay}, initializing its components.
	 */
	public DateDisplay() {
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
		closeConnection.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tempTextField.setText("Connection closed.");
			}
		});
		connect.setText("Connect");
		connect.setBounds(160, 80, 140, 40);
		add(connect);
		connect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				displayDate(evt);
			}
		});
	}

	/**
	 * Displays the current date.
	 * 
	 * @param evt
	 *            the event that calls the method
	 */
	private void displayDate(java.awt.event.ActionEvent evt) {
		try (Socket socket = new Socket("localhost", 2002);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()))) {
			tempTextField.setText("Hello! " + in.readLine());
		} catch (UnknownHostException e) {
			tempTextField.setText("The host is unknown");
			e.printStackTrace();
		} catch (IOException e) {
			tempTextField.setText("An I/O operation is failed or interrupted");
			e.printStackTrace();
		}
	}

}
