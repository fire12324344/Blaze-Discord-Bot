package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


public class BlazeHatter extends JFrame {
    private ImageIcon icon;
    private JLabel label;
    private ImageIcon icon2;
    private JLabel label2;

    public BlazeHatter() throws IOException {
        setLayout(null);
        icon = new ImageIcon(getClass().getResource("blaze_hat.png"));
        label = new JLabel(icon);
        label.setBounds(0,0,143,148);
        add(label);
        icon2 = new ImageIcon(ImageIO.read(new File("src/com/company/test.png")) .getScaledInstance(72, 74, Image.SCALE_FAST));
        label2 = new JLabel(icon2);
        label2.setBounds(0, 0, 143,148);
        add(label2);
    }
}
