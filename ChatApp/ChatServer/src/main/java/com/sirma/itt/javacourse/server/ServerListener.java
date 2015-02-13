package com.sirma.itt.javacourse.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 */
public class ServerListener implements ActionListener {
	private ChatServerFrame chatServerFrame;

	/**
	 * @param chatServerFrame
	 *            a
	 */
	public ServerListener(ChatServerFrame chatServerFrame) {
		this.chatServerFrame = chatServerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			chatServerFrame.closeConnection();
		} else {
			chatServerFrame.selectLanguage();
		}

	}

}
