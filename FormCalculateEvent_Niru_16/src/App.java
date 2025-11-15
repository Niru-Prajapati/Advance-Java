import javax.swing.*;
import java.awt.event.*;

public class App implements ActionListener {
    JTextField firstDigit;
    JTextField secondDigit;
    JComboBox<String> operationBox;
    JButton btnCalculate;
    JTextField outputField;
    JFrame f = new JFrame();
    public App() {
        f.setTitle("Simple Calculator");
        JLabel firstLabel = new JLabel("First Digit:");
        firstLabel.setBounds(20, 20, 200, 25);
        firstDigit = new JTextField();
        firstDigit.setBounds(200, 20, 150, 25);
        f.add(firstLabel);
        f.add(firstDigit);
        
        JLabel secondLabel = new JLabel("Second Digit:");
        secondLabel.setBounds(20, 60, 200, 25);
        secondDigit = new JTextField();
        secondDigit.setBounds(200, 60, 150, 25);
        f.add(secondLabel);
        f.add(secondDigit);

        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setBounds(20, 100, 200, 25);
        String[] operations = {"Add", "Subtract", "Multiply", "Divide"};
        operationBox = new JComboBox<>(operations);
        operationBox.setBounds(200, 100, 150, 25);
        f.add(operationLabel);
        f.add(operationBox);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(200, 140, 150, 25);
        f.add(btnCalculate);
        btnCalculate.addActionListener(this);

        JLabel outputLabel = new JLabel("Result:");
        outputLabel.setBounds(20, 180, 200, 25);
        outputField = new JTextField();
        outputField.setBounds(200, 180, 150, 25);
        f.add(outputLabel);
        f.add(outputField);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int digit1 = Integer.parseInt(firstDigit.getText());
        int digit2 = Integer.parseInt(secondDigit.getText());
        String operation = (String)operationBox.getSelectedItem();
        int result = 0;
        switch (operation) {
            case "Add":
                result = digit1 + digit2;
                break;
            case "Subtract":
                result = digit1 - digit2;
                break;
            case "Multiply":
                result = digit1 * digit2;
                break;
            case "Divide":
                if (digit2 != 0) {
                    result = digit1 / digit2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                    return;
                }
                break;
        }
        outputField.setText(String.valueOf(result));
    }
}
