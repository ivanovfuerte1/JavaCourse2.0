package com.sirma.itt.javacourse.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.common.ConstantsChat;

/**
 * The class {@link ClientController} initializes the client connection window and performs actions
 * whenever a button is pressed or input text field is accessed.
 */
public class ClientController implements ActionListener {
	private ClientConnectionView clientConnectionView;
	private ClientConnectionModel clientConnectionModel;
	private ClientCommunicationView clientCommunicationView;
	private ClientCommunicationModel clientCommunicationModel;

	/**
	 * Initializes the client connection window and initializes the connection model to add logic to
	 * it.
	 */
	public ClientController() {
		clientConnectionView = new ClientConnectionView(this);
		clientConnectionView.setVisible(true);
		clientConnectionModel = new ClientConnectionModel(clientConnectionView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton jButton = (JButton) e.getSource();
			if (ConstantsChat.CONNECT.equals(jButton.getName())) {
				checkAndRegisterNickname();
			} else if (ConstantsChat.SEND_BTN.equals(jButton.getName())) {
				clientCommunicationModel.sendMessage(clientCommunicationView.getMessageContent());
				clientCommunicationView.clearInputTextField();
				clientCommunicationView.setFocusOnInput();
			} else if (ConstantsChat.DISCONNECT.equals(jButton.getName())) {
				clientCommunicationView.dispose();
				clientCommunicationModel.disconnectClient();
			}
		} else if (e.getSource() instanceof JComboBox) {
			clientConnectionView.selectLanguage();
		} else if (e.getSource() instanceof JTextField) {
			clientCommunicationModel.sendMessage(clientCommunicationView.getMessageContent());
			clientCommunicationView.clearInputTextField();
		}
	}

	/**
	 * Checks the nickname and runs a communication window. In case the nickname is not valid a new
	 * window with explanation is displayed.
	 */
	public void checkAndRegisterNickname() {
		clientConnectionView.setFocusableTextField(true);
		if (clientConnectionView.isValidNickname()) {
			if (clientConnectionModel.registerNickname(clientConnectionView.getNickname())) {
				clientCommunicationView = new ClientCommunicationView(this);
				clientCommunicationModel = new ClientCommunicationModel(clientCommunicationView,
						clientConnectionModel.getObjectTransfer(),
						clientConnectionView.getNickname());
				clientCommunicationModel.start();
				clientCommunicationView.setVisible(true);
			}

		} else {
			clientConnectionView.displayInvalidNickname();
		}
	}
}
