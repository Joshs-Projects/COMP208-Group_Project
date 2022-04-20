/**
 * draw images on a window, with a variety of customisation options.
 *
 * @author Ethan Myles.
 */

package Engine.Rendering;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class imageRendering{

    private final JFrame frame;

    public imageRendering(JFrame frame){
        this.frame = frame;
    }

    /**
     * Render an image onto a defined window.
     *
     * @param imageName a String storing the name and extension of the image.
     * @param xPosition an integer specifying where on the x-axis the image should be drawn.
     * @param yPosition an integer specifying where on the y-axis the image should be drawn.
     * @param width an integer specifying the width of the image to define the size of the Jlabel.
     * @param height an integer specifying the length of the image to define the size of the Jlabel.
     */
    public void addImage(String imageName,int xPosition, int yPosition, int width, int height){

        ImageIcon image = new ImageIcon(imageName);

        JLabel label = new JLabel();

        label.setBounds(xPosition,yPosition,width,height);
        label.setIcon(image);

        frame.add(label);
        frame.setVisible(true);

    }

    /**
     * Render an image with a hit-box around the perimeter.
     *
     * @param imageName a String storing the name and extension of the image.
     * @param xPosition an integer specifying where on the x-axis the image should be drawn.
     * @param yPosition an integer specifying where on the y-axis the image should be drawn.
     * @param width an integer specifying the width of the image to define the size of the Jlabel.
     * @param height an integer specifying the length of the image to define the size of the Jlabel.
     * @param hitColour a Color specifying the colour of the hit-box.
     * @param hitThickness an integer specifying the amount of pixels in the line surrounding the image.
     */
    public void addImage(String imageName, int xPosition, int yPosition, int width, int height, Color hitColour, int hitThickness){

        ImageIcon image = new ImageIcon(imageName);

        Border border = BorderFactory.createLineBorder(hitColour,hitThickness);

        JLabel label = new JLabel();

        label.setBounds(xPosition,yPosition,width,height);
        label.setIcon(image);
        label.setBorder(border);

        frame.add(label);
        frame.setVisible(true);

    }
}
