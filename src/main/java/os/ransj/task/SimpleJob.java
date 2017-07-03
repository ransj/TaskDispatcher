package os.ransj.task;

/**
 * Created by ranshengju on 04/07/2017.
 */

public abstract class SimpleJob extends Job<Void, Void> {
    @Override
    public Void execute(Void... params) {
        return null;
    }

    public abstract void execute();
}
