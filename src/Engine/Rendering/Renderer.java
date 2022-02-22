package Engine.Rendering;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Renderer {
    private int xResolution;
    private int yResolution;

    private String windowTitle;

    //Object gameObject;
    private JFrame frame;

    //THINGS TO DRAW. MAYBE NEEDED MAYBE NOT.
    ArrayList<Assets> ItemsToRender = new ArrayList<Assets>();

    public void DrawWindow(){
        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xResolution, yResolution);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    //THIS IS TO TRY TO DRAW A THING ON SCREEN

    public void DrawAssets(Graphics g){
        g.drawImage(ItemsToRender.get(0).getImage(), 32, 32, frame);
        g.fillRect(50, 50, 1000, 100);
    }

    public void AddThingToRender(Assets newThing) throws RuntimeException {
        ItemsToRender.add(newThing);

        DrawAssets(frame.getGraphics());

    }

    //THIS IS THE END OF TRYING TO DRAW STUFF ON SCREEN


    public Renderer(int xResolution, int yResolution, String windowTitle/*, Object gameObject*/){
        this.xResolution = xResolution;
        this.yResolution = yResolution;

        this.windowTitle = windowTitle;

        //this.gameObject = gameObject;
    }

}
