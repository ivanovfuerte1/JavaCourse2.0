package com.sirma.itt.javacourse.client;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;

/**
 * The class {@link ClientConnectionView} contains methods for displaying a connection window for a
 * chat client.
 */
public class ClientConnectionView extends JFrame implements FocusListener {
	private static final long serialVersionUID = -1488415918830598890L;
	private static final Pattern NICKNAME_PATTERN = Pattern
			.compile(ConstantsChat.PERMITTED_NICKNAME);
	private JTextField inputTextField;
	private JTextField outputTextField;
	private JButton sendBtn;
	private JLabel label;
	private JComboBox<?> languageSelector;
	private ResourceBundle translation = Language.getTranslation();
	private ActionListener actionListener;

	/**
	 * Creates an object of {@link ClientConnectionView} initializing the components of its window.
	 * 
	 * @param actionListener
	 *            the listener for the actions of the buttons
	 */
	public ClientConnectionView(ActionListener actionListener) {
		this.actionListener = actionListener;
		initializeComponents();
	}

	/**
	 * Initializes the components of the connection window.
	 */
	private void initializeComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(ConstantsChat.CLIENT_WINDOW_LABEL);
		setBounds(ConstantsChat.WINDOW_X_POSITION, ConstantsChat.CLIENT_WINDOW_Y_POSITION,
				ConstantsChat.WINDOW_WIDTH, ConstantsChat.CONNECTION_WINDOW_HEIGHT);

		setContentPane();
		setInputLabel();
		setInputTextField();
		setSendBtn();
		setOutputTextField();
		setLanguageSelector();
		setResizable(false);
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
	 * Sets a label for suggesting message.
	 */
	private void setInputLabel() {
		label = new JLabel(translation.getString(ConstantsChat.SUGGESTING_MESSAGE));
		label.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT, ConstantsChat.FIRST_ROW_LABEL,
				ConstantsChat.COMPONENT_WIDTH, ConstantsChat.COMPONENT_HEIGHT);
		add(label);
	}

	/**
	 * Sets the input text field.
	 */
	private void setInputTextField() {
		inputTextField = new JTextField();
		inputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(inputTextField);
		inputTextField.addFocusListener(this);
	}

	/**
	 * Sets the send button.
	 */
	private void setSendBtn() {
		sendBtn = new JButton(translation.getString(ConstantsChat.CONNECT));
		sendBtn.setName(ConstantsChat.CONNECT);
		sendBtn.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT, ConstantsChat.SECOND_ROW_COMPONENT,
				ConstantsChat.COMPONENT_WIDTH, ConstantsChat.COMPONENT_HEIGHT);
		add(sendBtn);
		sendBtn.addActionListener(actionListener);

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
	 * Sets the language selector.
	 */
	public void setLanguageSelector() {
		String[] languages = { ConstantsChat.ENGLISH, ConstantsChat.BULGARIAN };
		languageSelector = new JComboBox<String>(languages);
		languageSelector.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FOURTH_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(languageSelector);
		languageSelector.addActionListener(actionListener);

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
	 * Sets content to the input text field.
	 *
	 * @param text
	 *            the content to set
	 */
	public void setInputTextFieldContent(String text) {
		inputTextField.setText(text);
	}

	/**
	 * Returns the nickname from the input text field.
	 *
	 * @return the inputTextField content
	 */
	public String getNickname() {
		return inputTextField.getText();
	}

	/**
	 * Sets the focus on the input text field.
	 * 
	 * @param focused
	 *            the state of the focus on the input text field
	 */
	public void setFocusableTextField(boolean focused) {
		inputTextField.setFocusable(focused);
	}

	/**
	 * Returns the boolean result of matching the nickname from the input with the pattern.
	 * 
	 * @return the validation result of the nickname
	 */
	public boolean isValidNickname() {
		Matcher matcher = NICKNAME_PATTERN.matcher(inputTextField.getText());
		return matcher.matches();
	}

	/**
	 * Displays a message for invalid nickname.
	 */
	public void displayInvalidNickname() {
		setInfo(ConstantsChat.INVALID_NICKNAME_INFO);
	}

	/**
	 * Selects the language.
	 */
	public void selectLanguage() {
		String languagName = (String) languageSelector.getSelectedItem();
		if (ConstantsChat.BULGARIAN.equals(languagName)) {
			Language.setLocale(new Locale(ConstantsChat.BG2, ConstantsChat.BG));
			translation = Language.getTranslation();
		} else {
			Language.setLocale(new Locale(ConstantsChat.EN, ConstantsChat.US));
			translation = Language.getTranslation();
		}
		sendBtn.setText(translation.getString(ConstantsChat.CONNECT));
		label.setText(translation.getString(ConstantsChat.SUGGESTING_MESSAGE));
	}

	@Override
	public void focusGained(FocusEvent e) {
		setInputTextFieldContent(ConstantsChat.EMPTY_STRING);
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

}
