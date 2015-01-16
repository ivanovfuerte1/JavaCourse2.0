package com.sirma.itt.javacourse.chat.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.commonfiles.ConstantsChat;

/**
 * The class {@link ChatServerFrame} contains methods for receiving messages from clients, reversing
 * them and sending them back.
 */
public class ChatServerFrame extends JFrame {
	private static final long serialVersionUID = 9047879748322156170L;
	private JTextField tempTextField;
	private ChatServerThread serverThread;

	/**
	 * Constructs an object of {@link ChatServerFrame}.
	 */
	public ChatServerFrame() {
		initComponents();
		this.serverThread = new ChatServerThread();
		serverThread.start();
	}

	/**
	 * Creates the frame.
	 */
	private void initComponents() {
		setTitle(ConstantsChat.CHAT_SERVER);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(ConstantsChat.WINDOW_X_POSITION, ConstantsChat.SERVER_WINDOW_Y_POSITION,
				ConstantsChat.WINDOW_WIDTH, ConstantsChat.WINDOW_HEIGHT);

		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTextField();
		setStopButton();
	}

	/**
	 * 
	 */
	public void setTextField() {
		tempTextField = new JTextField();
		tempTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(tempTextField);
	}

	public void setTextFieldContent(String text) {
		tempTextField.setText(text);
	}

	/**
	 * 
	 */
	public void setStopButton() {
		JButton stopServer = new JButton();
		stopServer.setText("Stop Server");
		stopServer.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.SECOND_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(stopServer);
		stopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Server stopped.");
				serverThread.stopServer();
			}
		});
	}

}
