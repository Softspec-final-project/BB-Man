package game;

import model.Block;
import runHere.Main;

import java.util.Observable;
import java.util.Observer;

import static processing.core.PApplet.second;

public class BrickBlock implements Block {
    private int x;
    private int y;
    private Main display;

    public BrickBlock(int x, int y, Main display) {
        super();
        this.x = x;
        this.y = y;
        this.display = display;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void render() {
        display.image(display.BlickBlock, this.x, this.y);
    }
}
