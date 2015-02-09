package com.sirma.itt.javacourse.networking.transmitter;

/**
 * The class {@link ConstantsTransmitter} contains constants for the classes of server and client of
 * transmitter.
 */
public enum ConstantsTransmitter {
	ConstantsTransmitter {
	};

	public static final String MULTICAST_GROUP1_ADDRESS = "224.0.0.10";
	public static final String MULTICAST_GROUP2_ADDRESS = "224.0.0.11";
	public static final String MULTICAST_GROUP3_ADDRESS = "224.0.0.12";
	public static final int TARGET_PORT = 2004;
	public static final int LISTENING_PORT = 2004;
	public static final int MAX_PACKET_SIZE = 1024;

}
