package operation;

import model.Operation;

public class Move implements Operation {
    public boolean moveUp() {
        return true;
    }
    public boolean moveDown() {
        return true;
    }
    public boolean moveLeft() {
        return true;
    }
    public boolean moveRight() {
        return true;
    }

    @Override
    public void execute() {

    }
}
