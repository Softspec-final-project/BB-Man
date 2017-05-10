package operation;

import model.Operation;
import model.Sprite;

public class MoveRight extends Operation {
    private int[] step = {1, 0};

    @Override
    public int[] getStep() {
        return step;
    }

    @Override
    public void execute(Sprite s) {
        s.move(4, v, 0);
    }
}
