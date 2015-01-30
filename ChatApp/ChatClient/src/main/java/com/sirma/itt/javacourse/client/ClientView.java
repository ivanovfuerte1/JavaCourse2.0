package com.sirma.itt.javacourse.client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
// import com.sirma.itt.javacourse.chat.client.CareTakerChat;
// import com.sirma.itt.javacourse.chat.client.OriginatorChat;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.JTextFieldLimit;
import com.sirma.itt.javacourse.common.Language;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientConnectorFrame} contains methods for initializing the components of the
 * window for connecting clients to the server.
 */
public class ClientView extends JFrame {
	private static final long serialVersionUID = -7691477458517408418L;
	private JTextField inputTextField;
	private JTextArea listOfClients;
	private JTextField outputTextField;
	// private Message message;

	private ClientWriteThread communication;

	// private OriginatorChat originatorChat = new OriginatorChat();
	// private CareTakerChat careTakerChat = new CareTakerChat();
	// private int counter = 0;
	private ResourceBundle messages = Language.getMessages();

	/**
	 * Constructs a new frame for the current client.
	 * 
	 * @param nickname
	 *            the nickname of the current client
	 * @param objectTransfer
	 *            the object containing the streams of the socket of the current client
	 */
	public ClientView(String nickname, ObjectTransfer objectTransfer) {
		initComponents();
		communication = new ClientWriteThread(nickname, objectTransfer);
		communication.start();
		new ClientReadThread(this, objectTransfer).start();
	}

	/**
	 * Initializes the frame for communication of the client.
	 */
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ClientCommunicator");
		setLayout(new FlowLayout());

		setContentPane();
		setInputText();
		setSendBtn();
		setListOfClientsText();
		setOutputText();
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
		// inputTextField.addKeyListener(this);
	}

	/**
	 * Sets the send button.
	 */
	public void setSendBtn() {
		JButton sendBtn = new JButton();
		sendBtn.setText(messages.getString("send"));
		sendBtn.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT, ConstantsChat.SECOND_ROW_COMPONENT,
				ConstantsChat.COMPONENT_WIDTH, ConstantsChat.COMPONENT_HEIGHT);
		add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				String tempText = inputTextField.getText();
				if (tempText.length() > 0) {
					tempText = Character.toUpperCase(tempText.charAt(0))
							+ tempText.substring(1, tempText.length());
				}
				communication.setMessage(tempText);
				inputTextField.setText(ConstantsChat.EMPTY_STRING);
			}
		});
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
	// THIS METHOD HAS TO BE IMPROVED IN ORDER TO ENABLE REMOVING OF CLIENTS.
	public void setListOfClientsContent(String list) {
		// if (list.length() > listOfClients.getText().length()) {
		listOfClients.setText(list);
		// }
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

		// originatorChat.setState(currentMessage);
		// careTakerChat.add(originatorChat.saveStateToMemento());
		// counter++;

		outputTextField.setText(currentMessage);
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
		disconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				communication.disconnectClient();
			}
		});
	}

	// @Override
	// public void keyTyped(KeyEvent e) {
	// }
	//
	// @Override
	// public void keyPressed(KeyEvent e) {
	// if (e.getKeyCode() == KeyEvent.VK_DOWN
	// && counter < careTakerChat.getMementoList().size() - 1) {
	// originatorChat.getStateFromMemento(careTakerChat.get(++counter));
	// String result = originatorChat.getState();
	// outputTextField.setText(ConstantsChat.EMPTY_STRING);
	// outputTextField.setText(result);
	// } else if (e.getKeyCode() == KeyEvent.VK_UP && counter > 0) {
	// originatorChat.getStateFromMemento(careTakerChat.get(--counter));
	// String result = originatorChat.getState();
	// outputTextField.setText(ConstantsChat.EMPTY_STRING);
	// outputTextField.setText(result);
	// }
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent e) {
	// }
}
