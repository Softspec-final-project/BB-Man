package game;

import model.Sprite;

import java.util.Observable;
import java.util.Observer;

public class Man implements Sprite, Observer {
    private int x;
    private int y;
    private boolean isAlive;
    private static Man instance;

    private Man() {
        this.x = 1;
        this.y = 1;
        isAlive = true;
    }

    public static Man getInstance() {
        if(instance == null) {
            instance = new Man();
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

    @Override
    public void move() {

    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO: kill player if in the dead area
    }

    @Override
    public void render() {

    }
}
