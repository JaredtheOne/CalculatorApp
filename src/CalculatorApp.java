import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorApp implements ActionListener{
	// creating a JFrame
	JFrame frame;
	JTextField textfield;
	
	// Two arrays to hold the buttons
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	
	// declaring button variables
	JButton addB,subB,mltiplyB,divideB;
	JButton decimalB,equalB,dltB,clrB, negateB;
	JPanel panel;
	
	Font myFont = new Font("Int Free", Font.BOLD,20);
	
	// creating double variables to hold the user input
	double num1= 0;
	double num2 = 0;
	double result = 0;
	
	// a char variable to hold the symbols for each of the function buttons
	char operator;
	
	// A constructor
	CalculatorApp() {
		
		// Designing the calculator app
		frame = new JFrame("Calculator App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(390,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(45, 29, 310, 55);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addB = new JButton("+");
		subB = new JButton("-");
		mltiplyB = new JButton("x");
		divideB = new JButton("/");
		decimalB = new JButton(".");
		equalB = new JButton("=");
		dltB = new JButton("Del");
		clrB = new JButton("Clear");
		negateB = new JButton("{-}");
		
		
	
		functionButtons[0] = addB;
		functionButtons[1] = subB;
		functionButtons[2] = mltiplyB;
		functionButtons[3] = divideB;
		functionButtons[4] = decimalB;
		functionButtons[5] = equalB;
		functionButtons[6] = dltB;
		functionButtons[7] = clrB;
		functionButtons[8] = negateB;
		
		// A for loop to loop through the function buttons 9 times
		for(int i = 0; i < 9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			
		}
		
		// Looping through all the number buttons on the calculator
		for(int i = 0; i < 10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		// negative value 
		negateB.setBounds(50,430,100,50);
		
		// delete button
		dltB.setBounds(150,430,100,50);
		
		// clear button
		clrB.setBounds(250,430,100,50);
		
		// Designing the panel
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		

		// Assembling the buttons in a specific order 
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mltiplyB);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subB);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addB);
		
		panel.add(negateB);
		panel.add(numberButtons[0]);
		panel.add(decimalB);
		panel.add(equalB);
		panel.add(divideB);
	
		
		// Adding the buttons to the frame
		frame.add(negateB);
		frame.add(dltB);
		frame.add(clrB);
		frame.add(textfield);
		frame.add(panel);
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		
		CalculatorApp calcu = new CalculatorApp();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
			
		}
		
		if(e.getSource()==decimalB) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource()==addB) {
			num1= Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
			
		}
		
		if(e.getSource()==subB) {
			num1= Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
			
		}
		
		if(e.getSource()==mltiplyB) {
			num1= Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
			
		}
		
		if(e.getSource()==divideB) {
			num1= Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
			
		}
		
		// a switch case for when the user clicks on the equals sign
		if(e.getSource()==equalB) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result = num1+num2;
				break;
			case'-':
				result = num1-num2;
				break;
			case'*':
				result = num1*num2;
				break;
			case'/':
				result = num1/num2;
				break;
	
			}
			
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		// giving functionality to the clear button
		if(e.getSource()==clrB) {
			textfield.setText("");
		}
		
		// giving functionality to the delete button
		if(e.getSource()==dltB) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
				
			}
			
		}
		
		// giving functionality to the negative button
		if(e.getSource()==negateB) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			
		}
		
	}

}
