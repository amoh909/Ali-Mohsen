
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField TextField; // main text output field
    JTextField historyField; // second field for see history operations
    JButton[] numberButtons = new JButton[10]; // 0-9
    JButton[] functionButtons = new JButton[9]; // all operations buttons (+,-,*,/,.,=,c,(-))
    JButton addButton, subButton, mulButton, divButton; // buttons
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel; // main panel for buttons

    Font myFont = new Font("Times New Roman", Font.BOLD, 30); // global font

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        // application window
        frame = new JFrame("Calculator"); // title name
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        // output Text window
        TextField = new JTextField();
        TextField.setBounds(50, 45, 300, 50); // window location
        TextField.setFont(myFont);
        TextField.setEditable(false);
        TextField.setHorizontalAlignment(SwingConstants.RIGHT);

        // operations history window
        historyField = new JTextField();
        historyField.setBounds(50, 15, 300, 25);
        historyField.setEditable(false);
        historyField.setBorder(null); // hide frame border
        historyField.setHorizontalAlignment(SwingConstants.RIGHT); // writing switch on right

        // setfont and style of the text
        historyField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        historyField.setForeground(Color.DARK_GRAY); // text color

        // all operation buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("X");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // adding a buttons and setPosition
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // background for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        // panel.setBackground(Color.GRAY);

        // add all buttons on the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // add buttons and textFields on the frame
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(TextField);
        frame.add(historyField);
        frame.setVisible(true);

        frame.repaint(); // bag fix with buttons loadings

    }

    public static void main(String[] args) { // main program
        Calculator calc = new Calculator(); // create a new calculator
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == numberButtons[0]) {
            TextField.setText(TextField.getText() + "0");
        } else if (e.getSource() == numberButtons[1]) {
            TextField.setText(TextField.getText() + "1");
        } else if (e.getSource() == numberButtons[2]) {
            TextField.setText(TextField.getText() + "2");
        } else if (e.getSource() == numberButtons[3]) {
            TextField.setText(TextField.getText() + "3");
        } else if (e.getSource() == numberButtons[4]) {
            TextField.setText(TextField.getText() + "4");
        } else if (e.getSource() == numberButtons[5]) {
            TextField.setText(TextField.getText() + "5");
        } else if (e.getSource() == numberButtons[6]) {
            TextField.setText(TextField.getText() + "6");
        } else if (e.getSource() == numberButtons[7]) {
            TextField.setText(TextField.getText() + "7");
        } else if (e.getSource() == numberButtons[8]) {
            TextField.setText(TextField.getText() + "8");
        } else if (e.getSource() == numberButtons[9]) {
            TextField.setText(TextField.getText() + "9");
        }
        if (e.getSource() == functionButtons[0]) {
            TextField.setText(TextField.getText() + " + ");
            operator = '+';
        } else if (e.getSource() == functionButtons[1]) {
            TextField.setText(TextField.getText() + " - ");
            operator = '-';
        } else if (e.getSource() == functionButtons[2]) {
            TextField.setText(TextField.getText() + " * ");
            operator = '*';
        } else if (e.getSource() == functionButtons[3]) {
            TextField.setText(TextField.getText() + " / ");
            operator = '/';
        } else if (e.getSource() == functionButtons[4]) {
            TextField.setText(TextField.getText() + ".");
        } else if (e.getSource() == functionButtons[5]) {
            String operation = TextField.getText();
            int counter = 0;
            String num1 = "";
            double numb1 = 0;
            while (operation.charAt(counter) != ' ') {
                num1 += operation.charAt(counter);
                counter++;
            }
            numb1 = Float.parseFloat(num1);
            counter++;
            char operator = operation.charAt(counter);
            counter += 2;
            String num2 = "";
            double numb2 = 0;
            while (counter < operation.length()) {
                num2 += operation.charAt(counter);
                counter++;
            }
            numb2 = Float.parseFloat(num2);
            if (operator == '+') {
                historyField.setText(operation + " = ");
                Double sum = (numb1 + numb2);
                DecimalFormat df = new DecimalFormat("#.####");
                String sums = df.format(sum);
                TextField.setText(sums);
            } else if (operator == '-') {
                historyField.setText(operation + " = ");
                Double sum = (numb1 - numb2);
                DecimalFormat df = new DecimalFormat("#.####");
                String sums = df.format(sum);
                TextField.setText(sums);
            } else if (operator == '*') {
                historyField.setText(operation + " = ");
                Double sum = (numb1 * numb2);
                DecimalFormat df = new DecimalFormat("#.####");
                String sums = df.format(sum);
                TextField.setText(sums);
            } else if (operator == '/') {
                historyField.setText(operation + " = ");
                Double sum = (numb1 / numb2);
                DecimalFormat df = new DecimalFormat("#.####");
                String sums = df.format(sum);
                TextField.setText(sums);
            }
        } else if (e.getSource() == functionButtons[6]) {
            if (TextField.getText().endsWith(" ")) {
                TextField.setText(TextField.getText().substring(0, TextField.getText().length() - 2));
            } else {
                TextField.setText(TextField.getText().substring(0, TextField.getText().length() - 1));
            }
        } else if (e.getSource() == functionButtons[7]) {
            TextField.setText("");
            historyField.setText("");
        } else if (e.getSource() == functionButtons[8]) {
            String neg = "";
            String txt = TextField.getText();
            int ind = 0;
            for (int i = txt.length() - 1; i > 0; i--) {
                if (txt.charAt(i - 1) != ' ') {
                    neg += txt.charAt(i);
                } else {
                    ind = i;
                    break;
                }
            }
            neg += txt.charAt(ind);
            if (neg.contains("-")) {
                String negative = "";
                int counter = neg.length() - 2;
                while (counter >= 0) {
                    negative += neg.charAt(counter);
                    counter--;
                }
                TextField.setText(
                        TextField.getText().substring(0, TextField.getText().length() - neg.length()) + negative);
            } else {
                String negative = "-";
                int counter = neg.length() - 1;
                while (counter >= 0) {
                    negative += neg.charAt(counter);
                    counter--;
                }
                TextField.setText(
                        TextField.getText().substring(0, TextField.getText().length() - neg.length()) + negative);
            }
        }
    }
}