package game;

import model.Component;
import runHere.Main;

/**
 * Created by Thanut Sajjakulnukti 5810545416 on 5/5/2017 AD.
 */
public class Fire implements Component {
    private int x;
    private int y;
    private Main display;
    private boolean isFireing;

    public Fire(Main display) {
        this.x = x;
        this.y = y;
        this.isFireing = false;
        this.display = display;
    }

    public void start(int x, int y) {
        this.isFireing = true;
        this.x = x;
        this.y = y;
    }

    public void stop() {
        this.isFireing = false;
        this.x = -64;
        this.y = -64;
    }

    @Override
    public void render() {
        for(int i = 0 ; isFireing ; i++) {
            display.image(display.Flame.get(i % 4), this.x, this.y);
        }
    }
}
