package game;

import model.Operation;
import model.Sprite;
import runHere.Main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Villain extends Observable implements Sprite, Observer {
    private final int xF;
    private final int yF;
    private int x;
    private int y;
    private Main display;
    private int direction;
    private boolean isAlive;
    private ArrayList<Operation> replay;
    private ArrayList<Long> flashPoint;
    private Bomb bomb;

    public Villain(int x, int y, Main display) {
        this.xF = x;
        this.yF = y;
        this.x = x;
        this.y = y;
        this.display = display;
        this.direction = 1;
        this.isAlive = true;
        this.flashPoint = new ArrayList<>();
        this.replay = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    @Override
    public void boomBoom() {
        bomb.burnBabyBurn(this.x, this.y);
    }

    @Override
    public Bomb getBomb() {
        return this.bomb;
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
    public void move(int m, int x, int y) {
        this.direction = m;
        this.x += x;
        this.y += y;
        render();
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void addReplay(Operation o) {
        replay.add(o);
    }

    @Override
    public void addTime(Long l) {
        flashPoint.add(l);
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO kill villain in dead area
        Coordinates cs = Coordinates.getInstance();
        for (int i = 0; i < cs.getXs().size(); i++) {
            if (cs.getTypes().get(i) == 0 && this.x == cs.getXs().get(i) && this.y == cs.getYs().get(i)) {
                kill();
                setChanged();
                notifyObservers(1);
            }
        }

    }

    public void kill() {
        this.isAlive = false;
        setX(1);
        setY(1);
    }

    @Override
    public void render() {
        bomb.render();
        if(this.direction == 1) {
            display.image(display.VillainF, this.x, this.y);
        } else if(this.direction == 2) {
            display.image(display.VillainB, this.x, this.y);
        } else if(this.direction == 3) {
            display.image(display.VillainL, this.x, this.y);
        } else if(this.direction == 4) {
            display.image(display.VillainR, this.x, this.y);
        }
    }

    public void addBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public void reset() {
        x = xF;
        y = yF;
        isAlive = true;
        direction = 1;
        render();
    }

    @Override
    public ArrayList<Operation> getReplay() {
        return replay;
    }

    @Override
    public ArrayList<Long> getFlashPoint() {
        return flashPoint;
    }
}
