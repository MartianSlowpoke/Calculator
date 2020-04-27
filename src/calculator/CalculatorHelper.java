package calculator;

import model.BigDecimalNumber;

public class CalculatorHelper {

	private String firstOperand;
	private String secondOperand;
	private Math operator;

	public CalculatorHelper() {

	}

	public String getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(String firstOperand) {
		this.firstOperand = firstOperand;
	}

	public String getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(String secondOperand) {
		this.secondOperand = secondOperand;
	}

	public Math getOperator() {
		return operator;
	}

	public void setOperator(Math operator) {
		this.operator = operator;
	}

	public boolean hasOperator() {
		return operator != null;
	}

	public boolean hasFloatPoint(String operand) {
		return operand.indexOf(Math.FLOAT_POINT.toString()) == -1 ? false : true;
	}

	public String addFloatPoint(String operand) {
		return operand.concat(Math.FLOAT_POINT.toString());
	}

	public BigDecimalNumber calculate() {
		var first = new BigDecimalNumber(firstOperand);
		var second = new BigDecimalNumber(secondOperand);
		switch (operator) {
		case PLUS:
			return first.add(second);
		case MINUS:
			return first.subtract(second);
		case MULTIPLY:
			return first.multiply(second);
		case DIVIDE:
			return first.divide(second);
		default:
			return null;
		}
	}

}
