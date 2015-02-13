package com.sirma.itt.javacourse.client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sirma.itt.javacourse.common.CareTaker;
import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.JTextFieldLimit;
import com.sirma.itt.javacourse.common.Language;
import com.sirma.itt.javacourse.common.MementoKeyListener;
import com.sirma.itt.javacourse.common.ObjectTransfer;
import com.sirma.itt.javacourse.common.Originator;

/**
 * The class {@link ClientConnectionFrame} contains methods for initializing the components of the
 * window for connecting clients to the server.
 */
public class ClientCommunicationFrame extends JFrame {
	private static final long serialVersionUID = -7691477458517408418L;
	private JTextField inputTextField;
	private JTextArea listOfClients;
	private JTextField outputTextField;
	private ClientCommunicationThread clientCommunicationThread;
	private ResourceBundle messages = Language.getMessages();
	private CommunicationListener communicationListener = new CommunicationListener(this);
	private Originator originator = new Originator();
	private int counter = 0;
	private CareTaker careTaker = new CareTaker();

	/**
	 * Constructs a new frame for the current client.
	 * 
	 * @param nickname
	 *            the nickname of the current client
	 * @param objectTransfer
	 *            the object containing the streams of the socket of the current client
	 */
	public ClientCommunicationFrame(String nickname, ObjectTransfer objectTransfer) {
		initComponents();
		clientCommunicationThread = new ClientCommunicationThread(this, objectTransfer, nickname);
		clientCommunicationThread.start();
	}

	/**
	 * Initializes the frame for communication of the client.
	 */
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ClientCommunicator");
		setLayout(new FlowLayout());

		setContentPane();
		setOutputText();
		setInputText();
		setSendBtn();
		setListOfClientsText();
		setDisconnectBtn();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(ConstantsChat.WINDOW_WIDTH, 500);
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - getSize().height / 2);
	}

	/**
	 * Sets the content pane.
	 */
	public void setContentPane() {
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Sets the field for input.
	 */
	public void setInputText() {
		inputTextField = new JTextField();
		inputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(inputTextField);
		inputTextField.setDocument(new JTextFieldLimit(200));
		// THIS REGEX CAN ALSO BE USED WITH IF ^.{200}$
		inputTextField.addKeyListener(new MementoKeyListener(careTaker, counter, originator,
				outputTextField));
		// inputTextField.addKeyListener(this);
	}

	/**
	 * Sets the send button.
	 */
	public void setSendBtn() {
		JButton sendBtn = new JButton();
		sendBtn.setText(messages.getString("send"));
		sendBtn.setName("sendBtn");
		sendBtn.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT, ConstantsChat.SECOND_ROW_COMPONENT,
				ConstantsChat.COMPONENT_WIDTH, ConstantsChat.COMPONENT_HEIGHT);
		add(sendBtn);
		sendBtn.addActionListener(communicationListener);
	}

	/**
	 * Sets the text area designed for listing the clients.
	 */
	public void setListOfClientsText() {
		listOfClients = new JTextArea();
		listOfClients.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH, 190);
		add(listOfClients);
	}

	/**
	 * Sets a new list of clients whenever it is longer than the old one.
	 * 
	 * @param list
	 *            the list of clients to set
	 */
	public void setListOfClientsContent(String list) {
		listOfClients.setText(list);
	}

	/**
	 * Sets the text field for output.
	 */
	public void setOutputText() {
		outputTextField = new JTextField();
		outputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT + 200, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(outputTextField);
	}

	/**
	 * Sets the text in the parameter to the output text field, adding the current time to it and
	 * memorizing it.
	 * 
	 * @param messageInString
	 *            the message to display
	 */
	public void setOutputFieldContent(String messageInString) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String currentMessage = messageInString;
		currentMessage = "[" + dateFormat.format(date) + "] " + messageInString;
		outputTextField.setText(currentMessage);

		originator.setState(currentMessage);
		careTaker.add(originator.saveStateToMemento());
		counter++;
	}

	/**
	 * Sets the disconnect button.
	 */
	public void setDisconnectBtn() {
		JButton disconnect = new JButton();
		disconnect.setText(messages.getString("disconnect"));
		disconnect.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT + 250, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(disconnect);
		disconnect.addActionListener(communicationListener);
	}

	/**
	 * 
	 */
	public void send() {
		String tempText = inputTextField.getText();
		if (tempText.length() > 0) {
			tempText = Character.toUpperCase(tempText.charAt(0)) + tempText.substring(1);
		}
		clientCommunicationThread.sendMessage(tempText);
		inputTextField.setText(ConstantsChat.EMPTY_STRING);
	}

	/**
	 * 
	 */
	public void disconnect() {
		dispose();
		clientCommunicationThread.disconnectClient();
	}

	/**
	 * Getter method for inputTextField.
	 *
	 * @return the inputTextField
	 */
	public JTextField getInputTextField() {
		return inputTextField;
	}

	/**
	 * Getter method for clientCommunicationThread.
	 *
	 * @return the clientCommunicationThread
	 */
	public ClientCommunicationThread getClientCommunicationThread() {
		return clientCommunicationThread;
	}

	// @Override
	// public void keyTyped(KeyEvent e) {
	// }
	//
	// @Override
	// public void keyPressed(KeyEvent e) {
	// if (e.getKeyCode() == KeyEvent.VK_DOWN && counter < careTaker.getMementoList().size() - 1) {
	// originator.getStateFromMemento(careTaker.get(++counter));
	// String result = originator.getState();
	// outputTextField.setText(ConstantsChat.EMPTY_STRING);
	// outputTextField.setText(result);
	// } else if (e.getKeyCode() == KeyEvent.VK_UP && counter > 0) {
	// originator.getStateFromMemento(careTaker.get(--counter));
	// String result = originator.getState();
	// outputTextField.setText(ConstantsChat.EMPTY_STRING);
	// outputTextField.setText(result);
	// }
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent e) {
	// }
}
