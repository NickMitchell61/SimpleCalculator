package calculator.book;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	
	Calculator parent;
	
	char selectedAction = ' ';
	double currentResult = 0;
	
	
	
	CalculatorEngine (Calculator parent) {
		this.parent = parent;
	}
	
	
	public void actionPerformed (ActionEvent e) {
		
		
		JButton clickedButton = (JButton) e.getSource();
		
		String dispFieldText = parent.displayField.getText();	
		
				
		for (int i = 0; i < dispFieldText.length(); i++) {
			
			if (i == dispFieldText.indexOf('.')) {
				parent.buttonPoint.setEnabled(false);
			}
			
		}
		
		
		double displayValue = 0;
		
		
		if (!"".equals(dispFieldText)) {
			displayValue = Double.parseDouble(dispFieldText);
		}
		
		Object src = e.getSource();
		
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
			parent.buttonPoint.setEnabled(true);
			
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
			parent.buttonPoint.setEnabled(true);
			
		}  else if (src == parent.buttonDevide) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("на ноль делить нельзя");
			parent.buttonPoint.setEnabled(true);
			
		} else if (src == parent.buttonMultiplication) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
			parent.buttonPoint.setEnabled(true);
			
		} else if (src == parent.buttonEqual) {
			parent.buttonPoint.setEnabled(true);
			
			
			if (selectedAction == '+') {
				currentResult += displayValue;
				parent.displayField.setText("" + currentResult);
				
			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText("" + currentResult);
				
			} else if (selectedAction == '/') {
				currentResult /= displayValue;
				parent.displayField.setText("" + currentResult);
				
			} else if (selectedAction == '*') {
				currentResult *= displayValue;
				parent.displayField.setText("" + currentResult);
			}
			
			
		} else {
			String clickedButtonLabel1 = clickedButton.getText();
			parent.displayField.setText(dispFieldText + clickedButtonLabel1);
			
		}
	}

}
