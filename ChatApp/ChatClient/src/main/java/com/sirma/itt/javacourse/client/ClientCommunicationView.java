package com.sirma.itt.javacourse.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.common.CareTaker;
import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.JTextFieldLimit;
import com.sirma.itt.javacourse.common.Language;
import com.sirma.itt.javacourse.common.MementoKeyListener;
import com.sirma.itt.javacourse.common.Originator;

/**
 * The class {@link ClientCommunicationView} contains methods for displaying a communication window
 * for every chat client.
 */
public class ClientCommunicationView extends JFrame {
	private static final long serialVersionUID = 7171657490542917311L;
	private JTextField inputTextField = new JTextField();
	private JTextArea listOfClients = new JTextArea();
	private JTextArea outputMessageArea = new JTextArea();
	private ResourceBundle translation = Language.getTranslation();
	private JButton sendBtn = new JButton(translation.getString(ConstantsChat.SEND));
	private JButton disconnectBtn = new JButton(translation.getString(ConstantsChat.DISCONNECT));
	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();
	private ActionListener actionListener;

	/**
	 * Constructs a new communication window for the current client.
	 * 
	 * @param actionListener
	 *            the listener for the actions of the buttons
	 */
	public ClientCommunicationView(ActionListener actionListener) {
		this.actionListener = actionListener;
		setTitle(ConstantsChat.CHAT_APP_TITLE);
		setMinimumSize(new Dimension(ConstantsChat.COMMUNICATION_WINDOW_WIDTH,
				ConstantsChat.COMMUNICATION_WINDOW_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initializeComponents();

		pack();
		setVisible(true);
		setFocusOnInput();
	}

	/**
	 * Initializes the components of the window for communication.
	 */
	private void initializeComponents() {
		setInputText();
		setSendBtn();
		setDisconnectBtn();
		setListOfClients();

		JPanel communicationPanel = new JPanel();
		communicationPanel.add(inputTextField);
		communicationPanel.add(sendBtn);
		communicationPanel.add(disconnectBtn);

		add(communicationPanel, BorderLayout.SOUTH);
		add(new JScrollPane(setInformationPanel()), BorderLayout.CENTER);
		add(new JScrollPane(listOfClients), BorderLayout.EAST);
	}

	/**
	 * Sets the input text field.
	 */
	private void setInputText() {
		inputTextField.setPreferredSize(new Dimension(ConstantsChat.INPUT_TEXT_FIELD_WIDTH,
				ConstantsChat.COMMUNICATION_COMPONENT_HEIGHT));
		inputTextField.setDocument(new JTextFieldLimit(ConstantsChat.LIMIT_OF_CHARACTERS));
		inputTextField
				.addKeyListener(new MementoKeyListener(careTaker, originator, inputTextField));
		inputTextField.addActionListener(actionListener);
	}

	/**
	 * Sets the send button.
	 */
	private void setSendBtn() {
		sendBtn.setName(ConstantsChat.SEND_BTN_NAME);
		sendBtn.setPreferredSize(new Dimension(ConstantsChat.COMMUNICATION_BUTTON_WIDTH,
				ConstantsChat.COMMUNICATION_COMPONENT_HEIGHT));
		sendBtn.addActionListener(actionListener);
	}

	/**
	 * Sets the disconnect button.
	 */
	private void setDisconnectBtn() {
		disconnectBtn.setName(ConstantsChat.DISCONNECT);
		disconnectBtn.setPreferredSize(new Dimension(ConstantsChat.COMMUNICATION_BUTTON_WIDTH,
				ConstantsChat.COMMUNICATION_COMPONENT_HEIGHT));
		disconnectBtn.addActionListener(actionListener);
	}

	/**
	 * Returns the information panel after all its settings are done.
	 * 
	 * @return the information panel
	 */
	private JPanel setInformationPanel() {
		JPanel informationPanel = new JPanel(new BorderLayout());
		informationPanel.setBackground(Color.WHITE);
		outputMessageArea.setEditable(false);
		informationPanel.add(outputMessageArea, BorderLayout.PAGE_END);
		return informationPanel;
	}

	/**
	 * Sets the list of clients.
	 */
	private void setListOfClients() {
		listOfClients.setPreferredSize(new Dimension(ConstantsChat.LIST_OF_CLIENTS_WIDTH,
				ConstantsChat.LIST_OF_CLIENTS_HEIGHT));
		listOfClients.setEditable(false);
	}

	/**
	 * Sets the focus on the input text field.
	 */
	public void setFocusOnInput() {
		inputTextField.requestFocus();
	}

	/**
	 * Sets a new list of clients.
	 * 
	 * @param list
	 *            the list of clients to set
	 */
	public void setListOfClientsContent(String list) {
		listOfClients.setText(list);
	}

	/**
	 * Sets the text in the parameter to the output text field, adding the current time to it and
	 * memorizing it.
	 * 
	 * @param messageInString
	 *            the message to display
	 */
	public void setOutputMessageAreaContent(String messageInString) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(ConstantsChat.HH_MM_SS);
		String currentMessage = messageInString;
		originator.setState(currentMessage);
		careTaker.add(originator.saveStateToMemento());
		currentMessage = ConstantsChat.OPENING_BRACKET + dateFormat.format(date)
				+ ConstantsChat.CLOSING_BRACKET + messageInString;
		outputMessageArea.setText(outputMessageArea.getText() + ConstantsChat.LINE_SEPARATOR
				+ currentMessage);
		outputMessageArea.setCaretPosition(outputMessageArea.getText().length());
	}

	/**
	 * Capitalizes the first letter of the message and returns the new content of the current
	 * message.
	 * 
	 * @return the content of the current message with the first letter capitalized
	 */
	public String getMessageContent() {
		String tempText = inputTextField.getText();
		if (tempText.length() > 0) {
			tempText = Character.toUpperCase(tempText.charAt(0)) + tempText.substring(1);
		}
		return tempText;
	}

	/**
	 * Clears the input text field.
	 */
	public void clearInputTextField() {
		inputTextField.setText(ConstantsChat.EMPTY_STRING);
	}

}
