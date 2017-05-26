package game;

import model.Block;
import model.Component;
import runHere.Main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Map implements Component, Observer {

    private Block[][] blockList;
    private ArrayList<BrickBlock> bricks;
    private int[][] maze;
    private Main display;
    private final int[][] DEFAULT_FIELD =  {{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
                                            {8,0,0,0,1,1,1,1,1,1,1,0,0,0,8},
                                            {8,0,8,1,8,0,8,1,8,0,8,1,8,0,8},
                                            {8,0,1,1,1,1,1,1,1,1,1,1,1,0,8},
                                            {8,1,8,1,8,1,8,1,8,1,8,1,8,1,8},
                                            {8,1,0,1,1,1,1,1,1,1,0,1,1,1,8},
                                            {8,1,8,1,8,1,8,1,8,1,8,1,8,1,8},
                                            {8,1,0,1,1,1,1,1,1,1,0,1,1,1,8},
                                            {8,1,8,1,8,1,8,1,8,1,8,1,8,1,8},
                                            {8,0,1,1,1,1,1,1,1,1,1,1,1,0,8},
                                            {8,0,8,1,8,0,8,1,8,0,8,1,8,0,8},
                                            {8,0,0,0,1,1,1,1,1,1,1,0,0,0,8},
                                            {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}};

    public Map(Main display) {
        this.maze = DEFAULT_FIELD;
        this.display = display;
        this.bricks = new ArrayList<>();
        readMaze();
    }

    public Map(int[][] maze, Main display) {
        this.maze = maze;
        this.display = display;
        this.blockList = new Block[13][15];
        this.bricks = new ArrayList<>();
        readMaze();
    }

    public void readMaze() {
        blockList = new Block[13][15];
        for(int i = 0 ; i < 13 ; i++) {
            for(int j = 0 ; j < 15 ; j++) {
                switch (maze[i][j]){
                    case 0:
                        blockList[i][j] = null;
                        break;
                    case 1:
                        BrickBlock brick = new BrickBlock(j*64, i*64, this.display);
                        blockList[i][j] = brick;
                        bricks.add(brick);
                        break;
                    case 8:
                        blockList[i][j] = new MetalBlock(j*64 ,i*64, this.display);
                        break;
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
        Coordinates cs = Coordinates.getInstance();
        for (int i = 0; i < cs.getXs().size(); i++) {
            for (int j = 0; j < bricks.size(); j++) {
                if (bricks.get(j).getX() == cs.getXs().get(i) && bricks.get(j).getY() == cs.getYs().get(i)) {
                    blockList[bricks.get(j).getY()/64][bricks.get(j).getX()/64] = null;
                    bricks.remove(j);
                }
            }
        }
    }

    public Block[][] getBlockList() {
        return blockList;
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
