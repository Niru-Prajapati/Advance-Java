import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolbarExample extends JFrame implements ActionListener {

    JButton newBtn, loginBtn, logoutBtn;
    JToolBar toolbar;

    public ToolbarExample() {

        setTitle("Toolbar Example");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Toolbar
        toolbar = new JToolBar();

        // Buttons with Icons
        newBtn = new JButton(new ImageIcon("new.png"));
        loginBtn = new JButton(new ImageIcon("login.png"));
        logoutBtn = new JButton(new ImageIcon("logout.png"));

        // Tooltip text
        newBtn.setToolTipText("New");
        loginBtn.setToolTipText("Login");
        logoutBtn.setToolTipText("Logout");

        // Add ActionListener
        newBtn.addActionListener(this);
        loginBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        // Add buttons to toolbar
        toolbar.add(newBtn);
        toolbar.add(loginBtn);
        toolbar.add(logoutBtn);

        // Add toolbar to frame (top position)
        add(toolbar, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newBtn) {
            JOptionPane.showMessageDialog(this, "New File Created");
        } else if (e.getSource() == loginBtn) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else if (e.getSource() == logoutBtn) {
            JOptionPane.showMessageDialog(this, "Logged Out");
        }
    }

    public static void main(String[] args) {
        new ToolbarExample();
    }
}
