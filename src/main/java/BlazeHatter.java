import net.dv8tion.jda.api.entities.Message;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlazeHatter extends JFrame {
    private ImageIcon icon;
    private JLabel label;
    private ImageIcon input;
    private JLabel inputLabel;
    final int ICON_WIDTH = 143;
    final int ICON_HEIGHT = 148;
    public BlazeHatter() {
        setLayout(null);
        icon = new ImageIcon(getClass().getResource("blazehat.png"));
        label = new JLabel(icon);
        label.setBounds(0, 0, ICON_WIDTH, ICON_HEIGHT);
        add(label);
    }
    public int[] run() throws IOException {
        input = new ImageIcon(ImageIO.read(new File("src/main/resources/input.png")));
        int newHeight =input.getIconHeight()*ICON_WIDTH/input.getIconWidth();
        input = new ImageIcon(ImageIO.read(new File("src/main/resources/input.png")).getScaledInstance(ICON_WIDTH/2,newHeight/2, Image.SCALE_FAST ));
        inputLabel = new JLabel(input);
        inputLabel.setBounds(0,ICON_HEIGHT/4,ICON_WIDTH,newHeight/2);
        add(inputLabel);
        return new int[]{
                ICON_WIDTH,
                Math.max(newHeight/2 + (ICON_HEIGHT/4), ICON_HEIGHT)
        };
    }
    public void undo() {
        remove(inputLabel);
    }
}
