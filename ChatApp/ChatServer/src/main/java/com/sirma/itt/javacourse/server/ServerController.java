package com.sirma.itt.javacourse.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;

/**
 * The class {@link ServerController} initializes the server window and performs actions whenever a
 * button is pressed.
 */
public class ServerController implements ActionListener {
	private ChatServerView chatServerView;
	private ChatServerModel chatServerModel;
	private ResourceBundle translation = Language.getTranslation();

	/**
	 * Initializes the server window and the model to add logic to it.
	 */
	public ServerController() {
		chatServerView = new ChatServerView(this);
		chatServerModel = new ChatServerModel(chatServerView);
		chatServerModel.start();
		chatServerView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			chatServerView.setInformationAreaContent(translation
					.getString(ConstantsChat.SERVER_STOPPED2));
			chatServerModel.stopServer();
		} else {
			chatServerView.selectLanguage();
		}

	}

}
