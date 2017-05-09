package game;

import model.Component;
import runHere.Main;

import java.util.Observable;

public class Bomb extends Observable implements Component {
    private final int radius = 2;
    private int x;
    private int y;
    private Main display;

    public Bomb(int x, int y, Main display) {
        this.x = x;
        this.y = y;
        this.display = display;
    }

    public void burnBabyBurn(){

        setChanged();
//        notifyObservers(String.format("",));
    }

    @Override
    public void render() {

    }
}
