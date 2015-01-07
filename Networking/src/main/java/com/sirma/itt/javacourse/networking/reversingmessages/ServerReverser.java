package com.sirma.itt.javacourse.networking.reversingmessages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class {@link ServerReverser} contains methods for receiving messages from clients, reversing
 * them and sending them back.
 */
public class ServerReverser extends JFrame {

	private static final long serialVersionUID = 9047879748322156170L;
	private JTextField tempTextField;
	private ServerThreadReverser serverThread;

	/**
	 * Constructs an object of {@link ServerReverser}.
	 */
	public ServerReverser() {
		initComponents();
		this.serverThread = new ServerThreadReverser();
		serverThread.start();
	}

	/**
	 * Creates the frame.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		JButton stopServer = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server Reverser");

		setBounds(ConstantsReverser.WINDOW_X_POSITION, ConstantsReverser.SERVER_WINDOW_Y_POSITION,
				ConstantsReverser.WINDOW_WIDTH, ConstantsReverser.WINDOW_HEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tempTextField.setBounds(ConstantsReverser.FIRST_COLUMN_COMPONENT,
				ConstantsReverser.FIRST_ROW_COMPONENT, ConstantsReverser.COMPONENT_WIDTH,
				ConstantsReverser.COMPONENT_HEIGHT);
		add(tempTextField);

		stopServer.setText("Stop");
		stopServer.setBounds(ConstantsReverser.FIRST_COLUMN_COMPONENT,
				ConstantsReverser.SECOND_ROW_COMPONENT, ConstantsReverser.COMPONENT_WIDTH,
				ConstantsReverser.COMPONENT_HEIGHT);
		add(stopServer);
		stopServer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tempTextField.setText("Server stopped.");
				serverThread.stopServer();
			}
		});
	}

}
