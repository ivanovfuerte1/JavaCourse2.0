package com.sirma.itt.javacourse.networking.reversingmessages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class {@link ClientReverser} contains methods for sending messages to and receiving them from
 * a server.
 */
public class ClientReverser extends JFrame {

	private static final long serialVersionUID = -1488415918830598890L;
	private JTextField inputTextField;
	private JTextField outputTextField;
	private ClientThreadReverser clientThread;
	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();
	private int counter = 0;

	/**
	 * Creates an object of {@link ClientReverser}.
	 */
	public ClientReverser() {
		initComponents();
		clientThread = new ClientThreadReverser(this);
		clientThread.start();
	}

	/**
	 * Creates the frame.
	 */
	private void initComponents() {
		inputTextField = new JTextField(ConstantsReverser.SUGGESTING_MESSAGE);
		inputTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				inputTextField.setText(ConstantsReverser.EMPTY_STRING);
			}
		});
		outputTextField = new JTextField();
		JButton sendBtn = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(ConstantsReverser.CLIENT_WINDOW_LABEL);

		setBounds(ConstantsReverser.WINDOW_X_POSITION, ConstantsReverser.CLIENT_WINDOW_Y_POSITION,
				ConstantsReverser.WINDOW_WIDTH, ConstantsReverser.WINDOW_HEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		inputTextField.setBounds(ConstantsReverser.FIRST_COLUMN_COMPONENT,
				ConstantsReverser.FIRST_ROW_COMPONENT, ConstantsReverser.COMPONENT_WIDTH,
				ConstantsReverser.COMPONENT_HEIGHT);
		add(inputTextField);
		inputTextField.setFocusable(false);
		inputTextField.addKeyListener(new MementoKeyListener(careTaker, counter, originator,
				inputTextField));

		sendBtn.setText(ConstantsReverser.SEND_BUTTON_LABEL);
		sendBtn.setBounds(ConstantsReverser.FIRST_COLUMN_COMPONENT,
				ConstantsReverser.SECOND_ROW_COMPONENT, ConstantsReverser.COMPONENT_WIDTH,
				ConstantsReverser.COMPONENT_HEIGHT);
		add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				inputTextField.setFocusable(true);
				String tempText = inputTextField.getText();

				originator.setState(tempText);
				careTaker.add(originator.saveStateToMemento());
				counter++;

				clientThread.setMessageToReverse(tempText);
				clientThread.notifyClient();
			}
		});

		outputTextField.setBounds(ConstantsReverser.FIRST_COLUMN_COMPONENT,
				ConstantsReverser.THIRD_ROW_COMPONENT, ConstantsReverser.COMPONENT_WIDTH,
				ConstantsReverser.COMPONENT_HEIGHT);
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

}
