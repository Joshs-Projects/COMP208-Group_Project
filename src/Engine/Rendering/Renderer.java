package Engine.Rendering;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

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
        frame.getContentPane().setBackground(Color.decode("#e6e6e6"));

        //layout set as a grid to center the middle button
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        gridBag.insets = new Insets(5,0,0,0);

        Font font = new Font("SansSerif",Font.PLAIN,30);

        JButton Resume = new JButton("Resume");
        JButton Options = new JButton("Options");
        JButton Exit = new JButton("Exit");

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        Resume.setPreferredSize(new Dimension(230, 175));
        Resume.setFocusPainted(false);
        Resume.setBackground(Color.decode("#1473b8"));
        Resume.setForeground(Color.decode("#000000"));
        Resume.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        Resume.setFont(font);
        Resume.addActionListener(r -> System.out.println("Resume"));
        Resume.addActionListener(r -> frame.getContentPane().removeAll());
        Resume.addActionListener(r -> frame.repaint());
        Resume.addActionListener(r -> frame.getContentPane().setBackground(Color.decode("#ffffff")));
        frame.add(Resume,gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 1;
        Options.setPreferredSize(new Dimension(230, 175));
        Options.setFocusPainted(false);
        Options.setBackground(Color.decode("#1473b8"));
        Options.setForeground(Color.decode("#000000"));
        Options.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        Options.setFont(font);
        Options.addActionListener(o -> System.out.println("Options"));
        frame.add(Options,gridBag);

        gridBag.gridx = 0;
        gridBag.gridy = 2;
        Exit.setPreferredSize(new Dimension(230, 175));
        Exit.setFocusPainted(false);
        Exit.setBackground(Color.decode("#1473b8"));
        Exit.setForeground(Color.decode("#000000"));
        Exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        Exit.addActionListener(e -> frame.dispose());
        Exit.setFont(font);
        frame.add(Exit,gridBag);

        frame.setVisible(true);

    }

    public void clearScreen(){
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    public void addText(){

        Border border = BorderFactory.createLineBorder(Color.GREEN);

        JLabel label = new JLabel();
        label.setText("Blaise");
        label.setBounds(100, 100, 100, 100);
        label.setBorder(border);

        frame.setVisible(true);
        frame.add(label);

    }



}