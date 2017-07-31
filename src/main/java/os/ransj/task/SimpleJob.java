package os.ransj.task;

/**
 * Created by ranshengju on 04/07/2017.
 */

public abstract class SimpleJob extends Job {

    @Override
    public Object execute(Object[] params) {
        execute();
        return null;
    }

    public abstract void execute();
}
