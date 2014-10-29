package com.sirma.itt.javacourse.reflection.ibanvalidator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link IBANOldTest} contains tests for the method replaceIBAN of the class
 * {@link IBANValidatorOLD}.
 * 
 * @author Svetlosar Kovatchev
 */
public class IBANOldTest {

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testBulgarianIBAN1() {
		String input = "<iban>BG80 BNBG 9661 1020 3456 7840</iban>";
		String result = new IBANValidatorOLD().replaceIBAN(input);
		assertEquals("<iban>****7840</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testBulgarianIBAN2() {
		String input = "<iban>BG80 BNBG 9661 1020 3456 7843</iban>";
		String result = new IBANValidatorOLD().replaceIBAN(input);
		assertEquals("<iban>****7843</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testForeignIBAN() {
		String input = "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>";
		String result = new IBANValidatorOLD().replaceIBAN(input);
		assertEquals("<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>", result);
	}

	/**
	 * Tests the method replaceIBAN with with given list of IBANs.
	 */
	@Test
	public void testSetOfIBANs() {
		// XXX: use system specific line separator!
		String input = "<bankAccounts>\n<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n<iban>GB35 MIBG 4025 3432 1446 70</iban>\n<iban>SA80 8000 0375 6080 1019 0160</iban>\n<iban>CH51 0868 6001 2565 1500 1</iban>\n<iban>BG80 BNBG 9661 1020 3456 7840</iban>\n<iban>IL30 01BG 0300 0009 6339 234</iban>\n<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n<iban>BG80 BNBG 9661 1020 3456 7843</iban>\n</bankAccounts>";
		String result = new IBANValidatorOLD().replaceIBAN(input);
		assertEquals(
				"<bankAccounts>\n<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n<iban>GB35 MIBG 4025 3432 1446 70</iban>\n<iban>SA80 8000 0375 6080 1019 0160</iban>\n<iban>CH51 0868 6001 2565 1500 1</iban>\n<iban>****7840</iban>\n<iban>IL30 01BG 0300 0009 6339 234</iban>\n<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n<iban>****7843</iban>\n</bankAccounts>",
				result);
	}

	/**
	 * Tests the method replaceIBAN with sample IBAN.
	 */
	@Test
	public void testBulgarianIBAN3() {
		String input = "<iban>BG80 BNBG 9661 1020 3456 7843</iban>";
		String result = new IBANValidatorOLD().replaceIBAN(input);
		assertEquals("<iban>****7843</iban>", result);
	}

}
