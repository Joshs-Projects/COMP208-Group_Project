/**
 * The Renderer class defines functions to use when drawing objects on the screen in the Red Ray Engine.
 * Adding images, text, and buttons, with a variety of customisation options.
 * It provides the ability to draw multiple images and clear them from the screen to allow for animation within a game.
 * With a pre-built pause menu to use within a game.
 *
 * @author Ethan Myles.
 */

package Engine.Rendering;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Renderer {
    private final int xResolution;
    private final int yResolution;
    private final String windowTitle;

    private JFrame frame;

    /**
     * Constructor defining the window size and title.
     *
     * @param xResolution an integer that specifies the width of the window.
     * @param yResolution an integer that specifies the length of the window.
     * @param windowTitle an integer that specifies the title for the window.
     */
    public Renderer(int xResolution, int yResolution, String windowTitle) {
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.windowTitle = windowTitle;
    }

    /**
     * Creates a window setting its size and layout.
     */
    public void Window() {

        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xResolution, yResolution);
        //layout set as null so labels can be positioned with specific x and y coordinates
        frame.setLayout(null);
    }

    public JFrame getFrame(){

        return frame;
    }

    /**
     * Render a three button menu with Resume, Options and Exit choices.
     */
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

    /**
     * Removes all objects drawn currently on a defined window.
     */
    public void clearScreen(){
        frame.getContentPane().removeAll();
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    /**
     * Render text on a defined window.
     *
     * @param text a String storing the characters to be shown.
     * @param textX an integer specifying where on the x-axis the text should be drawn.
     * @param textY an integer specifying where on the y-axis the text should be drawn.
     * @param textSize an integer specifying the scale of the text.
     */
    public void addText(String text,int textX,int textY,int textSize){

        Font font = new Font("SansSerif",Font.PLAIN,textSize);

        int characterLength = text.length();

        JLabel label = new JLabel();
        label.setText(text);
        label.setBounds(textX,textY,(characterLength*(textSize/2)),textSize*2);
        label.setFont(font);

        frame.setVisible(true);
        frame.add(label);

    }

    /**
     * Render text with a font and colour on a defined window.
     *
     * @param text a String storing the characters to be shown.
     * @param textX an integer specifying where on the x-axis the text should be drawn.
     * @param textY an integer specifying where on the y-axis the text should be drawn.
     * @param textSize an integer specifying the scale of the text.
     * @param textFont a String storing the name of the font typeface.
     * @param textColor a Color specifying the colour of the text.
     */
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

    /**
     * Render text with a font, style and colour on a defined window.
     *
     * @param text a String storing the characters to be shown.
     * @param textX an integer specifying where on the x-axis the text should be drawn.
     * @param textY an integer specifying where on the y-axis the text should be drawn.
     * @param textSize an integer specifying the scale of the text.
     * @param textFont a String storing the name of the font typeface.
     * @param textStyle a String storing the name of the font typestyle.
     * @param textColor a Color specifying the colour of the text.
     */
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

    /**
     * Render text with a font, style and colour, with the option to be reversed, on a defined window.
     *
     * @param text a String storing the characters to be shown.
     * @param textX an integer specifying where on the x-axis the text should be drawn.
     * @param textY an integer specifying where on the y-axis the text should be drawn.
     * @param textSize an integer specifying the scale of the text.
     * @param textFont a String storing the name of the font typeface.
     * @param textStyle a String storing the name of the font typestyle.
     * @param textColor a Color specifying the colour of the text.
     * @param textReverse a boolean specifying weather the characters in text should be rendered in the opposite order.
     */
    public void addCustomText(String text,int textX,int textY,int textSize,String textFont, int textStyle, Color textColor, boolean textMirror, boolean textReverse){

        Font font = new Font(textFont,textStyle,textSize);

        int characterLength = text.length();

        JLabel label = new JLabel();

        if (textMirror){
            String mirroredText = new StringBuilder(text).reverse().toString();
            label.setText(mirroredText);
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