package com.sirma.itt.javacourse.networking.clientserverconversation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class {@link DateGeneratorFrame} contains methods for constantly generating the current date.
 */
public class DateGeneratorFrame extends JFrame {

	private static final long serialVersionUID = 4277571605250284727L;
	private JTextField tempTextField;
	private DateGeneratorThread dateGeneratorThread;

	/**
	 * Creates an object of {@link DateGeneratorFrame} and initializes its interface.
	 */
	public DateGeneratorFrame() {
		initComponents();
	}

	/**
	 * Initializes the components of the user interface.
	 */
	private void initComponents() {
		tempTextField = new JTextField();
		JButton start = new JButton();
		JButton stop = new JButton();
		JPanel contentPane;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server");

		setBounds(100, 100, 325, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tempTextField.setBounds(10, 30, 290, 40);
		add(tempTextField);
		stop.setText("StopServer");
		stop.setBounds(10, 80, 140, 40);
		add(stop);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stopServer(evt);
			}

		});
		start.setText("Start");
		start.setBounds(160, 80, 140, 40);
		add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tempTextField.setText("Port open. Waiting for client.");
				generateDate(evt);
			}
		});
	}

	/**
	 * Stops the server.
	 * 
	 * @param evt
	 *            the event that calls the method
	 */
	private void stopServer(ActionEvent evt) {
		dateGeneratorThread.stopServer();

	}

	/**
	 * Generates the current date.
	 * 
	 * @param evt
	 *            the event that calls the method
	 */
	private void generateDate(ActionEvent evt) {
		dateGeneratorThread = new DateGeneratorThread(tempTextField);
		dateGeneratorThread.start();
	}

	/**
	 * Setter method for tempTextField.
	 *
	 * @param tempTextField
	 *            the tempTextField to set
	 */
	public void setTempTextField(JTextField tempTextField) {
		this.tempTextField = tempTextField;
	}

}
