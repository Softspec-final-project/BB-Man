package operation;

import model.Operation;

public class MoveLeft extends Operation {
    private int[] step = {-1, 0};

    @Override
    public int[] getStep() {
        return step;
    }

    @Override
    public void execute() {
        man.move(3, -v, 0);
    }
}
