package Engine.Rendering;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Renderer {
    private int xResolution;
    private int yResolution;

    private String color;
    private int objectX;
    private int objectY;
    private int objectH;
    private int objectW;
    private String path;

    private String windowTitle;

    //Object gameObject;
    //overall frame
    private JFrame frame;

    //THINGS TO DRAW. MAYBE NEEDED MAYBE NOT.
    //list of assests
    ArrayList<Assets> ItemsToRender = new ArrayList<Assets>();

    public Renderer(int xResolution, int yResolution, String windowTitle) {
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.windowTitle = windowTitle;
    }

    public JFrame drawWindow() {
        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xResolution, yResolution);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        return frame;

    }

    public void DrawObject(int ObjectX,int ObjectY,int ObjectH,int ObjcetW){
        JPanel panel = new JPanel();
        panel.setBounds(40,80,200,200);
        //default colour
        panel.setBackground(Color.black);
        frame.add(panel);
    }

    //With optional parameter of color
    public void DrawObject(int ObjectX,int ObjectY,int ObjectH,int ObjcetW, Color color){
        JPanel panel = new JPanel();
        panel.setBounds(40,80,200,200);
        panel.setBackground(color);
        frame.add(panel);
    }

    public void DrawObject(int ObjectX,int ObjectY,int ObjectH,int ObjcetW,String path){
        JLabel label = new JLabel(new ImageIcon(path));
        label.setBounds(40,80,200,200);
        frame.add(label);
    }
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
