import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame window;
    JTextField textfield;
    JButton [] nr_buttons = new JButton [10];
    JButton [] function_buttons = new JButton [8];
    JButton plusButton, minusButton, mulButton, divButton;
    JButton dotButton, clrButton, eqButton, delButton;
    JPanel panel;

    double num1=0, num2=0, result=0;
    char operator;

    Calculator (){
        window = new JFrame("Calculator");
        window.setSize(400, 500);
        window.setLayout(null);

        textfield = new JTextField ();
        textfield.setBounds(50, 30, 300, 50);
        textfield.setEditable(false);


        plusButton = new JButton("+");
        minusButton = new JButton("-");
        delButton = new JButton("Del");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        clrButton = new JButton("Clear");
        eqButton = new JButton("=");

        function_buttons[0] = plusButton;
        function_buttons[1] = minusButton;
        function_buttons[2] = delButton;
        function_buttons[3] = mulButton;
        function_buttons[4] = divButton;
        function_buttons[5] = dotButton;
        function_buttons[6] = clrButton;
        function_buttons[7] = eqButton;

        for (int i=0;i<8;i++) {
            function_buttons[i].addActionListener(this);
        }

        for (int i=0;i<10;i++) {
            nr_buttons[i] = new JButton(String.valueOf(i));
            nr_buttons[i].addActionListener(this);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        for (int i=1; i<4; i++) {
            panel.add(nr_buttons[i]);
            panel.add(plusButton);
        }
        for (int i=4; i<7; i++) {
            panel.add(nr_buttons[i]);
            panel.add(minusButton);
        }
        for (int i=7; i<10; i++) {
            panel.add(nr_buttons[i]);
            panel.add(mulButton);
        }
        panel.add(nr_buttons[0]);
        panel.add(dotButton);
        panel.add(eqButton);
        panel.add(divButton);

        delButton.setBounds(50, 405, 145, 50);
        clrButton.setBounds(205, 405, 145, 50);
        window.add(panel);
        window.add(textfield);
        window.add(clrButton);
        window.add(delButton);
        window.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent equ) {
        for (int i=0; i<10; i++) {
            if (equ.getSource() == nr_buttons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (equ.getSource() == dotButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (equ.getSource() == plusButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (equ.getSource() == minusButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (equ.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (equ.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (equ.getSource() == eqButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (equ.getSource() == clrButton) {
            textfield.setText("");
        }
        if (equ.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i=0; i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
    }
}
