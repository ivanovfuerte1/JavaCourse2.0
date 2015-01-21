package com.sirma.itt.javacourse.chat.client;

import java.awt.event.ActionEvent;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.commonfiles.ConstantsChat;
import com.sirma.itt.javacourse.chat.commonfiles.Language;

/**
 * The class {@link ClientConnectorFrame} contains methods for sending messages to and receiving
 * them from a server.
 */
public class ClientConnectorFrame extends JFrame/* implements KeyListener */{

	private static final long serialVersionUID = -1488415918830598890L;
	private JTextField inputTextField;
	private JTextField outputTextField;
	private ChatClientThread clientThread;
	private JButton sendBtn;
	private static final Pattern NICKNAME_PATTERN = Pattern.compile("[\\w\\d!@#$%^&*()_+]{3,12}");
	private ResourceBundle messages = Language.getMessages();

	// private OriginatorChat originatorChat = new OriginatorChat();
	// private CareTakerChat careTakerChat = new CareTakerChat();
	// private int counter = 0;

	/**
	 * Creates an object of {@link ClientConnectorFrame}.
	 */
	public ClientConnectorFrame() {
		initComponents();
		clientThread = new ChatClientThread(this);
		clientThread.start();
	}

	/**
	 * Creates the frame.
	 */
	private void initComponents() {
		inputTextField = new JTextField(ConstantsChat.SUGGESTING_MESSAGE);
		inputTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				inputTextField.setText(ConstantsChat.EMPTY_STRING);
			}
		});
		outputTextField = new JTextField();
		sendBtn = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(ConstantsChat.CLIENT_WINDOW_LABEL);

		setBounds(ConstantsChat.WINDOW_X_POSITION, ConstantsChat.CLIENT_WINDOW_Y_POSITION,
				ConstantsChat.WINDOW_WIDTH, ConstantsChat.WINDOW_HEIGHT + 50);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		inputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(inputTextField);
		inputTextField.setFocusable(true);
		// inputTextField.addKeyListener(this);

		sendBtn.setText(messages.getString("connect"));
		sendBtn.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT, ConstantsChat.SECOND_ROW_COMPONENT,
				ConstantsChat.COMPONENT_WIDTH, ConstantsChat.COMPONENT_HEIGHT);
		add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				inputTextField.setFocusable(true);
				String tempText = inputTextField.getText();
				Matcher matcher = NICKNAME_PATTERN.matcher(tempText);
				if (!matcher.matches()) {
					setInfo("Nickname can notcontain [ or ] and must have 3 to 12 symbols.");
				} else {
					clientThread.setNickname(tempText);
					clientThread.notifyClient();
				}

				// originatorChat.setState(tempText);
				// careTakerChat.add(originatorChat.saveStateToMemento());
				// counter++;

			}
		});

		outputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(outputTextField);

		setLanguage();
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
		JComboBox<?> languageSelector = new JComboBox<String>(languages);
		languageSelector.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.THIRD_ROW_COMPONENT + 50, ConstantsChat.COMPONENT_WIDTH,
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
				sendBtn.setText(messages.getString("connect"));
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
	// inputTextField.setText(ConstantsChat.EMPTY_STRING);
	// inputTextField.setText(result);
	// } else if (e.getKeyCode() == KeyEvent.VK_UP && counter > 0) {
	// originatorChat.getStateFromMemento(careTakerChat.get(--counter));
	// String result = originatorChat.getState();
	// inputTextField.setText(ConstantsChat.EMPTY_STRING);
	// inputTextField.setText(result);
	//
	// }
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent e) {
	// }

}
