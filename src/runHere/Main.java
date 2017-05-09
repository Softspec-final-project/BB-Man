package runHere;

import processing.core.PApplet;
import runHere.Game;

public class Main extends PApplet {
    public Game g = Game.getInstance(this);
    public static void main(String[] args) {
        PApplet.main("runHere.Main");
    }

    public void settings() {
        size(960,832);
    }

    public void setup() {
        fill(120,50,240);
    }

    public void draw() {
//        rect(width/2,height/2,second(),second());
        g.repaint();
    }
}
