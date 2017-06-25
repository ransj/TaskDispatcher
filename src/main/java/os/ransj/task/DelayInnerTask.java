package os.ransj.task;

/**
 * Created by ranshengju on 18/06/2017.
 */

final class DelayInnerTask implements Runnable {
    Task mTask;
    long mStartTime;
    long mDelay;

    public DelayInnerTask(Task task, long delay) {
        mTask = task;
        mStartTime = System.currentTimeMillis();
        mDelay = delay;
    }

    @Override
    public void run() {
        for (; mStartTime + mDelay >= System.currentTimeMillis(); ) {
            Thread.yield();
        }
        mTask.dispatch();
    }


}
