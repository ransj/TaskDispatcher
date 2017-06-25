package os.ransj.task;

/**
 * Created by ranshengju on 18/06/2017.
 */

public interface TaskBuilder {

    /**
     * execute a job
     * @param job
     * @return
     */
    TaskBuilder execute(Job job);

    /**
     * delay some time, and execute a job
     * @param job
     * @param delay
     * @return
     */
    TaskBuilder execute(Job job, long delay);

    /**
     * execute a job in sequence
     * @param job
     * @return
     */
    TaskBuilder then(Job job);

    /**
     * execute a job with some delay time
     * @param job
     * @param delay
     * @return
     */
    TaskBuilder then(Job job, long delay);

    /**
     * 任务添加完毕
     * @return
     */
    Task end();
}