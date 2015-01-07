package com.sirma.itt.javacourse.networking.transmitter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * The class {@link MulticastingClient} contains methods for running a client that can receive
 * messages from the server in three channels.
 */
public class MulticastingClient extends Thread {
	private Client client;
	private int channel = 0;
	private MulticastSocket multicastSocket;

	/**
	 * Creates a {@link MulticastingClient} object assigning it a client.
	 * 
	 * @param client
	 *            the client to assign to the current object
	 */
	public MulticastingClient(Client client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			multicastSocket = new MulticastSocket(ConstantsTransmitter.LISTENING_PORT);
			InetAddress multicastGroupAddr;
			byte[] receiveBuf = new byte[ConstantsTransmitter.MAX_PACKET_SIZE];
			DatagramPacket packet = new DatagramPacket(receiveBuf, receiveBuf.length);
			while (true) {
				if (channel == 1) {
					multicastGroupAddr = InetAddress
							.getByName(ConstantsTransmitter.MULTICAST_GROUP1_ADDRESS);
				} else if (channel == 2) {
					multicastGroupAddr = InetAddress
							.getByName(ConstantsTransmitter.MULTICAST_GROUP2_ADDRESS);
				} else {
					multicastGroupAddr = InetAddress
							.getByName(ConstantsTransmitter.MULTICAST_GROUP3_ADDRESS);
				}
				multicastSocket.joinGroup(multicastGroupAddr);
				multicastSocket.receive(packet);
				String packetAsString = new String(packet.getData(), 0, packet.getLength());
				client.setInfo(packetAsString);
				multicastSocket.leaveGroup(multicastGroupAddr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets a channel to listen at.
	 * 
	 * @param channel
	 *            the channel to listen at
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * Closes the socket.
	 */
	public void close() {
		multicastSocket.close();
	}

}
