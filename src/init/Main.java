package init;

import java.awt.EventQueue;

import calculator.Calculator;
import calculator.CalculatorImpl;
import controller.CalculatorController;
import controller.PIController;
import view.CalculatorView;
import view.CalculatorViewImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				CalculatorView view = new CalculatorViewImpl();
				Calculator calculator = new CalculatorImpl();
				CalculatorController controller = new CalculatorController(view, calculator);
				view.setCalculatorHandler(controller);
				PIController piController = new PIController(view);
				view.setPiHandler(piController);
				view.showWindow();

			}
		});
	}

}
