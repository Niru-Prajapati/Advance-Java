import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    public static void main(String[] args) {
        JFrame f = new JFrame("Login Form");

        f.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        f.add(userLabel);
        f.add(userField);
        f.add(passLabel);
        f.add(passField);
        f.add(new JLabel("")); 
        f.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if(username.equals("admin") &&password.equals("1234")) {
                    JOptionPane.showMessageDialog(f, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid Username or Password");
                }
            }
        });

        f.setSize(400, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
    }
}
