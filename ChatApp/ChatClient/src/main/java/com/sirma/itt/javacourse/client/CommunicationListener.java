package com.sirma.itt.javacourse.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 */
public class CommunicationListener implements ActionListener {
	private ClientCommunicationFrame clientCommunicationFrame;

	/**
	 * @param clientCommunicationFrame
	 *            a
	 */
	public CommunicationListener(ClientCommunicationFrame clientCommunicationFrame) {
		this.clientCommunicationFrame = clientCommunicationFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		if ("sendBtn".equals(jButton.getName())) {
			clientCommunicationFrame.send();
		} else {
			clientCommunicationFrame.disconnect();
		}
	}

}
