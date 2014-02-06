package utils;

import java.math.BigInteger;

public class Calculator {
	public static BigInteger eval0(String str) {
		String[] lst = str.split(" ");
		BigInteger res = new BigInteger(lst[0]);
		for (int i = 1; i < lst.length - 1; i+=2) {
			BigInteger num = new BigInteger(lst[i + 1]);
			switch (lst[i]) {
			case "+":
				res = res.add(num);
				break;
			case "-":
				res = res.subtract(num);
				break;
			case "*":
			case "x":
				res = res.multiply(num);
				break;
			case "/":
			case ":":
				res = res.divide(num);
				break;
			case "^":
				res = res.pow(num.intValue());
				break;
			default:
				return res;
			} // switch case to handle different operators
		} // iteration through operators
		return res;
	} // eval0 (String)
} // class Calculator
