package game;

import model.Block;
import model.Component;
import runHere.Main;

import java.util.Observable;
import java.util.Observer;

public class Map implements Component, Observer {

    private Block[][] blockList;
    private int[][] maze;
    private Main display;
    private final int[][] DEFAULT_FIELD =  {{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
                                            {8,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
                                            {8,0,8,0,8,0,8,0,8,0,8,0,8,0,8},
                                            {8,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
                                            {8,0,8,0,8,0,8,0,8,0,8,0,8,0,8},
                                            {8,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
                                            {8,0,8,0,8,0,8,0,8,0,8,0,8,0,8},
                                            {8,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
                                            {8,0,8,0,8,0,8,0,8,0,8,0,8,0,8},
                                            {8,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
                                            {8,0,8,0,8,0,8,0,8,0,8,0,8,0,8},
                                            {8,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
                                            {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}};

    public Map(Main display) {
        this.maze = DEFAULT_FIELD;
        this.display = display;
        readMaze();
    }

    public Map(int[][] maze, Main display) {
        this.maze = maze;
        this.display = display;
        this.blockList = new Block[13][15];
        readMaze();
    }

    private void readMaze() {
        blockList = new Block[13][15];
        for(int i = 0, y = 0 ; i < 13 ; i++, y += 64) {
            for(int j = 0, x = 0 ; j < 15 ; j++, x += 64) {
                switch (maze[i][j]){
                    case 0:
                        blockList[i][j] = null;
                        break;
                    case 1:
                        blockList[i][j] = new BlickBlock(x, y, this.display);
                        break;
                    default:
                        blockList[i][j] = new MetalBlock(x ,y, this.display);
                }
            }
        }
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
        readMaze();
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO destroy box
    }

    @Override
    public void render() {
        for(Block[] a : blockList) {
            for(Block b : a) {
                if(b != null) {
                    b.render();
                }
            }
        }
    }
}
