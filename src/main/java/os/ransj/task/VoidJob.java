package os.ransj.task;

/**
 * Created by ranshengju on 25/06/2017.
 */

public abstract class VoidJob<P> extends Job<P, Void> {

    @Override
    public Void execute(P... params) {
        executeVoid(params);
        return null;
    }

    public abstract void executeVoid(P... params);
}