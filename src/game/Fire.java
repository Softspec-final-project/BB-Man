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
    private int timeStamp;

    public Fire(Main display) {
        this.x = -64;
        this.y = -64;
        this.timeStamp = 0;
        this.isFireing = false;
        this.display = display;
    }

    public void start(int x, int y) {
        this.isFireing = true;
        this.x = x;
        this.y = y;
        this.timeStamp = display.millis();
    }

    public void stop() {
        this.isFireing = false;
        this.x = -64;
        this.y = -64;
    }


    public boolean isFireing() {
        return isFireing;
    }

    @Override
    public void render() {
        if(display.millis() - timeStamp < 1000) {
            display.image(display.Flame.get(0), this.x, this.y);
        } else {
            stop();
        }
    }
}
