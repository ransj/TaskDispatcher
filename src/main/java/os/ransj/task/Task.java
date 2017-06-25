package os.ransj.task;

/**
 * Created by ranshengju on 18/06/2017.
 */

public interface Task {

    /**
     * dispatch a task
     */
    void dispatch();

    /**
     * cancel task
     */
    void cancel();

}