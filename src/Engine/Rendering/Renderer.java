package Engine.Rendering;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Renderer {
    private final int xResolution;
    private final int yResolution;
    private final String windowTitle;

    private JFrame frame;

    public Renderer(int xResolution, int yResolution, String windowTitle) {
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.windowTitle = windowTitle;
    }

    public void Window() {

        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xResolution, yResolution);
        frame.setLayout(null);

    }

    public void addImage(int xPosition, int yPosition, int width, int height){

        ImageIcon image = new ImageIcon("stingRay.png");

        Border border = BorderFactory.createLineBorder(Color.red,3);

        JLabel label = new JLabel();

        label.setBounds(xPosition,yPosition,width,height);
        label.setIcon(image);
        label.setBorder(border);

        frame.setVisible(true);
        frame.add(label);

    }
}