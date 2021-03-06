package com.sirma.itt.javacourse.networking.clientinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class {@link ServerFrame} contains methods for displaying the frame of the server.
 */
public class ServerFrame extends JFrame {

	private static final long serialVersionUID = -6545319197988784914L;
	private JTextField tempTextField;
	private ServerThread serverThread;

	/**
	 * Construct an object of {@link ServerFrame}.
	 */
	public ServerFrame() {
		initComponents();
		this.serverThread = new ServerThread(this);
		serverThread.start();
	}

	/**
	 * Initializes the components of the user interface.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		JButton stopServer = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server");

		setBounds(100, 400, 325, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tempTextField.setBounds(10, 30, 290, 40);
		add(tempTextField);

		stopServer.setText("Stop");
		stopServer.setBounds(10, 80, 290, 40);
		add(stopServer);
		stopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Server stopped.");
				serverThread.stopServer();
			}
		});
	}

	/**
	 * Setter method for tempTextField.
	 *
	 * @param tempTextField
	 *            the tempTextField to set
	 */
	public void setTempTextField(String tempTextField) {
		this.tempTextField.setText(tempTextField);
	}

}