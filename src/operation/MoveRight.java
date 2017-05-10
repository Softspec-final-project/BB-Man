package operation;

import model.Operation;

public class MoveRight implements Operation {
    private int[] step = {1, 0};

    @Override
    public int[] getStep() {
        return step;
    }

    @Override
    public void execute() {
        man.move(4, v, 0);
    }
}
