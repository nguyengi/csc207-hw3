package utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() {
		assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("0"));
		assertEquals (BigInteger.valueOf (2), Calculator.eval0 ("1 + 1"));
		assertEquals (BigInteger.valueOf (4), Calculator.eval0 ("1 + 2 + 1"));
		assertEquals (BigInteger.valueOf (9), Calculator.eval0 ("1 + 2 * 3"));
		assertEquals (BigInteger.valueOf (98270), Calculator.eval0 ("7 ^ 2 ^ 3 + 1 + 335 / 6 - 10 * 5"));
	} // test()

} // class CalculatorTest
