package game;

import model.Block;
import model.Component;

import java.util.Observable;
import java.util.Observer;

public class Map implements Component, Observer {

    private Block[][] blockList;
    private int[][] maze;
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

    public Map() {
        this.maze = DEFAULT_FIELD;
        this.blockList = new Block[11][13];
        readMaze();
    }

    public Map(int[][] maze) {
        this.maze = maze;
        this.blockList = new Block[11][13];
        readMaze();
    }

    private void readMaze() {
        blockList = null;
        for(int i = 0 ; i < 11 ; i++) {
            for(int j = 0 ; j < 13 ; j++) {
                switch (maze[i][j]){
                    case 0:
                        blockList[i][j] = null;
                        break;
                    case 1:
                        blockList[i][j] = new BlickBlock();
                        break;
                    default:
                        blockList[i][j] = new MetalBlock();
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

    }
}
