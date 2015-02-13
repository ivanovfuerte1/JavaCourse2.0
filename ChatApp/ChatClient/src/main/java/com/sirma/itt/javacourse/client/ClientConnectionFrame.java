package com.sirma.itt.javacourse.client;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;

/**
 * The class {@link ClientConnectionFrame} contains methods for displaying a connection window for a
 * chat client.
 */
public class ClientConnectionFrame extends JFrame {
	private static final long serialVersionUID = -1488415918830598890L;
	private JTextField inputTextField;

	private JTextField outputTextField;
	private JButton sendBtn;
	private static final Pattern NICKNAME_PATTERN = Pattern.compile("[\\w\\d!@#$%^&*()_+]{3,12}");
	private ResourceBundle messages = Language.getMessages();
	private ClientConnectionThread clientConnectionThread;
	private ConnectionListener connectionListener = new ConnectionListener(this);
	private JComboBox<?> languageSelector;

	/**
	 * Creates an object of {@link ClientConnectionFrame} initializing the components of its window
	 * and starting a thread for connection.
	 */
	public ClientConnectionFrame() {
		initComponents();
		clientConnectionThread = new ClientConnectionThread(this);
	}

	/**
	 * Creates the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(ConstantsChat.CLIENT_WINDOW_LABEL);
		setBounds(ConstantsChat.WINDOW_X_POSITION, ConstantsChat.CLIENT_WINDOW_Y_POSITION,
				ConstantsChat.WINDOW_WIDTH, ConstantsChat.WINDOW_HEIGHT + 50);

		setContentPane();
		setInputTextField();
		setSendBtn();
		setOutputTextField();
		setLanguage();
	}

	/**
	 * Sets the content pane.
	 */
	private void setContentPane() {
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Sets the input text field.
	 */
	private void setInputTextField() {
		inputTextField = new JTextField(ConstantsChat.SUGGESTING_MESSAGE);
		inputTextField.addFocusListener(connectionListener);
		inputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(inputTextField);
		inputTextField.setFocusable(true);
	}

	/**
	 * Sets the send button.
	 */
	private void setSendBtn() {
		sendBtn = new JButton();
		sendBtn.setText(messages.getString("connect"));
		sendBtn.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT, ConstantsChat.SECOND_ROW_COMPONENT,
				ConstantsChat.COMPONENT_WIDTH, ConstantsChat.COMPONENT_HEIGHT);
		add(sendBtn);
		sendBtn.addActionListener(connectionListener);
	}

	/**
	 * Sets the output text field.
	 */
	private void setOutputTextField() {
		outputTextField = new JTextField();
		outputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(outputTextField);
	}

	/**
	 * Sets text to the output text field.
	 * 
	 * @param info
	 *            the text to set.
	 */
	public void setInfo(String info) {
		outputTextField.setText(info);
	}

	/**
	 * Sets the language for the current client.
	 */
	public void setLanguage() {
		String[] languages = { "English", "Bulgarian" };
		languageSelector = new JComboBox<String>(languages);
		languageSelector.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT + 50, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(languageSelector);
		languageSelector.addActionListener(connectionListener);
	}

	/**
	 * Setter method for inputTextField.
	 *
	 * @param text
	 *            the inputTextField to set
	 */
	public void setInputTextFieldContent(String text) {
		inputTextField.setText(text);
	}

	/**
	 * 
	 */
	public void connect() {
		inputTextField.setFocusable(true);
		String tempText = inputTextField.getText();
		Matcher matcher = NICKNAME_PATTERN.matcher(tempText);
		if (!matcher.matches()) {
			setInfo("Nickname can not contain [ or ] and must have 3 to 12 symbols.");
		} else {
			clientConnectionThread.setNickname(tempText);
			clientConnectionThread.sendUserInfo();
		}
	}

	/**
	 * 
	 */
	public void selectLanguage() {
		String languagName = (String) languageSelector.getSelectedItem();
		if ("Bulgarian".equals(languagName)) {
			Language.setLocale(new Locale("bg", "BG"));
			messages = Language.getMessages();
		} else {
			Language.setLocale(new Locale("en", "US"));
			messages = Language.getMessages();
		}
		sendBtn.setText(messages.getString("connect"));
	}
}
