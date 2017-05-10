package game;

import model.Operation;
import model.Sprite;
import runHere.Main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Man implements Sprite, Observer {
    private int x;
    private int y;
    private Bomb bomb;
    private Main display;
    private ArrayList<Operation> replay;
    ///////////////////////////////////////////////
    //  1 = front, 2 = back, 3 = left, 4 = right //
    ///////////////////////////////////////////////
    private int direction;
    private boolean isAlive;
    private static Man instance;

    private Man(Bomb b) {
        this.x = 64;
        this.y = 64;
        this.bomb = b;
        this.direction = 1;
        this.isAlive = true;
        this.replay = new ArrayList<>();
    }

    public static Man getInstance(Bomb b) {
        if(instance == null) {
            instance = new Man(b);
        }
        return instance;
    }

    public void addDisplay (Main display) {
        this.display = display;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void kill() {
        this.isAlive = false;
        setX(1);
        setY(1);
    }

    public void boomBoom() {
        bomb.burnBabyBurn(this.x, this.y);
    }

    @Override
    public void move(int m, int x, int y) {
        //TODO: move player
        this.direction = m;
        this.x += x;
        this.y += y;
        render();
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void addReplay(Operation o) {
        replay.add(o);
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO: kill player if in the dead area or hit villain

    }

    @Override
    public void render() {
        if(this.direction == 1) {
            display.image(display.ManF, this.x, this.y);
        } else if(this.direction == 2) {
            display.image(display.ManB, this.x, this.y);
        } else if(this.direction == 3) {
            display.image(display.ManL, this.x, this.y);
        } else if(this.direction == 4) {
            display.image(display.ManR, this.x, this.y);
        } else {
            // Plant Bomb
        }
    }
}
