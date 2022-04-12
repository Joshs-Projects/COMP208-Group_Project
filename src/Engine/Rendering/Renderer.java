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
        //layout set as null so labels can be positioned with specific x and y coordinates
        frame.setLayout(null);
    }

    // default method with all the required parameters needed to add an image

    public void addImage(String imageName,int xPosition, int yPosition, int width, int height){

        ImageIcon image = new ImageIcon(imageName);

        JLabel label = new JLabel();

        label.setBounds(xPosition,yPosition,width,height);
        label.setIcon(image);

        frame.add(label);
        frame.setVisible(true);


    }

    // Optional parameters to add a hit box

    public void addImage(String imageName,int xPosition, int yPosition, int width, int height, Color hitColour, int hitThickness){

        ImageIcon image = new ImageIcon(imageName);

        Border border = BorderFactory.createLineBorder(hitColour,hitThickness);

        JLabel label = new JLabel();

        label.setBounds(xPosition,yPosition,width,height);
        label.setIcon(image);
        label.setBorder(border);

        frame.add(label);
        frame.setVisible(true);

    }

    public void addButton(int xPosition, int yPosition, int width, int height){

        JButton button = new JButton();
        button.setBounds(xPosition,yPosition,width,height);
        button.addActionListener(e -> System.out.println("Pressed !"));

        frame.add(button);
        frame.setVisible(true);

    }

    // default custom button

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

    // customised button with an image and text

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

    public void pauseMenu(){

        // remove all other objects from the frame while paused
        frame.getContentPane().removeAll();
        frame.repaint();

        //layout set as a grid to center the middle button
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton Resume = new JButton("Resume");
        JButton Options = new JButton("Options");
        JButton Exit = new JButton("Exit");

        gbc.gridx = 0;
        gbc.gridy = 0;
        Resume.setPreferredSize(new Dimension(100, 100));
        Resume.addActionListener(r -> System.out.println("Resume"));
        frame.add(Resume,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        Options.setPreferredSize(new Dimension(100, 100));
        Options.addActionListener(o -> System.out.println("Options"));
        frame.add(Options,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        Exit.setPreferredSize(new Dimension(100, 100));
        Exit.addActionListener(e -> System.out.println("Exit"));
        frame.add(Exit,gbc);

        frame.setVisible(true);

    }




}