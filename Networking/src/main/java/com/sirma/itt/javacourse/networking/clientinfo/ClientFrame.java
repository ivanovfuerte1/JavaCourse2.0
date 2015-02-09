package com.sirma.itt.javacourse.networking.clientinfo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * The class {@link ClientFrame} contains methods for displaying the frame of the client.
 */
public class ClientFrame extends JFrame {

	private static final long serialVersionUID = -8096042495206006937L;
	private JTextField tempTextField;
	private JButton connectBtn = new JButton();
	private ClientThread clientThread;
	private ClientButtonListener clientButtonListener;

	/**
	 * Constructs an object of {@link ClientFrame}.
	 */
	public ClientFrame() {
		clientThread = new ClientThread(this);
		clientButtonListener = new ClientButtonListener(clientThread, connectBtn);
		initComponents();
	}

	/**
	 * Initializes the components of the user interface.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		JPanel contentPane;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		connectBtn.addActionListener(clientButtonListener);
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
