package operation;

import model.Operation;

public class MoveRight implements Operation {

    @Override
    public void execute() {
        man.move(4, v, 0);
    }
}
