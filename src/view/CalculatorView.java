package view;

import java.awt.event.ActionListener;

import controller.InputPI;

public interface CalculatorView {

	public void verbose(String verbose);

	public void showExceptionMessage(String message);

	public void setCalculatorHandler(ActionListener listener);

	public void setPiHandler(ActionListener listener);

	public void clearCalculator();

	public void clearPI();

	public void showWindow();

	public InputPI getInput();

	public void showCircumference(String response);

}
