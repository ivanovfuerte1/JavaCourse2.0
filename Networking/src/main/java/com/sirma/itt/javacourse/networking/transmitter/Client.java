package com.sirma.itt.javacourse.networking.transmitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Contains methods for creating an user interface for every client.
 */
public class Client extends JFrame {

	private static final long serialVersionUID = 4469088764885447439L;
	private JTextField tempTextField;
	private MulticastingClient multicastingClient;

	/**
	 * Creates an object of {@link Client} starting a new thread.
	 */
	public Client() {
		initComponents();
		multicastingClient = new MulticastingClient(Client.this);
		multicastingClient.start();
	}

	/**
	 * Initializes the components of the user interface.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		JButton disconnect = new JButton();
		JButton channel1 = new JButton();
		JButton channel2 = new JButton();
		JButton channel3 = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Client");

		setBounds(100, 100, 325, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tempTextField.setBounds(10, 30, 290, 40);
		add(tempTextField);
		channel1.setText("Channel 1");
		channel1.setBounds(10, 80, 140, 40);
		add(channel1);
		channel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Connected to channel 1.");
				multicastingClient.setChannel(1);
			}
		});
		channel2.setText("Channel 2");
		channel2.setBounds(10, 130, 140, 40);
		add(channel2);
		channel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Connected to channel 2.");
				multicastingClient.setChannel(2);
			}
		});
		channel3.setText("Channel 3");
		channel3.setBounds(160, 130, 140, 40);
		add(channel3);
		channel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Connected to channel 3.");
				multicastingClient.setChannel(3);
			}
		});
		disconnect.setText("Disconnect");
		disconnect.setBounds(160, 80, 140, 40);
		add(disconnect);
		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Disconnected from server.");
				multicastingClient.close();
				dispose();
			}
		});
	}

	/**
	 * Sets information to the text field.
	 * 
	 * @param info
	 *            the information to set
	 */
	public void setInfo(String info) {
		tempTextField.setText(info);
	}

}
