package runHere;

import game.BlickBlock;
import processing.core.PApplet;
import processing.core.PImage;
import runHere.Game;

public class Main extends PApplet {
    public Game g = Game.getInstance(this);
    public PImage Floor;
    public PImage ManF;
    public PImage ManB;
    public PImage ManR;
    public PImage ManL;
    public PImage BlickBlock;
    public PImage MetalBlock;
    public static void main(String[] args) {
        PApplet.main("runHere.Main");
    }

    public void settings() {
        size(960,832);
    }

    public void setup() {
        Floor = loadImage("Images/Floor.png");
        ManF = loadImage("Images/Sprite/Bomberman/BBMan_F.png");
        ManB = loadImage("Images/Sprite/Bomberman/BBMan_B.png");
        ManR = loadImage("Images/Sprite/Bomberman/BBMan_R.png");
        ManL = loadImage("Images/Sprite/Bomberman/BBMan_L.png");
        BlickBlock = loadImage("Images/Blick/BlickBlock.png");
        MetalBlock = loadImage("Images/Blick/MetalBlock.png");
        fill(120,50,240);
    }

    public void draw() {
        image(Floor, 0, 0);
        g.repaint();
    }
}
