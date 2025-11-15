import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {    

    public static void main(String[] args) {    
        JFrame f = new JFrame("Color Buttons Example");  
        
        JButton redButton = new JButton("RED");  
        JButton blueButton = new JButton("BLUE");  
        JButton greenButton = new JButton("GREEN");  

        redButton.setBounds(50, 50, 100, 40);  
        blueButton.setBounds(160, 50, 100, 40);  
        greenButton.setBounds(270, 50, 100, 40);  

        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redButton.setBackground(Color.RED);
                redButton.setForeground(Color.WHITE);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                blueButton.setBackground(Color.BLUE);
                blueButton.setForeground(Color.WHITE);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                greenButton.setBackground(Color.GREEN);
                greenButton.setForeground(Color.BLACK);
            }
        });

        f.add(redButton);  
        f.add(blueButton);  
        f.add(greenButton);  

        f.setSize(450,200);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setVisible(true);  
    }  
}

