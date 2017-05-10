package runHere;

import game.Bomb;
import game.Man;
import game.Map;
import game.Villain;
import model.Operation;
import model.Sprite;
import operation.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static Game instance;
    private Map map;
    private Bomb bomb;
    private Man player;
    private Main display;
    private int[][] field;
    private ArrayList<Villain> bot;
    private Random random = new Random(System.currentTimeMillis());
    private Operation[] move = {new PlantBomb(), new MoveDown(), new MoveUp(), new MoveLeft(), new MoveRight()};

    private Game(Main display) {
        this.player = Man.getInstance();
        player.addDisplay(display);
        bot = new ArrayList<>();
        this.bot.add(new Villain(13*64,11*64, display));
        this.bot.add(new Villain(13*64,10*64, display));
        this.bot.add(new Villain(12*64,11*64, display));
        this.bomb = new Bomb(-64, -64, display, this);
        this.map = new Map(display);
        this.display = display;
        this.player.addBomb(this.bomb);
    }

    public static Game getInstance(Main display) {
        if(instance == null) {
            instance = new Game(display);
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
        //TODO: call render to show on the window
        this.map.render();
        this.player.render();
        for (Villain a : this.bot) {
            if (display.frameCount % 15 == 0) {
                int o = random.nextInt(5);
                addOperation(a, o);
            }
            a.render();
        }
    }

    public void addOperation(Sprite s, int o) {
        int[] step = move[o].getStep();
        try {
            if (o == 0) {
                move[0].execute(s);
            } else if (map.getBlockList()[(s.getY() + 64 * step[1]) / 64][(s.getX() + 64 * step[0]) / 64] == null && (((s.getY() + 64 * step[1]) != bomb.getY()) && ((s.getX() + 64 * step[0]) != bomb.getX()))) {
                move[o].execute(s);
                s.addReplay(move[o]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public Man getPlayer() {
        return player;
    }

    public Map getMap() { return map; }
}
