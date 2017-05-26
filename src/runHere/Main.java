package runHere;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;

public class Main extends PApplet {
    private Game g = Game.getInstance(this);
    public PImage END;
    public PImage WIN;
    public PImage LOSE;
    public PImage ManF;
    public PImage ManB;
    public PImage ManR;
    public PImage ManL;
    public PImage Bomb;
    public PImage Title;
    public PImage Floor;
    public PImage VillainF;
    public PImage VillainB;
    public PImage VillainR;
    public PImage VillainL;
    public PImage END_TITLE;
    public PImage BlickBlock;
    public PImage MetalBlock;
    public ArrayList<PImage> Flame;
    private boolean canMove = true;
    public boolean isStart = false;
    public boolean isEnd;
    public static void main(String[] args) {
        PApplet.main("runHere.Main");
    }

    public void settings() {
        size(960,832);
    }

    public void setup() {
        Flame = new ArrayList<>();
        END = loadImage("Images/End.png");
        WIN = loadImage("Images/WIN.png");
        LOSE = loadImage("Images/LOSE.png");
        Floor = loadImage("Images/Floor.png");
        Title = loadImage("Images/Title.png");
        Flame.add(loadImage("Images/Flame/Flame_f00.png"));
        Flame.add(loadImage("Images/Flame/Flame_f01.png"));
        Flame.add(loadImage("Images/Flame/Flame_f02.png"));
        Flame.add(loadImage("Images/Flame/Flame_f03.png"));
        Flame.add(loadImage("Images/Flame/Flame_f04.png"));
        ManF = loadImage("Images/Sprite/Bomberman/BBMan_F.png");
        ManB = loadImage("Images/Sprite/Bomberman/BBMan_B.png");
        ManR = loadImage("Images/Sprite/Bomberman/BBMan_R.png");
        ManL = loadImage("Images/Sprite/Bomberman/BBMan_L.png");
        VillainF = loadImage("Images/Sprite/Creep/Villain_F.png");
        VillainB = loadImage("Images/Sprite/Creep/Villain_B.png");
        VillainR = loadImage("Images/Sprite/Creep/Villain_R.png");
        VillainL = loadImage("Images/Sprite/Creep/Villain_L.png");
        Bomb = loadImage("Images/Bomb/Bomb.png");
        BlickBlock = loadImage("Images/Blick/BlickBlock.png");
        MetalBlock = loadImage("Images/Blick/MetalBlock.png");
        fill(120,50,240);
    }

    public void draw() {
        if(isStart) {
            g.repaint();
            if(isEnd){
                image(END, 0, 0);
                image(END_TITLE, 0, 0);
            }
        } else {
            image(Title, 0, 0);
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        if(mouseX >=192 && mouseX <=435 && mouseY >=528 && mouseY <=604 ) {
            isStart = true;
            isEnd = false;
            g.replay();
        }
        if(mouseX >=548 && mouseX <=791 && mouseY >=528 && mouseY <=604 ) {
            isStart = true;
            isEnd = false;
            g.restart();
            g.setGameStartTime(System.currentTimeMillis());
        }

    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(isStart) {
            if (!g.getReplay() && canMove) {
                canMove = false;
                if (event.getKeyCode() == UP) {
                    g.addOperation(g.getPlayer(), 1);
                } else if (event.getKeyCode() == DOWN) {
                    g.addOperation(g.getPlayer(), 2);
                } else if (event.getKeyCode() == LEFT) {
                    g.addOperation(g.getPlayer(), 3);
                } else if (event.getKeyCode() == RIGHT) {
                    g.addOperation(g.getPlayer(), 4);
                } else if (event.getKeyCode() == 32) {
                    g.addOperation(g.getPlayer(), 0);
                }
            }
        } else {
            if(event.getKeyCode() == 32) {
                isStart = true;
                isEnd = false;
                g.setGameStartTime(System.currentTimeMillis());
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent event) {
        canMove = true;
    }
}
