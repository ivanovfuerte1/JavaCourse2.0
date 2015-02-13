package com.sirma.itt.javacourse.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

/**
 */
public class ConnectionListener implements ActionListener, FocusListener {
	private ClientConnectionFrame clientConnectionFrame;

	/**
	 * @param clientConnectionFrame
	 *            a
	 */
	public ConnectionListener(ClientConnectionFrame clientConnectionFrame) {
		this.clientConnectionFrame = clientConnectionFrame;
	}

	@Override
	public void focusGained(FocusEvent e) {
		clientConnectionFrame.setInputTextFieldContent("");

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			clientConnectionFrame.connect();
		} else {
			clientConnectionFrame.selectLanguage();
		}
	}

}
