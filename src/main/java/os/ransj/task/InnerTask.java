package os.ransj.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ranshengju on 18/06/2017.
 */

final class InnerTask implements Task, Runnable {
    static ScheduledExecutorService mScheduleExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    static ExecutorService mQueueExecutor = Executors.newSingleThreadExecutor();
    boolean mIsCanceled;
    List<Job> mJobs = new ArrayList<>();
    Job mJob;
    Object mLastResult;

    public void addJob(Job job) {
        mJobs.add(job);
    }

    @Override
    public void dispatch() {
        nextJob();
        if(mJob != null){
            long delay = mJob.mDelay;
            mJob.delay(-1);
            dispatchJob(delay);
        }
    }

    @Override
    public void cancel() {
        mIsCanceled = true;
    }

    @Override
    public void run() {
        boolean done = mIsCanceled || mJob == null;
        while (!done) {
            TaskExecutor executor = mJob.mExecutor;
            if (mLastResult == null) {
                mLastResult = mJob.execute();
            } else {
                mLastResult = mJob.execute(mLastResult);
            }
            mJob.mIsDone = true;
            nextJob();
            done = mIsCanceled || mJob == null;
            if (!done) {
                TaskExecutor nextExecutor = mJob.mExecutor;
                long delay = mJob.mDelay;
                mJob.delay(-1);
                if (nextExecutor.equals(executor) && delay <= 0) {
                    // continue
                } else {
                    done = true;
                    dispatchJob(delay);
                }
            }
        }
    }

    void nextJob() {
        if (mJob == null || mJob.mIsDone) {
            if (mJobs.isEmpty()) {
                mJob = null;
            } else {
                mJob = mJobs.remove(0);
            }
        }
    }

    void dispatchJob(long delay) {
        TaskExecutor executor = mJob.mExecutor;
        if (delay > 0) {
            if (TaskExecutor.pool.equals(executor)) {
                mScheduleExecutor.schedule(this, delay, TimeUnit.MILLISECONDS);
            } else if (TaskExecutor.queue.equals(executor)) {
                mQueueExecutor.execute(new DelayInnerTask(this, delay));
            }
        } else {
            if (TaskExecutor.pool.equals(executor)) {
                mScheduleExecutor.execute(this);
            } else if (TaskExecutor.queue.equals(executor)) {
                mQueueExecutor.execute(this);
            }
        }
    }
}