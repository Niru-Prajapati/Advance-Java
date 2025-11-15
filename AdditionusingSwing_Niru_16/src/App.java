import javax.swing.*;
import java.awt.event.*;

public class App implements ActionListener {
    JTextField firstDigit;
    JTextField secondDigit;
    JButton btnCalculate;
    JTextField outputField;
    JFrame f = new JFrame();
    public App() {
        f.setTitle("Two Digit Calculator");
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
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(200, 100, 150, 25);
        f.add(btnCalculate);
        btnCalculate.addActionListener(this);
        JLabel outputLabel = new JLabel("Sum:");
        outputLabel.setBounds(20, 140, 200, 25);
        outputField = new JTextField();
        outputField.setBounds(200, 140, 150, 25);
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
        int sum = digit1 + digit2;
        outputField.setText(String.valueOf(sum));
    }
}
