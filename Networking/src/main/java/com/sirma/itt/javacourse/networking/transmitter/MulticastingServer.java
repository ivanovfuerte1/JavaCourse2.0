package com.sirma.itt.javacourse.networking.transmitter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link MulticastingServer} contains methods for running a server for sending the
 * current date to clients.
 */
public class MulticastingServer extends Thread {
	private MulticastSocket multicastSocket;
	private static final Logger LOGGER = LogManager.getLogger(MulticastSocket.class);
	private String message;

	/**
	 * Creates an object of {@link MulticastingServer} assigning it a multicast socket.
	 */
	public MulticastingServer() {
		try {
			this.multicastSocket = new MulticastSocket(ConstantsTransmitter.TARGET_PORT);
		} catch (IOException e) {
			LOGGER.error("The port is busy.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		Mediator mediator = new Mediator();
		try {
			InetAddress multicastGroupAddr1 = InetAddress
					.getByName(ConstantsTransmitter.MULTICAST_GROUP1_ADDRESS);
			InetAddress multicastGroupAddr2 = InetAddress
					.getByName(ConstantsTransmitter.MULTICAST_GROUP2_ADDRESS);
			InetAddress multicastGroupAddr3 = InetAddress
					.getByName(ConstantsTransmitter.MULTICAST_GROUP3_ADDRESS);
			System.out.println("Listening for packets...");
			while (true) {
				int groupNumber = mediator.getMessage();
				if (groupNumber == 1) {
					message = getFullDate();
					DatagramPacket packet = new DatagramPacket(message.getBytes(),
							message.length(), multicastGroupAddr1, ConstantsTransmitter.TARGET_PORT);
					multicastSocket.send(packet);
				} else if (groupNumber == 2) {
					message = getDate();
					DatagramPacket packet = new DatagramPacket(message.getBytes(),
							message.length(), multicastGroupAddr2, ConstantsTransmitter.TARGET_PORT);
					multicastSocket.send(packet);

				} else {
					message = getTime();
					DatagramPacket packet = new DatagramPacket(message.getBytes(),
							message.length(), multicastGroupAddr3, ConstantsTransmitter.TARGET_PORT);
					multicastSocket.send(packet);

				}
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		} catch (InterruptedException e) {
			LOGGER.error("The thread was interrupted while sleeping", e);
		}
	}

	/**
	 * Returns the current message.
	 * 
	 * @return the current message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the current date in full format.
	 * 
	 * @return the current date in full format
	 */
	private String getFullDate() {
		return new Date().toString();
	}

	/**
	 * Returns the current date without time.
	 * 
	 * @return the current date without time
	 */
	private String getDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(date);
	}

	/**
	 * Returns the current time.
	 * 
	 * @return the current time
	 */
	private String getTime() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}

}
