package os.ransj.task;

/**
 * Created by ranshengju on 18/06/2017.
 */

public abstract class Job<P, T> {
    boolean mIsDone = false;
    long mDelay = 0;
    TaskExecutor mExecutor = TaskExecutor.pool;

    /**
     *
     * @param executor
     * @return
     */
    public Job on(TaskExecutor executor){
        mExecutor = executor;
        return this;
    }

    /**
     * delay some time to execute
     *
     * @param delay
     */
    void delay(long delay) {
        mDelay = delay;
    }

    /**
     * 执行任务
     * @param params
     * @return
     */
    public abstract T execute(P... params);


}