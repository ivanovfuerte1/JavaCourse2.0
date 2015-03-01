package com.sirma.itt.javacourse.server;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;

/**
 * The class {@link ChatServerView} contains methods for initializing the components of the server's
 * frame.
 */
public class ChatServerView extends JFrame {
	private static final String STOP_SERVER = "stopServer";
	private static final long serialVersionUID = 9047879748322156170L;
	private JTextArea informationArea;
	private JButton stopServer;
	private ResourceBundle messages = Language.getTranslation();
	private ActionListener actionListener;
	private JComboBox<?> languageSelector;
	private StringBuilder stringBuilder = new StringBuilder();

	/**
	 * Constructs an object of {@link ChatServerView}.
	 * 
	 * @param actionListener
	 *            the listener for the actions of the buttons
	 */
	public ChatServerView(ActionListener actionListener) {
		this.actionListener = actionListener;
		initializeComponents();
	}

	/**
	 * Initializes the components of the window.
	 */
	private void initializeComponents() {
		setTitle(ConstantsChat.CHAT_SERVER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(ConstantsChat.WINDOW_X_POSITION, ConstantsChat.SERVER_WINDOW_Y_POSITION,
				ConstantsChat.WINDOW_WIDTH, ConstantsChat.SERVER_WINDOW_HEIGHT);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setStopButton();
		setLanguage();
		setTextArea();
		setResizable(false);
	}

	/**
	 * Sets the text area.
	 */
	public void setTextArea() {
		informationArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(informationArea);
		scrollPane.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.LIST_HEIGHT);
		add(scrollPane);
	}

	/**
	 * Sets the content of the information area.
	 * 
	 * @param text
	 *            the new information to display.
	 */
	public void setInformationAreaContent(String text) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(ConstantsChat.HH_MM_SS);
		stringBuilder.append(ConstantsChat.OPENING_BRACKET + dateFormat.format(date)
				+ ConstantsChat.CLOSING_BRACKET);
		stringBuilder.append(text);
		stringBuilder.append(ConstantsChat.LINE_SEPARATOR);
		informationArea.setText(stringBuilder.toString());
		informationArea.setCaretPosition(informationArea.getText().length());
	}

	/**
	 * Sets the stop button.
	 */
	public void setStopButton() {
		stopServer = new JButton();
		stopServer.setText(messages.getString(STOP_SERVER));
		stopServer.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIFTH_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(stopServer);
		stopServer.addActionListener(actionListener);
	}

	/**
	 * Sets the language selector.
	 */
	public void setLanguage() {
		String[] languages = { ConstantsChat.ENGLISH, ConstantsChat.BULGARIAN };
		languageSelector = new JComboBox<String>(languages);
		languageSelector.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.SIXTH_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(languageSelector);
		languageSelector.addActionListener(actionListener);
	}

	/**
	 * Selects the language.
	 */
	public void selectLanguage() {
		String languagName = (String) languageSelector.getSelectedItem();
		if (ConstantsChat.BULGARIAN.equals(languagName)) {
			Language.setLocale(new Locale(ConstantsChat.BG2, ConstantsChat.BG));
			messages = Language.getTranslation();
		} else {
			Language.setLocale(new Locale(ConstantsChat.EN, ConstantsChat.US));
			messages = Language.getTranslation();
		}
		stopServer.setText(messages.getString(STOP_SERVER));
	}

}
