package game;

import model.Block;
import runHere.Main;

public class MetalBlock implements Block {
    private int x;
    private int y;
    private Main display;

    public MetalBlock(int x, int y, Main display) {
        super();
        this.x = x;
        this.y = y;
        this.display = display;
    }

    @Override
    public void render() {
        display.image(display.MetalBlock, this.x, this.y);
    }

}
