package game;

import java.util.ArrayList;

public class Game {
    public static Game instance;
    private Man player;
    private ArrayList<Villain> bot;
    private Bomb burn;
    private Map map;
    private int[][] field;

    private Game() {
        this.player = Man.getInstance();
        this.bot.add(new Villain(12,14));
        this.bot.add(new Villain(11,14));
        this.bot.add(new Villain(12,13));
        this.burn = new Bomb(0,0);
        this.map = new Map();
    }

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
        this.map.setMaze(field);
    }

    public void repaint() {

    }
}
