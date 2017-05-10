package operation;

import model.Operation;

public class MoveUp implements Operation {

    @Override
    public void execute() {
        man.move(1, 0, v);
    }
}
