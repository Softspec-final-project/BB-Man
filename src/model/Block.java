package model;

public abstract class Block {
    public boolean isValid;
    public boolean isDestroyable;
    public final int BLOCK_WIDTH = 64;
    public final int BLOCK_HIGHT = 64;
    public int x;
    public int y;

    public void destroyBlock() {}
    public void render(){}
}
