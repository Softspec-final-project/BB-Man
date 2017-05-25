package runHere;

import game.*;
import model.Operation;
import model.Sprite;
import operation.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Game implements Observer{
    public static Game instance;
    private Map map;
    private Bomb[] bomb;
    private Man player;
    private Boolean isReplay;
    private Main display;
    private int numBotDied;
    private ArrayList<Villain> bot;
    private Random random = new Random(System.currentTimeMillis());
    private Operation[] move = {new PlantBomb(), new MoveDown(), new MoveUp(), new MoveLeft(), new MoveRight()};
    private long replayStartTime;
    private long gameStartTime;
    private ArrayList<Sprite> sprites;

    private Game(Main display) {
        this.map = new Map(display);
        this.display = display;
        this.numBotDied = 0;
        this.isReplay = false;
        this.player = Man.getInstance();
        this.sprites = new ArrayList<>();
        this.player.addDisplay(display);
        this.bot = new ArrayList<>();
        this.bot.add(new Villain(13*64,11*64, display));
        this.bot.add(new Villain(13*64,1*64, display));
        this.bot.add(new Villain(1*64,11*64, display));
        this.bomb = new Bomb[bot.size() + 1];
        for (int i = 0; i < bot.size() + 1; i++) {
            this.bomb[i] = new Bomb(display);
            this.bomb[i].addObserver(player);
            this.bomb[i].addObserver(map);
            if (i < bot.size()) {
                this.bot.get(i).addBomb(this.bomb[i]);
            }
        }
        for (Villain v: bot) {
            this.bomb[this.bot.size()].addObserver(v);
            v.addObserver(this);
            sprites.add(v);
        }
        this.player.addBomb(bomb[this.bot.size()]);
        player.addObserver(this);
        this.sprites.add(player);
        gameStartTime = System.currentTimeMillis();
    }

    public static Game getInstance(Main display) {
        if(instance == null) {
            instance = new Game(display);
        }
        return instance;
    }

    public void repaint() {
        for (Sprite s : sprites) {
            if (s.isAlive()) {
                s.render();
            }
        }
        if (isReplay) {
            for (Sprite s : sprites) {
                actionReplay(s);
            }
        } else {
            for (Villain a : this.bot) {
                if (a.isAlive()) {
                    if (display.frameCount % 30 == 0) {
                        int o = random.nextInt(5);
                        addOperation(a, o);
                    }
                    a.render();
                }
            }
        }
        this.map.render();
    }

    public void addOperation(Sprite s, int o) {
        int[] step = move[o].getStep();

        try {
            if (o == 0 && !s.getBomb().isFire()) {
                move[0].execute(s);
                s.addReplay(move[o]);
                s.addTime(System.currentTimeMillis());
            } else if (s.isAlive() && map.getBlockList()[(s.getY() + 64 * step[1]) / 64][(s.getX() + 64 * step[0]) / 64] == null
                    && checkWalk(s, step)) {
                move[o].execute(s);
                s.addReplay(move[o]);
                s.addTime(System.currentTimeMillis());
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    private boolean checkWalk(Sprite s, int[] step) {
        int sX = s.getX();
        int sY = s.getY();
        int count = 0;
        for (Bomb b : bomb) {
            int bombX = b.getX();
            int bombY = b.getY();
            if ((sX + 64 * step[0]) != bombX || (sY + 64 * step[1]) != bombY) {
                count++;
            }
        }
        if (count == bomb.length) {
            return true;
        }
        return false;
    }

    public Man getPlayer() {
        return player;
    }


    @Override
    public void update(Observable o, Object arg) {
        if (!isReplay) {
            if ((int) arg == 0) {
                System.out.println("Replay Start");
                replay();
            } else {
                numBotDied++;
                if (numBotDied == bot.size()) {
                    System.out.println("Replay Start");
                    replay();
                }
            }
        }
    }

    public void replay() {
        isReplay = true;
        for(Sprite s : sprites) {
            s.reset();
        }
        map.readMaze();
        for (int i = 0; i < bomb.length; i++) {
            bomb[i].reset();
        }
        replayStartTime = System.currentTimeMillis();
    }

    public Boolean getReplay() {
        return isReplay;
    }

    public void actionReplay(Sprite s) {
        try {
            if (System.currentTimeMillis() - replayStartTime  >= s.getFlashPoint().get(0) - gameStartTime) {
                s.getReplay().get(0).execute(s);
                s.getReplay().remove(0);
                s.getFlashPoint().remove(0);
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }
}
