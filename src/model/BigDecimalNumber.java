package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Клас для роботи з числом дійсного типу , який може представляти число довільною кількість розрядів
 * Використовує клас BigDecimal з пакету java.math.BigDecimal
 * Клас є immutable, тобто не змінює свій стан після операції
 */
public class BigDecimalNumber {

	private BigDecimal dec;

	/**
	 * 
	 * @param number містить число з яким необхідно працювати
	 */
	public BigDecimalNumber(String number) {
		this.dec = new BigDecimal(number);
	}

	private BigDecimalNumber(BigDecimal dec) {
		this.dec = dec;
	}

	/**
	 * 
	 * @param other інше число
	 * @return нове число , яке є результатом додавання this числа та параметру
	 *         other
	 */
	public BigDecimalNumber add(BigDecimalNumber other) {
		BigDecimal intermediate = dec.add(other.dec);
		BigDecimalNumber result = new BigDecimalNumber(intermediate);
		return result;
	}

	/**
	 * 
	 * @param other число , яке потрібно відняти від цього числа
	 * @return нове число, яке є результатом віднімання this та параметру other
	 */
	public BigDecimalNumber subtract(BigDecimalNumber other) {
		BigDecimal intermediate = dec.subtract(other.dec);
		BigDecimalNumber result = new BigDecimalNumber(intermediate);
		return result;
	}

	/**
	 * 
	 * @param other число,на яке необхідно перемножити this число
	 * @return нове число , яке є результатом множення this та параметру other
	 */
	public BigDecimalNumber multiply(BigDecimalNumber other) {
		BigDecimal intermediate = dec.multiply(other.dec);
		BigDecimalNumber result = new BigDecimalNumber(intermediate);
		return result;
	}

	/**
	 * 
	 * @param other число,на яке необхідно поділити this число
	 * @return нове число, яке є результатом ділення this числа на other число
	 */
	public BigDecimalNumber divide(BigDecimalNumber other) {
		BigDecimal intermediate = dec.divide(other.dec, 2, RoundingMode.HALF_UP);
		BigDecimalNumber result = new BigDecimalNumber(intermediate);
		return result;
	}

	/**
	 * @return строкове представлення даного числа
	 */
	@Override
	public String toString() {
		return dec.toString();
	}

}