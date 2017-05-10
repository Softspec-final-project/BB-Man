package model;


import game.Man;

public abstract class Operation {
    protected int v = 64;
    public int[] getStep(){return new int[0];}
    public void execute(Sprite s){}
}
