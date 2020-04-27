package constants;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * Клас який реалізує інтерфейс PI Дана реалізація має обмеження в кількості
 * обчислення розрядів числа PI
 */
public class CalculatorPI implements PI {

	/**
	 * обмеження , максимальна кількість розрядів
	 */
	private static final int MAX = 10012;

	public CalculatorPI() {

	}

	@Override
	public BigDecimal obtain(int digits) throws IllegalArgumentException {
		return calculate(digits);
	}

	private BigDecimal calculate(int digits) throws IllegalArgumentException {
		if (digits == 0) {
			throw new IllegalArgumentException("digits should be higher than zero");
		}
		if (digits > MAX) {
			throw new IllegalArgumentException("max count of digits is " + Integer.toString(MAX));
		}
		if (digits == 1) {
			return new BigDecimal("3");
		}
		String result = "3.";
		for (int digit = 2; digit <= digits; digit = digit + 1) {
			Integer temp = get(digit);
			result = result.concat(temp.toString());
		}
		return new BigDecimal(result);
	}

	private Integer get(int n) {
		BigInteger p = BigInteger.TEN.pow(10010).multiply(BigInteger.TWO);
		BigInteger a = p;
		for (BigInteger i = BigInteger.ONE; a.compareTo(BigInteger.ZERO) > 0; p = p.add(a)) {
			BigInteger inter1 = i.multiply(BigInteger.TWO).add(BigInteger.ONE);
			BigInteger inter2 = a.multiply(i);
			a = inter2.divide(inter1);
			i = i.add(BigInteger.ONE);
		}
		String temp = p.toString();
		char c = temp.charAt(n - 1);
		int result = c - 48;
		return result;
	}

}
