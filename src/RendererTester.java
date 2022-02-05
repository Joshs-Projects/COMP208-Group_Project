import Engine.Renderer;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "Testing");

        display.DrawWindow();

        return;
    }

    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }
}
