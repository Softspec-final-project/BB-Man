package game;

import model.Component;

import java.util.Observable;

public class Bomb extends Observable implements Component {
    private final int radius = 2;
    private int x;
    private int y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void burnBabyBurn(){

        setChanged();
//        notifyObservers(String.format("",));
    }

    @Override
    public void render() {

    }
}
