package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public class Batch {
    private final Configuration config;
    private final List<BatchListener> listeners;
    private final MetadataProvider metadataProvider;

    public Batch(Configuration config, List<BatchListener> listeners, MetadataProvider metadataProvider) {
        this.config = config;
        this.listeners = listeners;
        this.metadataProvider = metadataProvider;
    }

    void run() {
        before();

        int iteration = 0;
        try {
            while (true) {
                Context context = iterationContext(config);
                List<Job> jobs = runningJobs(context);
                if (jobs.isEmpty()) {
                    break;
                }

                MiniBatch.of(context, ++iteration, jobs).run(config.getConcurrency());
            }

            completed();
        } catch (Exception e) {
            failed(e);
        }
    }

    private Context iterationContext(Configuration config) {
        return null;
    }

    private List<Job> runningJobs(Context context) {
        return metadataProvider.runningJobs();
    }

    private void before() {
        listeners.forEach(BatchListener::before);
    }

    private void completed() {
        listeners.forEach(BatchListener::completed);
    }

    private void failed(Exception e) {
        listeners.forEach(listener -> listener.failed(e));
    }

    @EqualsAndHashCode
    @ToString
    private static class Partitioning implements Runnable {
        private final Job job;

        private Partitioning(Job job) {
            this.job = job;
        }

        @Override
        public void run() {
            job.setState(State.PARTITIONING);
            Job.Metadata metadata = job.getMetadata();

            submit(metadata);
        }

        private void submit(Job.Metadata metadata) {

        }
    }
}