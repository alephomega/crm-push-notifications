package com.kakaopage.crm.push;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class MiniBatch {
    private final int iteration;
    private final List<Task> tasks;

    private MiniBatch(int iteration, List<Task> tasks) {
        this.iteration = iteration;
        this.tasks = tasks;
    }

    static MiniBatch of(Configuration config, int iteration, List<Job> jobs) {
        SplitPartitioner partitioner = new SplitPartitioner();
        jobs.stream().map(job -> job.batch(config.getSplitSize())).forEach(partitioner);

        return new MiniBatch(iteration, partitioner.partitions.stream().map(Task::new).collect(Collectors.toList()));
    }

    void run(int concurrency) {
        before();

        TaskRunner runner = new TaskRunner(concurrency);
        tasks.forEach(runner::run);

        while(true) {
            // check completion

            break;
        }

        after();
    }

    private void before() {

    }

    private void after() {

    }

    private static class SplitPartitioner implements Consumer<List<Split>> {
        private List<List<Split>> partitions = new ArrayList<>();

        @Override
        public void accept(List<Split> splits) {
            int i = 0;
            for (Split split : splits) {
                if (partitions.size() < i + 1) {
                    partitions.add(new ArrayList<>());
                }

                partitions.get(i).add(split);
                i++;
            }
        }
    }
}
