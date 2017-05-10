package operation;

import model.Operation;

public class MoveDown implements Operation {

    @Override
    public void execute() {
        man.move(2, 0, -v);
    }
}
