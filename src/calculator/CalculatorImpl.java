package calculator;

import model.BigDecimalNumber;

public class CalculatorImpl implements Calculator {

	private CalculatorHelper helper;

	public CalculatorImpl() {
		helper = new CalculatorHelper();
		this.clear();
	}

	@Override
	public void put(Math math) throws InvalidSequenceException {
		if (isDigit(math)) {
			// modify the second operand
			if (helper.hasOperator()) {
				String operand = helper.getSecondOperand();
				helper.setSecondOperand(operand.concat(math.toString()));
			} else {
				// modify the first operand
				String operand = helper.getFirstOperand();
				helper.setFirstOperand(operand.concat(math.toString()));
			}
			return;
		}

		if (isOperator(math)) {
			if (helper.getFirstOperand() == "" && helper.getSecondOperand() == "") {
				throw new InvalidSequenceException("you have given an operation but there is no operand");
			}
			if (helper.hasOperator()) {
				if (helper.getFirstOperand() != "" && helper.getSecondOperand() != "") {
					if (math == Math.EQUALS) {
						BigDecimalNumber result = helper.calculate();
						this.clear();
						helper.setFirstOperand(result.toString());
					} else {
						// 2 + 2 -
						// sign minus causes calculation
						BigDecimalNumber result = helper.calculate();
						this.clear();
						helper.setFirstOperand(result.toString());
						helper.setOperator(math);
					}
				} else {
					helper.setOperator(math);
				}
			} else {
				helper.setOperator(math);
			}
			return;
		}

		if (isFloatPoint(math)) {
			if (helper.getFirstOperand().isEmpty() && helper.getSecondOperand().isEmpty()) {
				throw new InvalidSequenceException("you have given the float point but there is no operand");
			}
			if (helper.hasOperator()) {
				// work with the second operand
				if (!helper.getSecondOperand().isEmpty()) {
					if (!helper.hasFloatPoint(helper.getSecondOperand())) {
						String intermediate = helper.addFloatPoint(helper.getSecondOperand());
						helper.setSecondOperand(intermediate);
					}
				}
			} else {
				// work with the first operand
				if (!helper.hasFloatPoint(helper.getFirstOperand())) {
					String intermediate = helper.addFloatPoint(helper.getFirstOperand());
					helper.setFirstOperand(intermediate);
				}
			}
		}
	}

	@Override
	public void clear() {
		helper.setFirstOperand("");
		helper.setSecondOperand("");
		helper.setOperator(null);
	}

	@Override
	public String getVerbose() {
		if (helper.hasOperator()) {
			return helper.getFirstOperand() + helper.getOperator().toString() + helper.getSecondOperand();
		}
		return helper.getFirstOperand();
	}

	private boolean isDigit(Math math) {
		switch (math) {
		case ZERO:
		case ONE:
		case TWO:
		case THREE:
		case FOUR:
		case FIVE:
		case SIX:
		case SEVEN:
		case EIGHT:
		case NINE:
			return true;
		default:
			return false;
		}
	}

	private boolean isOperator(Math math) {
		switch (math) {
		case PLUS:
		case MINUS:
		case EQUALS:
		case DIVIDE:
		case MULTIPLY:
			return true;
		default:
			return false;
		}
	}

	private boolean isFloatPoint(Math math) {
		return math == Math.FLOAT_POINT;
	}

}
