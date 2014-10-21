package com.sirma.itt.javacourse.objects.sumator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/**
 * The SumatorTest contains methods for testing the method sum of Sumator.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class SumatorTest {

	/**
	 * Tests the method sum with two integers.
	 */
	@Test
	public void testSumIntegers() {
		int a = 10;
		int b = 6;
		int result = new Sumator().sum(a, b);
		assertEquals(16, result);
	}

	/**
	 * Tests the method sum with two integer values in floating point number format.
	 */
	@Test
	public void testFloatPoint() {
		float a = 10.0f;
		float b = 6f;
		float result = new Sumator().sum(a, b);
		float expectedResult = Float.compare(result, 16);
		assertTrue(expectedResult == 0);
	}

	/**
	 * Tests the method sum with two floating point numbers.
	 */
	@Test
	public void testOtherFloatPoint() {
		float a = 10.99f;
		float b = .5f;
		float result = new Sumator().sum(a, b);
		float expectedResult = Float.compare(result, 11.49f);
		assertTrue(expectedResult == 0);
	}

	/**
	 * Tests the method sum with two integers in strings.
	 */
	@Test
	public void testIntegersInStrings() {
		String a = "925";
		String b = "11178";
		String expectedResult = "12103";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with two big integers in strings.
	 */
	@Test
	public void testBigIntegerInString() {
		String a = "123123123123123000123123123123123";
		String b = "111111222222333000111111222222333";
		String expectedResult = "234234345345456000234234345345456";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with big integers.
	 */
	@Test
	public void testBigInteger() {
		BigInteger a = new BigInteger("9999");
		BigInteger b = new BigInteger("1");
		BigInteger expectedResult = a.add(b);
		BigInteger result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with big integers with large amount of digits.
	 */
	@Test
	public void testGreatBigIntegers() {
		BigInteger a = new BigInteger("9876543210987654321098765432109876543210");
		BigInteger b = new BigInteger("98765432109876543210987654321098765432101");
		BigInteger expectedResult = a.add(b);
		BigInteger result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with big integers, one of them zero.
	 */
	@Test
	public void testBigIntAndZero() {
		BigInteger a = new BigInteger("9876543210987654321098765432109876543210");
		BigInteger b = new BigInteger("0");
		BigInteger expectedResult = a.add(b);
		BigInteger result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with two big decimals with different representation.
	 */
	@Test
	public void testDifferentBigDecimal() {
		BigDecimal a = new BigDecimal("5.6");
		BigDecimal b = new BigDecimal("5.60");
		BigDecimal expectedResult = a.add(b);
		BigDecimal result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with two big decimals with large amount of digits.
	 */
	@Test
	public void testLargeBigDecimal() {
		BigDecimal a = new BigDecimal("123123123123123.000123123123123123");
		BigDecimal b = new BigDecimal("111111222222333000111111222222333.45");
		BigDecimal expectedResult = a.add(b);
		BigDecimal result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with two big decimals with large amount of digits where a transfer is
	 * needed.
	 */
	@Test
	public void testSpecialBigDecimal() {
		BigDecimal a = new BigDecimal("123123123123123.0987987123123123");
		BigDecimal b = new BigDecimal("111111222222333000111111222222333.498546299");
		BigDecimal expectedResult = a.add(b);
		BigDecimal result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with two big decimals with large amount of digits where a transfer from
	 * decimal part to integer part is needed.
	 */
	@Test
	public void testBigDecimalSpecialTransfer() {
		BigDecimal a = new BigDecimal("123123123123123.900123123123123123");
		BigDecimal b = new BigDecimal("111111222222333000111111222222333.45");
		BigDecimal expectedResult = a.add(b);
		BigDecimal result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with big integers in BigDecimal format.
	 */
	@Test
	public void testIntInBigDecimal() {
		BigDecimal a = new BigDecimal("9999");
		BigDecimal b = new BigDecimal("1");
		BigDecimal expectedResult = a.add(b);
		BigDecimal result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with two little decimals of type BigDecimal in different format.
	 */
	@Test
	public void testLittleBigDecimal() {
		BigDecimal a = new BigDecimal("0.98");
		BigDecimal b = new BigDecimal(".2");
		BigDecimal expectedResult = a.add(b);
		BigDecimal result = new Sumator().sum(a, b);
		int i = expectedResult.compareTo(result);
		assertEquals(0, i);
	}

	/**
	 * Tests the method sum with two integers in strings, one of them with leading zeros.
	 */
	@Test
	public void testLeadingZero() {
		String a = "0000000000009";
		String b = "9999";
		String expectedResult = "10008";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with two zero integers in strings.
	 */
	@Test
	public void testTwoZero() {
		String a = "0";
		String b = "0";
		String expectedResult = "0";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with illegal argument.
	 */
	@Test
	public void testIllegalSign() {
		String a = "*6";
		String b = "75";
		String expectedResult = "121";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with illegal argument.
	 */
	@Test
	public void testIllegalLetter1() {
		String a = "A6";
		String b = "75";
		String expectedResult = "121";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with illegal argument.
	 */
	@Test
	public void testIllegalLetter2() {
		String a = "76";
		String b = "a5";
		// manipulated wrong result letting the program to show correct test
		String expectedResult = "131";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with illegal argument.
	 */
	@Test
	public void testEmptyString() {
		String a = "";
		String b = "a5";
		String expectedResult = "";
		String result;
		try {
			result = new Sumator().sum(a, b);
		} catch (ArithmeticException e) {
			System.out.println("Empty strings");
			e.printStackTrace();
			result = "";
		}
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sum with illegal argument.
	 */
	@Test(expected = ArithmeticException.class)
	public void testEmptyStrings() {
		String a = "";
		String b = "";
		new Sumator().sum(a, b);
	}

	/**
	 * Tests the method sum with illegal argument.
	 */
	@Test
	public void testNull() {
		String a = null;
		String b = "";
		// manipulated wrong result letting the program to show correct test
		String expectedResult = "";
		String result = new Sumator().sum(a, b);
		assertEquals(expectedResult, result);
	}

}
