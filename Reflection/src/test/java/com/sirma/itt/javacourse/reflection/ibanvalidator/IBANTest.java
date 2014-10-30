package com.sirma.itt.javacourse.reflection.ibanvalidator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link IBANTest} contains tests for the method replaceIBAN of the class
 * {@link IBANValidator}.
 * 
 * @author Svetlosar Kovatchev
 */
public class IBANTest {

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testBulgarianIBAN1() {
		String input = "<iban>BG80 BNBG 9661 1020 3456 7840</iban>";
		String result = new IBANValidator().replaceIBAN(input);
		assertEquals("<iban>****7840</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testBulgarianIBAN2() {
		String input = "<iban>BG80 BNBG 9661 1020 3456 7843</iban>";
		String result = new IBANValidator().replaceIBAN(input);
		assertEquals("<iban>****7843</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testBulgarianIBAN3() {
		String input = "<iban>BG80 BNBG 9661 1020 3456 7843</iban>";
		String result = new IBANValidator().replaceIBAN(input);
		assertEquals("<iban>****7843</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testForeignIBAN() {
		String input = "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>";
		String result = new IBANValidator().replaceIBAN(input);
		assertEquals("<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with with given list of IBANs.
	 */
	@Test
	public void testSetOfIBANs2() {
		final String newLine = System.lineSeparator();
		StringBuilder input = new StringBuilder();
		input.append("<bankAccounts>");
		input.append(newLine);
		input.append("<iban>GR16 0110 1050 0000 1054 7023 795</iban>");
		input.append(newLine);
		input.append("<iban>GB35 MIBG 4025 3432 1446 70</iban>");
		input.append(newLine);
		input.append("<iban>SA80 8000 0375 6080 1019 0160</iban>");
		input.append(newLine);
		input.append("<iban>CH51 0868 6001 2565 1500 1</iban>");
		input.append(newLine);
		input.append("<iban>BG80 BNBG 9661 1020 3456 7840</iban>");
		input.append(newLine);
		input.append("<iban>IL30 01BG 0300 0009 6339 234</iban>");
		input.append(newLine);
		input.append("<iban>AL47 2121 1009 0000 0002 3569 8741</iban>");
		input.append(newLine);
		input.append("<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>");
		input.append(newLine);
		input.append("</iban>\n<iban>BG80 BNBG 9661 1020 3456 7843</iban>");
		input.append(newLine);
		input.append("</bankAccounts>");
		String stringInput = input.toString();

		String result = new IBANValidator().replaceIBAN(stringInput);

		StringBuilder output = new StringBuilder();
		output.append("<bankAccounts>");
		output.append(newLine);
		output.append("<iban>GR16 0110 1050 0000 1054 7023 795</iban>");
		output.append(newLine);
		output.append("<iban>GB35 MIBG 4025 3432 1446 70</iban>");
		output.append(newLine);
		output.append("<iban>SA80 8000 0375 6080 1019 0160</iban>");
		output.append(newLine);
		output.append("<iban>CH51 0868 6001 2565 1500 1</iban>");
		output.append(newLine);
		output.append("<iban>****7840</iban>");
		output.append(newLine);
		output.append("<iban>IL30 01BG 0300 0009 6339 234</iban>");
		output.append(newLine);
		output.append("<iban>AL47 2121 1009 0000 0002 3569 8741</iban>");
		output.append(newLine);
		output.append("<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>");
		output.append(newLine);
		output.append("</iban>\n<iban>****7843</iban>");
		output.append(newLine);
		output.append("</bankAccounts>");
		String expected = output.toString();
		assertEquals(expected, result);
	}

}
