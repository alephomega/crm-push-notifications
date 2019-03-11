package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode(exclude = { "iteration" })
@ToString
class MiniBatch {
    private final int iteration;
    private final List<Task> tasks;

    private MiniBatch(int iteration, List<Task> tasks) {
        this.iteration = iteration;
        this.tasks = tasks;
    }

    static MiniBatch of(Context context, int iteration, List<Job> jobs) {
        Configuration config = context.getConfig();
        SplitPartitioner partitioner = new SplitPartitioner();
        jobs.stream().filter(job -> job.getState().after(State.PARTITIONING))
                .map(job -> Messaging.of(job, context).batch(config.getSplitSize()))
                .forEach(partitioner);

        return new MiniBatch(iteration, partitioner.partitions.stream().map(Task::new).collect(Collectors.toList()));
    }

    void run(int concurrency) {
        before();

        TaskRunner runner = new TaskRunner(concurrency);
        tasks.forEach(runner::run);

        while(true) {

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
