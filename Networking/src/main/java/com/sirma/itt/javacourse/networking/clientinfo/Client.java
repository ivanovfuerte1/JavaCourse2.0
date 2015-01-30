package com.sirma.itt.javacourse.networking.clientinfo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * XXX: Class comment/name. What does this class do?
 * 
 * XXX: Diagrams!
 * 
 * The class {@link Client} contains methods for reading and displaying messages from the server.
 */
public class Client extends JFrame {

	private static final long serialVersionUID = -8096042495206006937L;
	private JTextField tempTextField;
	private JButton connectBtn;
	private ClientThread clientThread;

	/**
	 * Constructs an object of {@link Client}.
	 */
	public Client() {
		initComponents();
		clientThread = new ClientThread(this);
	}

	/**
	 * Initializes the components of the user interface.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		connectBtn = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Client");

		setBounds(100, 100, 325, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tempTextField.setBounds(10, 30, 290, 40);
		add(tempTextField);
		connectBtn.setText("Connect");
		connectBtn.setBounds(10, 80, 290, 40);
		add(connectBtn);
		// Use: external action listener perhaps?
		connectBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clientThread.start();
				connectBtn.setEnabled(false);
			}
		});
	}

	/**
	 * Sets text to the text field.
	 * 
	 * @param info
	 *            the text to set in the text field
	 */
	public void setInfo(String info) {
		tempTextField.setText(info);
	}

}
