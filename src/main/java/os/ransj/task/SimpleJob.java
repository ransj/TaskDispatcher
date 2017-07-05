package os.ransj.task;

/**
 * Created by ranshengju on 04/07/2017.
 */

public abstract class SimpleJob extends Job<java.lang.Void, java.lang.Void> {

    @Override
    public Void execute(Void[] params) {
        execute();
        return null;
    }

    public abstract void execute();
}
