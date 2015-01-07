package com.sirma.itt.javacourse.networking.transmitter;

import java.util.Random;

/**
 * The class {@link Mediator} contains a method for selecting a random channel for multicasting.
 */
public class Mediator {
	private Random random = new Random();

	/**
	 * Selects a random channel.
	 * 
	 * @return the channel selected
	 */
	public int getMessage() {
		int channel = random.nextInt(3) + 1;
		return channel;
	}

}
