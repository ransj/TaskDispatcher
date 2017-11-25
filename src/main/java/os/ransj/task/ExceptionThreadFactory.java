package os.ransj.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by ranshengju on 2017/11/25.
 */

final class ExceptionThreadFactory implements ThreadFactory {
    static Thread.UncaughtExceptionHandler mExceptionHandler = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
        }
    };

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = Executors.defaultThreadFactory().newThread(r);
        thread.setUncaughtExceptionHandler(mExceptionHandler);
        return thread;
    }

}
