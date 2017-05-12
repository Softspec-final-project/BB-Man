package game;

import java.util.ArrayList;

public class Coordinates {

    private ArrayList<Integer> xs;
    private ArrayList<Integer> ys;
    private ArrayList<Integer> types;
    private static Coordinates instance;

    private Coordinates() {
        xs = new ArrayList<>();
        ys = new ArrayList<>();
        types = new ArrayList<>();
    }

    public static Coordinates getInstance() {
        if(instance == null) {
            instance = new Coordinates();
        }
        return instance;
    }

    public void addCoordinate(int t, int x, int y) {
        types.add(t);
        xs.add(x);
        ys.add(y);
    }

    public ArrayList<Integer> getXs() {
        return xs;
    }

    public ArrayList<Integer> getYs() {
        return ys;
    }

    public ArrayList<Integer> getTypes() {
        return types;
    }

    public void removeHead() {
        types.remove(0);
        xs.remove(0);
        ys.remove(0);
    }
}
