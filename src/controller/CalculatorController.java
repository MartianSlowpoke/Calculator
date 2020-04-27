package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculator.Calculator;
import calculator.InvalidSequenceException;
import view.CalculatorView;
import calculator.Math;

public class CalculatorController implements ActionListener {

	private CalculatorView view;
	private Calculator calculator;

	public CalculatorController(CalculatorView view, Calculator calculator) {
		this.view = view;
		this.calculator = calculator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		Math math = Math.fromString(command);
		switch (math) {
		case CLEAR:
			calculator.clear();
			view.clearCalculator();
			break;
		default:
			try {
				calculator.put(math);
				view.verbose(calculator.getVerbose());
			} catch (InvalidSequenceException e1) {
				e1.printStackTrace();
				view.showExceptionMessage(e1.getMessage());
			} catch (ArithmeticException e2) {
				// division by zero
				view.showExceptionMessage(e2.getMessage());
				view.clearCalculator();
				e2.printStackTrace();
			}
			break;
		}
	}

}
