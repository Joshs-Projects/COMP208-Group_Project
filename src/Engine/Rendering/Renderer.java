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

    // Deafault function for drawing text to a window

    public void addText(String text,int positionX,int positionY,int textSize){

        Font font = new Font("SansSerif",Font.PLAIN,textSize);

        int characterLength = text.length();

        JLabel label = new JLabel();
        label.setText(text);
        label.setBounds(positionX,positionY,(characterLength*(textSize/2)),textSize*2);
        label.setFont(font);

        frame.setVisible(true);
        frame.add(label);

    }

    // Optional parameters to add the font and the colour of the text

    public void addCustomText(String text,int textX,int textY,int textSize,String textFont,Color textColor){

        Font font = new Font(textFont,Font.PLAIN,textSize);

        int characterLength = text.length();

        JLabel label = new JLabel();
        label.setText(text);
        label.setBounds(textX,textY,(characterLength*(textSize/2)),textSize*2);
        label.setForeground(textColor);
        label.setFont(font);

        frame.setVisible(true);
        frame.add(label);

    }

    // Optional parameters to add the style of the font, 0 for plain, 1 for bold.

    public void addCustomText(String text,int textX,int textY,int textSize,String textFont, int textStyle, Color textColor){

        Font font = new Font(textFont,textStyle,textSize);

        int characterLength = text.length();

        JLabel label = new JLabel();
        label.setText(text);
        label.setBounds(textX,textY,(characterLength*(textSize/2)),textSize*2);
        label.setForeground(textColor);
        label.setFont(font);

        frame.setVisible(true);
        frame.add(label);

    }

    // Optional parameter to reverse the letters in the text.

    public void addCustomText(String text,int textX,int textY,int textSize,String textFont, int textStyle, Color textColor, boolean reverse){

        Font font = new Font(textFont,textStyle,textSize);

        int characterLength = text.length();

        JLabel label = new JLabel();

        if (reverse){
            String reverseText = new StringBuilder(text).reverse().toString();
            label.setText(reverseText);
        }
        else{
            label.setText(text);
        }

        label.setBounds(textX,textY,(characterLength*(textSize/2)),textSize*2);
        label.setForeground(textColor);
        label.setFont(font);

        frame.setVisible(true);
        frame.add(label);

    }

}