package runHere;

import game.BlickBlock;
import processing.core.PApplet;
import processing.core.PImage;
import runHere.Game;

public class Main extends PApplet {
    public Game g = Game.getInstance(this);
    public PImage BlickBlock;
    public PImage MetalBlock;
    public PImage Floor;
    public static void main(String[] args) {
        PApplet.main("runHere.Main");
    }

    public void settings() {
        size(960,832);
    }

    public void setup() {
        BlickBlock = loadImage("Images/Blick/BlickBlock.png");
        MetalBlock = loadImage("Images/Blick/MetalBlock.png");
        Floor = loadImage("Images/Floor.png");
        fill(120,50,240);
    }

    public void draw() {
        image(Floor, 0, 0);
        g.repaint();
    }
}
