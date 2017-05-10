package operation;

import model.Operation;
import model.Sprite;

public class MoveDown extends Operation {
    private int[] step = {0, -1};

    @Override
    public int[] getStep() {
        return step;
    }

    @Override
    public void execute(Sprite s) {
        s.move(2, 0, -v);
    }
}
