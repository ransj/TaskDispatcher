package os.ransj.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by ranshengju on 18/06/2017.
 */

public final class TaskDispather {
    static ExceptionThreadFactory mThreadFactory = new ExceptionThreadFactory();
    static ScheduledExecutorService mScheduleExecutor = Executors.newScheduledThreadPool(Math.max(Runtime.getRuntime().availableProcessors(), 4), mThreadFactory);
    static ExecutorService mQueueExecutor = Executors.newSingleThreadExecutor(mThreadFactory);

    /**
     * create a new task
     * @return
     */
    public static TaskBuilder newTask() {
        return new InnerTaskBuilder();
    }

    /**
     * 释放相关线程资源
     */
    public static void release() {
        mScheduleExecutor.shutdown();
        mQueueExecutor.shutdown();
    }

}