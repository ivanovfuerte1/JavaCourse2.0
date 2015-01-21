package com.sirma.itt.javacourse.chat.client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import com.sirma.itt.javacourse.chat.commonfiles.ConstantsChat;
import com.sirma.itt.javacourse.chat.commonfiles.JTextFieldLimit;
import com.sirma.itt.javacourse.chat.commonfiles.Language;
import com.sirma.itt.javacourse.chat.commonfiles.Message;
import com.sirma.itt.javacourse.chat.commonfiles.ObjectTransfer;

/**
 * The class {@link ClientCommunicatorFrame} contains methods for initializing a frame for a new
 * client.
 */
public class ClientCommunicatorFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 3059627133370923452L;
	private JTextField inputTextField;
	private JTextArea listOfClients;
	private JTextField outputTextField;
	private Message message;

	private ClientWriteThread communication;
	private OriginatorChat originatorChat = new OriginatorChat();
	private CareTakerChat careTakerChat = new CareTakerChat();
	private int counter = 0;
	private ResourceBundle messages = Language.getMessages();

	/**
	 * Constructs a new frame for the current client.
	 * 
	 * @param nickname
	 *            the nickname of the current client
	 * @param objectTransfer
	 *            the object containing the streams of the socket of the current client
	 */
	public ClientCommunicatorFrame(String nickname, ObjectTransfer objectTransfer) {
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
		// setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		inputTextField.setDocument(new JTextFieldLimit(10));
		// THIS REGEX CAN ALSO BE USED WITH IF ^.{200}$
		inputTextField.addKeyListener(this);
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
				message = new Message();
				message.setMessageContents(tempText);
				System.out.println(message.getMessageContents() + " before setMessage");

				communication.setMessage(tempText);
				// communication.setMessage(message);
				System.out.println(tempText + " after setMessage");
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
		if (list.length() > listOfClients.getText().length()) {
			listOfClients.setText(list);
		}
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
	 * @param message
	 *            the message to display
	 */
	public void setOutputFieldContent(String message) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String currentMessage = message;
		currentMessage = "[" + dateFormat.format(date) + "] " + message;

		originatorChat.setState(currentMessage);
		careTakerChat.add(originatorChat.saveStateToMemento());
		counter++;

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

	/**
	 * Sets the text in the parameter to the output text field.
	 * 
	 * @param info
	 *            the message to display
	 */
	public void setInfo(String info) {
		outputTextField.setText(info);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN
				&& counter < careTakerChat.getMementoList().size() - 1) {
			originatorChat.getStateFromMemento(careTakerChat.get(++counter));
			String result = originatorChat.getState();
			outputTextField.setText(ConstantsChat.EMPTY_STRING);
			outputTextField.setText(result);
		} else if (e.getKeyCode() == KeyEvent.VK_UP && counter > 0) {
			originatorChat.getStateFromMemento(careTakerChat.get(--counter));
			String result = originatorChat.getState();
			outputTextField.setText(ConstantsChat.EMPTY_STRING);
			outputTextField.setText(result);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
