import javax.swing.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Popup Example");
        JPopupMenu popupmenu = new JPopupMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        popupmenu.add(cut);
        popupmenu.add(copy);
        popupmenu.add(paste);

        f.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                popupmenu.show(f, e.getX(), e.getY());
            }
        });
        f.add(popupmenu);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
