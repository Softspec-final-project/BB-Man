package game;

import model.Sprite;
import runHere.Main;

import java.util.Observable;
import java.util.Observer;

public class Man implements Sprite, Observer {
    private int x;
    private int y;
    private Main display;
    ///////////////////////////////////////////////
    //  1 = front, 2 = back, 3 = left, 4 = right //
    ///////////////////////////////////////////////
    private int direction;
    private boolean isAlive;
    private static Man instance;

    private Man(Main display) {
        this.x = 64;
        this.y = 64;
        this.direction = 1;
        this.isAlive = true;
        this.display = display;
    }

    public static Man getInstance(Main display) {
        if(instance == null) {
            instance = new Man(display);
        }
        return instance;
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

    @Override
    public void move() {
        //TODO: move player

    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
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
        }
    }
}
