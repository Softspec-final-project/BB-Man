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
    private int timeStamp;
    private Fire f;

    public Bomb(Main display) {
        this.x = -64;
        this.y = -64;
        this.display = display;
        this.timeStamp = 0;
        this.f = new Fire(display);
    }

    public void burnBabyBurn(int x, int y){
        this.x = x;
        this.y = y;
        this.f.start(x+64, y);
        this.timeStamp = display.millis();
        render();
        setChanged();
//        notifyObservers(String.format("",));
    }

    @Override
    public void render() {
        if(display.millis() - this.timeStamp < 2000) {
            display.image(display.Bomb, this.x, this.y);
        } else {
            this.x = -64;
            this.y = -64;
            this.f.stop();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
