import processing.core.PApplet;

public class Main extends PApplet {
//    public Game g = Game.getInstance();
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(960,832);
    }

    public void setup() {
        fill(120,50,240);
    }

    public void draw() {
        rect(width/2,height/2,second(),second());
//        g.repaint();
    }
}
