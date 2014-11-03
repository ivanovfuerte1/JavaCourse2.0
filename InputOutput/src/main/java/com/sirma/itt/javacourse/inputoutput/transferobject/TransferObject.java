package com.sirma.itt.javacourse.inputoutput.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The class {@link TransferObject} contains a method for transferring the contents of an instance
 * of InputStream to an instance of OutputStream.
 * 
 * @author Svetlosar Kovatchev
 */
public class TransferObject {
	private InputStream inputStream = null;
	private OutputStream outputStream = null;

	/**
	 * Assigns values to the instances of InputStream and OutputStream of the default object.
	 * 
	 * @param inputStream
	 *            an instance of InputStream where the bytes are supposed to be taken from
	 * @param outputStream
	 *            an instance of OutputStream where bytes are supposed to be transferred to
	 */
	public TransferObject(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	/**
	 * Returns the number of bytes successfully transferred from the InputStream to the OutputStream
	 * instance.
	 * 
	 * @param numberOfBytes
	 *            the number of bytes to be transferred
	 * @param offset
	 *            the number of bytes to be skipped from the beginning of the stream
	 * @return the number of bytes transferred
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
		byte[] b = new byte[numberOfBytes];
		int bytesRead = 0;
		int counter = 0;
		inputStream.skip(offset);
		bytesRead = inputStream.read(b);
		outputStream.write(b, 0, bytesRead);
		counter += bytesRead;
		return counter;
	}

}
