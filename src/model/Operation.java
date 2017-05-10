package model;


import game.Man;

public interface Operation {
    int v = 64;
    public Man man = Man.getInstance();
    public void execute();
}
