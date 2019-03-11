package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
class Messaging {
    private final Job job;
    private final List<Progress> progresses;

    Messaging(Job job, List<Partition> partitions) {
        this.job = job;
        this.progresses = partitions.stream().map(Progress::new).collect(Collectors.toList());
    }

    static Messaging of(Job job, Context context) {
        return null;
    }

    List<Split> batch(int size) {
        return progresses.stream().map(progress -> progress.next(size)).collect(Collectors.toList());
    }


    @Getter
    @EqualsAndHashCode(exclude = { "checkpoint" })
    @ToString
    private class Progress {
        private final Partition partition;
        private long checkpoint;

        Progress(Partition partition) {
            this.partition = partition;
            this.checkpoint = -1;
        }

        Split next(int size) {
            return new Split(job.getMetadata(), partition, checkpoint + 1, size);
        }
    }
}