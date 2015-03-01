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

import com.sirma.itt.javacourse.common.ConstantsChat;

/**
 * The class {@link IncorrectNicknameView} contains a method for initializing the components of a
 * frame designed to appear whenever the client inserts an invalid nickname.
 */
public class IncorrectNicknameView extends JFrame {
	private static final long serialVersionUID = -5462590876030356943L;

	/**
	 * Constructs a frame for the case user inserts incorrect nickname.
	 */
	public IncorrectNicknameView() {
		initComponents();
	}

	/**
	 * Initializes the components of the frame for incorrect nickname.
	 */
	private void initComponents() {
		JButton acceptBtn = new JButton(ConstantsChat.ACCEPT);
		acceptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel card1 = new JPanel();
		JPanel cards = new JPanel(new CardLayout());
		cards.add(card1);
		card1.add(acceptBtn);
		add(cards, BorderLayout.CENTER);

		JPanel messagePane = new JPanel();
		JLabel errorMessage = new JLabel(ConstantsChat.EXISTING_NICKNAME);
		messagePane.add(errorMessage);
		add(messagePane, BorderLayout.PAGE_START);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		Dimension dimention = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dimention.width / 2 - getSize().width / 2, dimention.height / 2
				- getSize().height / 2);
		setTitle(ConstantsChat.ERROR);
		setAlwaysOnTop(true);
	}

}
