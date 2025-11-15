import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class App implements ActionListener {
    JTextField firstNumField;
    JTextField secondNumField;
    JTextField resultField;

    public App() {
        JFrame f = new JFrame("Calculator");
        f.setSize(600, 400);
        f.setLayout(new BorderLayout(10, 10));
        JPanel northPanel = new JPanel();
        JLabel titleLabel = new JLabel("Simple Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        northPanel.add(titleLabel);
        f.add(northPanel, BorderLayout.NORTH);

        JPanel eastPanel = new JPanel(new GridLayout(5, 1, 15, 15));
        JButton addBtn = new JButton("Add"); 
        JButton subBtn = new JButton("Subtract");
        JButton mulBtn = new JButton("Multiply");
        JButton divBtn = new JButton("Divide");
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        eastPanel.add(addBtn);
        eastPanel.add(subBtn);
        eastPanel.add(mulBtn);
        eastPanel.add(divBtn);
        f.add(eastPanel, BorderLayout.EAST);

        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 15, 15));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Calculator Form"));
        centerPanel.add(new JLabel("First Number:"));
        firstNumField = new JTextField();
        centerPanel.add(firstNumField);
        centerPanel.add(new JLabel("Second Number:"));
        secondNumField = new JTextField();
        centerPanel.add(secondNumField);
        centerPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        centerPanel.add(resultField);
        f.add(centerPanel, BorderLayout.CENTER);        
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(firstNumField.getText());
        int num2 = Integer.parseInt(secondNumField.getText());
        int result = 0;
        switch (e.getActionCommand()) {
            case "Add":
                result = num1 + num2;
                break;
            case "Subtract":
                result = num1 - num2;
                break;
            case "Multiply":
                result = num1 * num2;
                break;
            case "Divide":
                if(num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                    return;
                }
                break;
        }
        resultField.setText(String.valueOf(result));
    }
}