package model;

import game.Bomb;

import java.util.ArrayList;

public interface Sprite extends Component {
    public void move(int m, int x, int y);
    public boolean isAlive();
    public void addReplay(Operation o);
    public void addTime(Long l);
    public int getY();
    public int getX();
    public void boomBoom();
    public Bomb getBomb();
    public ArrayList<Long> getFlashPoint();
    public ArrayList<Operation> getReplay();
    public void clearReplay();
    public void reset();
}
