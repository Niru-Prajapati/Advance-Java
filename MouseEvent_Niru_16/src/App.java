import java.awt.*;
import java.awt.event.*;

public class App implements MouseListener {
    Label lbloutput;
    TextField txtOne;
    TextField txtTwo;
    App() {
        Frame f = new Frame();
        lbloutput = new Label();
        lbloutput.setBounds(20, 50, 100, 20);
        txtOne = new TextField();
        txtOne.setBounds(20, 80, 100, 20);
        txtTwo = new TextField();
        txtTwo.setBounds(20, 110, 100, 20);
        f.addMouseListener(this);
        f.add(lbloutput);
        f.add(txtOne);
        f.add(txtTwo);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    public void mousePressed(MouseEvent e) {
        int first = Integer.parseInt(txtOne.getText());
        int second = Integer.parseInt(txtTwo.getText());
        int result = first+second;
        lbloutput.setText(String.valueOf(result));
    }
    public void mouseReleased(MouseEvent e) {
        int first = Integer.parseInt(txtOne.getText());
        int second = Integer.parseInt(txtTwo.getText());
        int result = first-second;
        lbloutput.setText(String.valueOf(result));
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
