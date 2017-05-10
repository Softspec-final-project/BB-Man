package model;

public interface Sprite extends Component {
    public void move(int m, int x, int y);
    public boolean isAlive();
    public void addReplay(Operation o);
    public int getY();
    public int getX();
    public void boomBoom();
}
