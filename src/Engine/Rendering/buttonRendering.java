package Engine.Rendering;

import javax.swing.*;
import java.awt.*;

public class buttonRendering {

    private final JFrame frame;

    public buttonRendering(JFrame frame){
        this.frame = frame;
    }

    /**
     * Render a clickable button onto a defined window.
     *
     * @param xPosition an integer specifying where on the x-axis the button should be drawn.
     * @param yPosition an integer specifying where on the y-axis the button should be drawn.
     * @param width an integer specifying the width of the button.
     * @param height an integer specifying the length of the button.
     */
    public void addButton(int xPosition, int yPosition, int width, int height){

        JButton button = new JButton();
        button.setBounds(xPosition,yPosition,width,height);
        button.addActionListener(e -> System.out.println("Pressed !"));

        frame.add(button);
        frame.setVisible(true);

    }

    /**
     * Render a clickable button with an image background onto a defined window.
     *
     * @param xPosition an integer specifying where on the x-axis the button should be drawn.
     * @param yPosition an integer specifying where on the y-axis the button should be drawn.
     * @param width an integer specifying the width of the button.
     * @param height an integer specifying the length of the button.
     * @param imageName a String storing the name and extension of the image used as the background of the button.
     */
    public void addCustomButton(int xPosition, int yPosition, int width, int height, String imageName){

        ImageIcon image = new ImageIcon(imageName);

        JButton button = new JButton();
        button.setBounds(xPosition,yPosition,width,height);
        button.addActionListener(e -> System.out.println("Pressed !"));
        button.setIcon(image);
        //removes the small border around the image, visible if the button is bigger than the image
        button.setFocusPainted(false);

        frame.add(button);
        frame.setVisible(true);

    }

    /**
     * Render a clickable button with a title and image background onto a defined window.
     *
     * @param xPosition an integer specifying where on the x-axis the button should be drawn.
     * @param yPosition an integer specifying where on the y-axis the button should be drawn.
     * @param width an integer specifying the width of the button.
     * @param height an integer specifying the length of the button.
     * @param imageName a String storing the name and extension of the image used as the background of the button.
     * @param buttonText a String storing the title text rendered centrally across the width of the button.
     */
    public void addCustomButton(int xPosition, int yPosition, int width, int height, String imageName, String buttonText){

        ImageIcon image = new ImageIcon(imageName);

        JButton button = new JButton();
        button.setBounds(xPosition,yPosition,width,height);
        button.addActionListener(a -> System.out.println("Pressed !"));
        frame.setVisible(true);
        button.setIcon(image);
        button.setFocusPainted(false);
        button.setText(buttonText);
        // center the text otherwise a big image could push it off the size of the button
        button.setHorizontalTextPosition(0);
        button.setVerticalTextPosition(0);

        Font font = new Font("SansSerif", Font.BOLD, 20);
        button.setFont(font);

        frame.add(button);
        frame.setVisible(true);

    }
}
