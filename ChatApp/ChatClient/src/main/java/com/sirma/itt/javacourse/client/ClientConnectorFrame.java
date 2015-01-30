package com.sirma.itt.javacourse.client;

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
import javax.swing.WindowConstants;

import com.sirma.itt.javacourse.common.ConstantsChat;
import com.sirma.itt.javacourse.common.Language;

/**
 * The class {@link ClientConnectorFrame} contains methods for sending messages to and receiving
 * them from a server.
 */
public class ClientConnectorFrame extends JFrame
/* implements ActionListener implements KeyListener */
{

	private static final long serialVersionUID = -1488415918830598890L;
	private JTextField inputTextField;
	private JTextField outputTextField;
	private JButton sendBtn;
	private static final Pattern NICKNAME_PATTERN = Pattern.compile("[\\w\\d!@#$%^&*()_+]{3,12}");
	// private MediatorInterface mediatorInterface = new Mediator();
	private ResourceBundle messages = Language.getMessages();
	private RunMediatorClient runMediatorClient;

	// private OriginatorChat originatorChat = new OriginatorChat();
	// private CareTakerChat careTakerChat = new CareTakerChat();
	// private int counter = 0;

	/**
	 * Creates an object of {@link ClientConnectorFrame}.
	 */
	public ClientConnectorFrame() {
		initComponents();
		runMediatorClient = new RunMediatorClient(this);
		runMediatorClient.start();
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
		inputTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				inputTextField.setText(ConstantsChat.EMPTY_STRING);
			}
		});
		inputTextField.setBounds(ConstantsChat.FIRST_COLUMN_COMPONENT,
				ConstantsChat.FIRST_ROW_COMPONENT, ConstantsChat.COMPONENT_WIDTH,
				ConstantsChat.COMPONENT_HEIGHT);
		add(inputTextField);
		inputTextField.setFocusable(true);
		// inputTextField.addKeyListener(this);
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
		// sendBtn.addActionListener(this);
		sendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				inputTextField.setFocusable(true);
				String tempText = inputTextField.getText();
				Matcher matcher = NICKNAME_PATTERN.matcher(tempText);
				if (!matcher.matches()) {
					setInfo("Nickname can not contain [ or ] and must have 3 to 12 symbols.");

				} else {
					runMediatorClient.setNickname(tempText);
					runMediatorClient.notifyClient();
				}
				// originatorChat.setState(tempText);
				// careTakerChat.add(originatorChat.saveStateToMemento());
				// counter++;

			}
		});
	}

	/**
	 * 
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
