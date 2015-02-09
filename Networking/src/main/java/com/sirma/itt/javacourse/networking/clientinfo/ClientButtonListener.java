package com.sirma.itt.javacourse.networking.clientinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The class {@link ClientButtonListener} contains methods for reading and displaying messages from
 * the server.
 */
public class ClientButtonListener implements ActionListener {
	private ClientThread clientThread;
	private JButton connectBtn;

	/**
	 * Construct an object of the class {@link ClientButtonListener} assigning values to its
	 * variables.
	 * 
	 * @param clientThread
	 *            the client's thread
	 * @param connectBtn
	 *            the connect button
	 */
	public ClientButtonListener(ClientThread clientThread, JButton connectBtn) {
		this.clientThread = clientThread;
		this.connectBtn = connectBtn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		clientThread.start();
		connectBtn.setEnabled(false);
	}

}
