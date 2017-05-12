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
        this.bomb = new Bomb(display);
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
        if (player.isAlive()) {
            this.player.render();
        }
        for (Villain a : this.bot) {
            if (a.isAlive()) {
                if (display.frameCount % 15 == 0) {
                    int o = random.nextInt(5);
                    addOperation(a, o);
                }
                a.render();
            }
        }
    }

    public void addOperation(Sprite s, int o) {
        int[] step = move[o].getStep();

        try {

            if (o == 0) {
                move[0].execute(s);
            } else if (s.isAlive() && map.getBlockList()[(s.getY() + 64 * step[1]) / 64][(s.getX() + 64 * step[0]) / 64] == null && checkWalk(s, step)) {
                move[o].execute(s);
                s.addReplay(move[o]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
        }
    }

    private boolean checkWalk(Sprite s, int[] step) {
        int sX = s.getX();
        int sY = s.getY();
        int bombX = bomb.getX();
        int bombY =bomb.getY();
        return (sX + 64 * step[0]) != bombX || (sY + 64 * step[1]) != bombY;

    }

    public Man getPlayer() {
        return player;
    }

}
