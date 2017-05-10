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
}
