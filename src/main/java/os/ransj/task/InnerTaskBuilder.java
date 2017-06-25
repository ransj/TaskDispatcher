package os.ransj.task;

/**
 * Created by ranshengju on 18/06/2017.
 */

final class InnerTaskBuilder implements TaskBuilder {
    InnerTask mTask = new InnerTask();

    @Override
    public TaskBuilder execute(Job job) {
        mTask.addJob(job);
        return this;
    }

    @Override
    public TaskBuilder execute(Job job, long delay) {
        job.delay(delay);
        mTask.addJob(job);
        return this;
    }

    @Override
    public TaskBuilder then(Job job) {
        mTask.addJob(job);
        return this;
    }

    @Override
    public TaskBuilder then(Job job, long delay) {
        job.delay(delay);
        mTask.addJob(job);
        return this;
    }

    @Override
    public Task end() {
        return mTask;
    }
}