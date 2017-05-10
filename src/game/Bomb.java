package game;

import model.Block;
import model.Component;
import runHere.Game;
import runHere.Main;

import java.util.Observable;

public class Bomb extends Observable implements Component , Block {
    private final int radius = 2;
    private int x;
    private int y;
    private Main display;
    private Game game;

    public Bomb(int x, int y, Main display, Game g) {
        this.x = x;
        this.y = y;
        this.display = display;
    }

    public void burnBabyBurn(int x, int y){
        this.x = x;
        this.y = y;
        render();
        setChanged();
//        notifyObservers(String.format("",));
    }

    @Override
    public void render() {
//        int start = display.second();
//        if(Math.abs(display.second() - start) != 3) {
            display.image(display.Bomb, this.x, this.y);
//        }
//        display.redraw();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
