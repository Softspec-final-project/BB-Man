package runHere;

import game.Bomb;
import game.Man;
import game.Map;
import game.Villain;
import model.Operation;
import operation.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game {
    public static Game instance;
    private Map map;
    private Bomb burn;
    private Man player;
    private Main display;
    private int[][] field;
    private ArrayList<Villain> bot;
    private ArrayList<Operation> replay;
    private Operation[] move = {new PlantBomb(), new MoveDown(), new MoveUp(), new MoveLeft(), new MoveRight()};

    private Game(Main display) {
        this.player = Man.getInstance();
        player.addDisplay(display);
        bot = new ArrayList<>();
        this.bot.add(new Villain(13*64,11*64, display));
        this.bot.add(new Villain(13*64,10*64, display));
        this.bot.add(new Villain(12*64,11*64, display));
        this.burn = new Bomb(0,0, display);
        this.map = new Map(display);
        this.display = display;
        replay = new ArrayList<>();
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
            a.render();
        }
//        this.burn.burnBabyBurn();
    }

    public void addOperation(int o) {
        move[o].execute();
        replay.add(move[o]);
    }
}
