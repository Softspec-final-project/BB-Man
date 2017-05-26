package game;

import model.Block;
import model.Component;
import runHere.Main;

import java.util.ArrayList;
import java.util.Observable;

public class Bomb extends Observable implements Component , Block {
    private int x;
    private int y;
    private int posX;
    private int posY;
    private Main display;
    private int timeStamp;
    private boolean isFire;
    private final int radius = 1;
    private ArrayList<Fire> fire;
    private Coordinates coordinates;
    private int type;

    public Bomb(Main display) {
        this.x = -64;
        this.y = -64;
        this.timeStamp = 0;
        this.isFire = false;
        this.display = display;
        this.fire = new ArrayList<>();
        this.coordinates = Coordinates.getInstance();
        for(int i = 0 ; i < (radius*4)+1 ; i++){
            fire.add(new Fire(display));
        }
        this.type = 1;
    }

    public void burnBabyBurn(int x, int y){
        this.x = x;
        this.y = y;
        this.isFire = true;
        this.timeStamp = display.millis();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isFire() {
        return isFire;
    }

    public void reset() {
        this.x = -64;
        this.y = -64;
        this.timeStamp = 0;
        this.isFire = false;
        for (Fire f : fire) {
            f.reset();
        }
        render();
    }

    @Override
    public void render() {
        if(display.millis() - this.timeStamp < 1500) {
            display.image(display.Bomb, this.x, this.y);
            posX = this.x;
            posY = this.y;

        } else if(isFire) {
            this.x = -64;
            this.y = -64;

            if(!fire.get(0).isFiring()) {

                fire.get(0).start(posX, posY);
                coordinates.addCoordinate(type, posX, posY);
                int runner = 1;
                for(int i = 1 ; i <= radius ; i++, runner++) {
                    fire.get(runner).start(posX+(64*i), posY);
                    coordinates.addCoordinate(type, posX+(64*i), posY);
                }

                for(int i = 1 ; i <= radius ; i++, runner++) {
                    fire.get(runner).start(posX-(64*i), posY);
                    coordinates.addCoordinate(type, posX-(64*i), posY);
                }

                for(int i = 1 ; i <= radius ; i++, runner++) {
                    fire.get(runner).start(posX, posY+(64*i));
                    coordinates.addCoordinate(type, posX, posY+(64*i));
                }

                for(int i = 1 ; i <= radius ; i++, runner++) {
                    fire.get(runner).start(posX, posY-(64*i));
                    coordinates.addCoordinate(type, posX, posY-(64*i));
                }
            }
            for(Fire f : fire) {
                f.render();
            }
            setChanged();
            notifyObservers();
            this.isFire = fire.get(0).isFiring();


        }
    }
}
