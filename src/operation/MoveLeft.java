package operation;

import model.Operation;

public class MoveLeft implements Operation {

    @Override
    public void execute() {
        man.move(3, -v, 0);
    }
}
