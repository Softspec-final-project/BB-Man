package game;

import model.Operation;
import model.Sprite;
import runHere.Main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Man extends Observable implements Sprite, Observer {
    private int x;
    private int y;
    private Bomb bomb;
    private Main display;
    private ArrayList<Operation> replay;
    private ArrayList<Long> flashPoint;
    ///////////////////////////////////////////////
    //  1 = front, 2 = back, 3 = left, 4 = right //
    ///////////////////////////////////////////////
    private int direction;
    private boolean isAlive;
    private static Man instance;

    private Man() {
        this.x = 64;
        this.y = 64;
        this.direction = 1;
        this.isAlive = true;
        this.flashPoint = new ArrayList<>();
        this.replay = new ArrayList<>();
    }

    public static Man getInstance() {
        if(instance == null) {
            instance = new Man();
        }
        return instance;
    }

    public void addDisplay (Main display) {
        this.display = display;
    }

    public int getX() {
        return x;
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

    public void kill() {
        this.isAlive = false;
        setX(1);
        setY(1);
    }

    @Override
    public void boomBoom() {
        bomb.burnBabyBurn(this.x, this.y);
    }

    @Override
    public Bomb getBomb() {
        return this.bomb;
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
        Coordinates cs = Coordinates.getInstance();
        for (int i = 0; i < cs.getXs().size(); i++) {
            if (this.x == cs.getXs().get(i) && this.y == cs.getYs().get(i)) {
                kill();
                setChanged();
                notifyObservers(0);
            }
        }
    }

    @Override
    public void render() {
        bomb.render();
        if(this.direction == 1) {
            display.image(display.ManF, this.x, this.y);
        } else if(this.direction == 2) {
            display.image(display.ManB, this.x, this.y);
        } else if(this.direction == 3) {
            display.image(display.ManL, this.x, this.y);
        } else if(this.direction == 4) {
            display.image(display.ManR, this.x, this.y);
        }

    }

    public void addBomb(Bomb bomb) {
        this.bomb = bomb;
        this.bomb.setType(0);
    }

    public void reset() {
        this.x = 64;
        this.y = 64;
        this.direction = 1;
        this.isAlive = true;
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
