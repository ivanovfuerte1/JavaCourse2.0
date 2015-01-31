package com.sirma.itt.javacourse.server;

import java.awt.event.ActionEvent;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;

/**
 * The class {@link ChatServerFrame} contains methods for receiving messages from clients, reversing
 * them and sending them back.
 */
public class ChatServerFrame extends JFrame {
	private static final long serialVersionUID = 9047879748322156170L;
	private JTextField tempTextField;
	private JButton stopServer;
	private ChatServerThread serverThread;
	private ResourceBundle messages = Language.getMessages();

	/**
	 * Constructs an object of {@link ChatServerFrame}.
	 */
	public ChatServerFrame() {
		initComponents();
		this.serverThread = new ChatServerThread(this);
		serverThread.start();
	}

	/**
	 * Creates the frame.
	 */
	private void initComponents() {
		setTitle(ConstantsChat.CHAT_SERVER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(ConstantsChat.WINDOW_X_POSITION, ConstantsChat.SERVER_WINDOW_Y_POSITION,
				ConstantsChat.WINDOW_WIDTH, ConstantsChat.WINDOW_HEIGHT);
		// INCREASE WIDTH
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTextField();
		setStopButton();
		setLanguage();
	}

	/**
	 * Sets the text field.
	 */
	public void setTextField() {
		tempTextField = new JTextField();
		tempTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(tempTextField);
	}

	/**
	 * Sets content for the text field.
	 * 
	 * @param text
	 *            the content to set in the text field
	 */
	public void setTextFieldContent(String text) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String currentMessage = text;
		currentMessage = "[" + dateFormat.format(date) + "] " + text;

		// originatorChat.setState(currentMessage);
		// careTakerChat.add(originatorChat.saveStateToMemento());
		// counter++;

		tempTextField.setText(currentMessage);
	}

	/**
	 * Sets the stop button.
	 */
	public void setStopButton() {
		stopServer = new JButton();
		stopServer.setText(messages.getString("stopServer"));
		stopServer.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.SECOND_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(stopServer);
		stopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText(messages.getString("serverStopped"));
				serverThread.stopServer();
			}
		});
	}

	/**
	 * Sets the language for the server.
	 */
	public void setLanguage() {

		String[] languages = { "English", "Bulgarian" };
		JComboBox<?> languageSelector = new JComboBox<String>(languages);
		languageSelector.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(languageSelector);
		languageSelector.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> languageSelector = (JComboBox<?>) e.getSource();
				String languagName = (String) languageSelector.getSelectedItem();
				if ("Bulgarian".equals(languagName)) {
					Language.setLocale(new Locale("bg", "BG"));
					messages = Language.getMessages();
				} else {
					Language.setLocale(new Locale("en", "US"));
					messages = Language.getMessages();
				}
				stopServer.setText(messages.getString("stopServer"));
			}
		});
	}

}
