import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChanger extends JFrame implements ItemListener {

    JRadioButton redBtn, greenBtn, blueBtn;
    ButtonGroup group;

    public ColorChanger() {

        setTitle("Color Changer");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Creating Radio Buttons
        redBtn = new JRadioButton("Red");
        greenBtn = new JRadioButton("Green");
        blueBtn = new JRadioButton("Blue");

        // Adding ItemListener
        redBtn.addItemListener(this);
        greenBtn.addItemListener(this);
        blueBtn.addItemListener(this);

        // Grouping Radio Buttons
        group = new ButtonGroup();
        group.add(redBtn);
        group.add(greenBtn);
        group.add(blueBtn);

        // Adding components to frame
        add(redBtn);
        add(greenBtn);
        add(blueBtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (redBtn.isSelected()) {
            getContentPane().setBackground(Color.RED);
        } else if (greenBtn.isSelected()) {
            getContentPane().setBackground(Color.GREEN);
        } else if (blueBtn.isSelected()) {
            getContentPane().setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new ColorChanger();
    }
}
