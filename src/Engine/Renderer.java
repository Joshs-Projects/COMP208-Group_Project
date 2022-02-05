package Engine;

import javax.swing.*;

public class Renderer {
    private int xResolution;
    private int yResolution;

    private String windowTitle;

    //Object gameObject;
    public JFrame frame;
    public void DrawWindow(){
        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xResolution, yResolution);

        frame.setLayout(null);
        frame.setVisible(true);

        System.out.println("Drawn");

    }

    public Renderer(int xResolution, int yResolution, String windowTitle/*, Object gameObject*/){
        this.xResolution = xResolution;
        this.yResolution = yResolution;

        this.windowTitle = windowTitle;

        //this.gameObject = gameObject;
    }

    public static void main(String args[]){
        Renderer display = new Renderer(720, 400, "testing");

        display.DrawWindow();

    }
}
