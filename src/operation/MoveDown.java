package operation;

import model.Operation;

public class MoveDown implements Operation {
    private int[] step = {0, -1};

    @Override
    public int[] getStep() {
        return step;
    }

    @Override
    public void execute() {
        man.move(2, 0, -v);
    }
}
