package operation;

import model.Operation;

public class MoveUp implements Operation {
    private int[] step = {0, 1};


    public int[] getStep() {
        return step;
    }

    @Override
    public void execute() {
        man.move(1, 0, v);
    }
}
