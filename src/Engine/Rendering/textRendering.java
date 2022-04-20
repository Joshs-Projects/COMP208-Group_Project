package Engine.Rendering;

import javax.swing.*;
import java.awt.*;

public class textRendering {

    private final JFrame frame;

    public textRendering(JFrame frame){
        this.frame = frame;
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
