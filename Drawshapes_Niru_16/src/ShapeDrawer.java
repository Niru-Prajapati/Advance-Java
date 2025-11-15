import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeDrawer extends JFrame {
    private DrawPanel drawPanel;

    public ShapeDrawer() {
        setTitle("Shape Drawer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton circleButton = new JButton("Circle");
        JButton squareButton = new JButton("Square");
        JButton triangleButton = new JButton("Triangle");

        buttonPanel.add(circleButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(triangleButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Panel for drawing
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        // Button actions
        circleButton.addActionListener(e -> drawPanel.setShape("Circle"));
        squareButton.addActionListener(e -> drawPanel.setShape("Square"));
        triangleButton.addActionListener(e -> drawPanel.setShape("Triangle"));

        setVisible(true);
    }

    // Custom JPanel for drawing shapes
    class DrawPanel extends JPanel {
        private String shape = "";

        public void setShape(String shape) {
            this.shape = shape;
            repaint(); // Redraw the panel
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            switch (shape) {
                case "Circle":
                    g.setColor(Color.RED);
                    g.fillOval(centerX - 50, centerY - 50, 100, 100);
                    break;
                case "Square":
                    g.setColor(Color.BLUE);
                    g.fillRect(centerX - 50, centerY - 50, 100, 100);
                    break;
                case "Triangle":
                    g.setColor(Color.GREEN);
                    int[] xPoints = {centerX, centerX - 50, centerX + 50};
                    int[] yPoints = {centerY - 50, centerY + 50, centerY + 50};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new ShapeDrawer();
    }
}
