import Engine.Rendering.Renderer;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "Testing");

        //Draw function allowing the user to draw x y size image image to display, user puts in an object.

        display.DrawWindow();
        display.DrawObject();

        return;
    }

    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }


}
