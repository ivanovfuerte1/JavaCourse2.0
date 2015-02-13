package com.sirma.itt.javacourse.client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The class {@link IncorrectNicknameFrame} contains a method for initializing the components of a
 * frame designed to appear whenever the client inserts an invalid nickname.
 */
public class IncorrectNicknameFrame extends JFrame {
	private static final long serialVersionUID = -5462590876030356943L;
	private JPanel cards;

	/**
	 * Constructs a frame for the case user inserts incorrect nickname.
	 */
	public IncorrectNicknameFrame() {
		initComponents();
	}

	/**
	 * Initializes the components of the frame for incorrect nickname.
	 */
	private void initComponents() {
		JButton acceptBtn = new JButton("Accept");
		acceptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		JPanel card1 = new JPanel();
		cards.add(card1);
		card1.add(acceptBtn);
		add(cards, BorderLayout.CENTER);

		JPanel messagePane = new JPanel();
		// use FlowLayout
		JLabel errorMessage = new JLabel(
				"<html><center>The nickname you entered already exists.<br>Try again.</center></html>");
		messagePane.add(errorMessage);
		add(messagePane, BorderLayout.PAGE_START);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		setTitle("Error");
		setAlwaysOnTop(true);
	}

}
