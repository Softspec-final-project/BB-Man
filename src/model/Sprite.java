package model;

public interface Sprite extends Component {
    public void move(int m, int x, int y);
    public boolean isAlive();
}
