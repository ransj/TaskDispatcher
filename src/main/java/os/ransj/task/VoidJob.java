package os.ransj.task;

/**
 * Created by ranshengju on 25/06/2017.
 */

public abstract class VoidJob<P> extends Job<P, java.lang.Void> {

    @Override
    public java.lang.Void execute(P... params) {
        executeVoid(params);
        return null;
    }

    public abstract void executeVoid(P... params);

}