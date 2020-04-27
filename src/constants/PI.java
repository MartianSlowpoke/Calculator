package constants;

import java.math.BigDecimal;

/**
 * 
 * Інтерфейс для обчислення константи PI до довільної кількості розрядів
 *
 */
public interface PI {

	/**
	 * 
	 * @param digits кількість розрядів
	 * @return число PI зі вказаною кількістю розрядів
	 * @throws IllegalArgumentException якщо digits < 0 або digits == MAX_VALUE
	 */
	public BigDecimal obtain(int digits) throws IllegalArgumentException;

}
