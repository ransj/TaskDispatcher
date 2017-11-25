package os.ransj.task;

/**
 * Created by ranshengju on 04/07/2017.
 */

public abstract class SimpleJob extends Job {

    public SimpleJob() {

    }

    public SimpleJob(TaskExecutor executor) {
        on(executor);
    }

    @Override
    public Object execute(Object[] params) {
        execute();
        return null;
    }

    public abstract void execute();
}
