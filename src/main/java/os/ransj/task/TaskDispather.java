package os.ransj.task;

/**
 * Created by ranshengju on 18/06/2017.
 */

public final class TaskDispather {

    /**
     * create a new task
     * @return
     */
    public static TaskBuilder newTask() {
        return new InnerTaskBuilder();
    }

}