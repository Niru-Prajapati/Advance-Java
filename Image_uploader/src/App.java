import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class App implements ActionListener {
    JFrame f;
    JButton uploadButton;
    JLabel imageLabel;
    public App() {
        f = new JFrame("Image Uploader");
        uploadButton = new JButton("Upload Image");
        uploadButton.addActionListener(this);
        imageLabel = new JLabel("No Image Selected");
        f.add(uploadButton);
        f.add(imageLabel);
        f.setSize(500, 400);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == uploadButton) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();                
                ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                imageLabel.setIcon(icon);
                imageLabel.setText(""); 
            }
        }
    }
}