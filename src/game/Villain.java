package game;

import model.Operation;
import model.Sprite;
import runHere.Main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Villain implements Sprite, Observer {
    private int x;
    private int y;
    private Main display;
    private int direction;
    private boolean isAlive;
    private ArrayList<Operation> replay;
    private Bomb bomb;

    public Villain(int x, int y, Main display) {
        this.x = x;
        this.y = y;
        this.display = display;
        this.direction = 1;
        this.isAlive = true;
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
    public void update(Observable o, Object arg) {
        //TODO kill villain in dead area
        Coordinates cs = Coordinates.getInstance();
        for (int i = 0; i < cs.getXs().size(); i++) {
            if (cs.getTypes().get(i) == 0 && this.x == cs.getXs().get(i) && this.y == cs.getYs().get(i)) {
                kill();
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

}
