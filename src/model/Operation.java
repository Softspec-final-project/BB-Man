package model;


import game.Man;

public abstract class Operation {
    protected int v = 64;
    protected Man man = Man.getInstance();
    public int[] getStep(){return new int[0];}
    public void execute(){}
}
