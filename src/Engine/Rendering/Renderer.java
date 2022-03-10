package Engine.Rendering;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Renderer {
    private int xResolution;
    private int yResolution;
    private String color;

    private String windowTitle;

    //Object gameObject;
    //overall frame
    private JFrame frame;

    //THINGS TO DRAW. MAYBE NEEDED MAYBE NOT.
    //list of assests
    ArrayList<Assets> ItemsToRender = new ArrayList<Assets>();

    public Renderer(int xResolution, int yResolution, String windowTitle){
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.windowTitle = windowTitle;
    }

    public void DrawWindow(){
        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xResolution, yResolution);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void DrawObject(){
        JPanel panel = new JPanel();
        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.red);
        frame.add(panel);
    }

    //THIS IS TO TRY TO DRAW A THING ON SCREEN
    /*
    public void DrawAssets(Graphics g){
        g.drawImage(ItemsToRender.get(0).getImage(), 32, 32, frame);
        g.fillRect(50, 50, 1000, 100);
    }
    */
    /*
    public void AddThingToRender(Assets newThing) throws RuntimeException {
        ItemsToRender.add(newThing);

        DrawAssets(frame.getGraphics());

    }
    */

    //THIS IS THE END OF TRYING TO DRAW STUFF ON SCREEN

}
