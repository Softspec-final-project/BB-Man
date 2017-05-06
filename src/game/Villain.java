package game;

import model.Sprite;

import java.util.Observable;
import java.util.Observer;

public class Villain implements Sprite, Observer {
    private int x;
    private int y;
    private boolean isAlive;

    public Villain(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
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
        //TODO kill villain in dead area
//        if(){
//            this.isAlive = false;
//        }
    }

    @Override
    public void render() {

    }
}
