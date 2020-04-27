package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.InputPI;
import controller.PICommand;

public class CalculatorViewImpl implements CalculatorView {

	/*
	 * Calculator panel
	 */
	private JFrame frame;
	private JTextField mainField;
	private JPanel mainPanel;
	private JButton btnEquals;
	private JButton btnPlus;
	private JButton btnThree;
	private JButton btnTwo;
	private JButton btnOne;
	private JButton btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnMinus, btnDivision, btnMultiply,
			btnPoint;
	private JButton btnClear;
	private JButton[] calculatorButtons;
	/*
	 * PI panel
	 */
	private JTextField radiusField;
	private JTextField piDigitsField;
	private JPanel piPanel;
	private JTextArea lengthArea;
	private JButton calculationBtn;
	private JButton piClearBtn;
	private JButton[] piButtons;

	public CalculatorViewImpl() {
		this.initFrame();
		this.initMainPanel();
		this.initPiPanel();
		this.pickButtons();
	}

	private void initFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void initMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 484, 265);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		mainField = new JTextField();
		mainField.setEditable(false);
		mainField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mainField.setBounds(10, 11, 464, 30);
		mainPanel.add(mainField);
		mainField.setColumns(10);

		btnOne = new JButton("1");
		btnOne.setBounds(10, 52, 60, 23);
		mainPanel.add(btnOne);

		btnTwo = new JButton("2");
		btnTwo.setBounds(10, 86, 60, 23);
		mainPanel.add(btnTwo);

		btnThree = new JButton("3");
		btnThree.setBounds(10, 120, 60, 23);
		mainPanel.add(btnThree);

		btnPlus = new JButton("+");
		btnPlus.setBounds(10, 154, 60, 23);
		mainPanel.add(btnPlus);

		btnEquals = new JButton("=");
		btnEquals.setBounds(10, 188, 60, 23);
		mainPanel.add(btnEquals);

		btnClear = new JButton("C");
		btnClear.setBounds(10, 222, 60, 23);
		mainPanel.add(btnClear);

		btnFour = new JButton("4");
		btnFour.setBounds(80, 52, 56, 23);
		mainPanel.add(btnFour);

		btnFive = new JButton("5");
		btnFive.setBounds(80, 86, 56, 23);
		mainPanel.add(btnFive);

		btnSix = new JButton("6");
		btnSix.setBounds(80, 120, 56, 23);
		mainPanel.add(btnSix);

		btnMinus = new JButton("-");
		btnMinus.setBounds(80, 154, 56, 23);
		mainPanel.add(btnMinus);

		btnMultiply = new JButton("*");
		btnMultiply.setBounds(80, 188, 56, 23);
		mainPanel.add(btnMultiply);

		btnDivision = new JButton("/");
		btnDivision.setBounds(80, 222, 56, 23);
		mainPanel.add(btnDivision);

		btnPoint = new JButton(".");
		btnPoint.setBounds(146, 188, 60, 23);
		mainPanel.add(btnPoint);

		btnSeven = new JButton("7");
		btnSeven.setBounds(146, 52, 60, 23);
		mainPanel.add(btnSeven);

		btnEight = new JButton("8");
		btnEight.setBounds(146, 86, 60, 23);
		mainPanel.add(btnEight);

		btnNine = new JButton("9");
		btnNine.setBounds(146, 120, 60, 23);
		mainPanel.add(btnNine);

		btnZero = new JButton("0");
		btnZero.setBounds(146, 154, 60, 23);
		mainPanel.add(btnZero);

		JLabel lblNewLabel = new JLabel("the negation is not supported");
		lblNewLabel.setBounds(270, 235, 250, 19);
		mainPanel.add(lblNewLabel);
	}

	private void initPiPanel() {
		piPanel = new JPanel();
		piPanel.setBorder(new TitledBorder(null, "PI", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		piPanel.setBounds(216, 52, 258, 280);
		mainPanel.add(piPanel);
		piPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("radius");
		lblNewLabel_1.setBounds(10, 25, 46, 14);
		piPanel.add(lblNewLabel_1);

		radiusField = new JTextField();
		radiusField.setBounds(66, 22, 182, 20);
		piPanel.add(radiusField);
		radiusField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("pi digits");
		lblNewLabel_2.setBounds(10, 50, 46, 14);
		piPanel.add(lblNewLabel_2);

		piDigitsField = new JTextField();
		piDigitsField.setBounds(66, 47, 182, 20);
		piPanel.add(piDigitsField);
		piDigitsField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("length");
		lblNewLabel_3.setBounds(10, 75, 46, 14);
		piPanel.add(lblNewLabel_3);

		lengthArea = new JTextArea();
		lengthArea.setEditable(false);
		lengthArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lengthArea.setLineWrap(true);
		lengthArea.setBounds(10, 100, 238, 90);
		piPanel.add(lengthArea);

		calculationBtn = new JButton(PICommand.CALCULATE.toString());
		calculationBtn.setBounds(66, 71, 89, 23);
		piPanel.add(calculationBtn);

		piClearBtn = new JButton(PICommand.CLEAR.toString());
		piClearBtn.setBounds(159, 71, 89, 23);
		piPanel.add(piClearBtn);

		JTextArea txtrPi = new JTextArea();
		txtrPi.setWrapStyleWord(true);
		txtrPi.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrPi.setLineWrap(true);
		txtrPi.setText(
				"The circumference = 2 * PI * the radius of the circle.Specify the PI precision to get the more accurate result");
		txtrPi.setEditable(false);
		txtrPi.setBounds(10, 201, 238, 68);
		piPanel.add(txtrPi);
	}

	private void pickButtons() {
		calculatorButtons = new JButton[] { btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven,
				btnEight, btnNine, btnPlus, btnMinus, btnDivision, btnMultiply, btnPoint, btnEquals, btnClear };
		piButtons = new JButton[] { calculationBtn, piClearBtn };
	}

	@Override
	public void verbose(String verbose) {
		mainField.setText(verbose);
	}

	@Override
	public void showExceptionMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void setCalculatorHandler(ActionListener listener) {
		for (JButton btn : calculatorButtons) {
			btn.addActionListener(listener);
			btn.setActionCommand(btn.getText());
		}
	}

	@Override
	public void setPiHandler(ActionListener listener) {
		for (JButton btn : piButtons) {
			btn.addActionListener(listener);
			btn.setActionCommand(btn.getText());
		}
	}

	@Override
	public void clearCalculator() {
		mainField.setText("");
	}

	@Override
	public void showWindow() {
		frame.setVisible(true);
	}

	@Override
	public void clearPI() {
		radiusField.setText("");
		piDigitsField.setText("");
		lengthArea.setText("");
	}

	@Override
	public InputPI getInput() {
		return new InputPI(radiusField.getText(), piDigitsField.getText());
	}

	@Override
	public void showCircumference(String response) {
		lengthArea.setText(response);
	}

}
