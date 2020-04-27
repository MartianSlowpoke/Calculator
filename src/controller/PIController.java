package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import constants.CalculatorPI;
import constants.PI;
import view.CalculatorView;

public class PIController implements ActionListener {

	private CalculatorView view;
	private PI pi;

	public PIController(CalculatorView view) {
		this.view = view;
		pi = new CalculatorPI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PICommand command = PICommand.fromText(e.getActionCommand());
		switch (command) {
		case CALCULATE:
			processCalculate();
			break;
		case CLEAR:
			processClear();
			break;
		}
	}

	private void processCalculate() {
		InputPI input = view.getInput();
		if (input.getPrecision().equals("") || input.getRadius().equals("")) {
			view.showExceptionMessage("all fields are required");
		} else {
			try {
				Integer digits = Integer.parseInt(input.getPrecision());
				BigDecimal accuratePI = pi.obtain(digits);
				BigDecimal radius = new BigDecimal(input.getRadius());
				BigDecimal diameter = radius.multiply(new BigDecimal("2"));
				BigDecimal result = accuratePI.multiply(diameter);
				String response = "accuratePI = " + accuratePI.toString() + "; the circumference = " + result;
				view.showCircumference(response);
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
				view.showExceptionMessage(ex.getMessage());
			}
		}
	}

	private void processClear() {
		view.clearPI();
	}

}
