package com.kakaopage.crm.push;

import java.util.List;
import java.util.stream.Collectors;

class Job {
    private final Metadata metadata;
    private final List<Progress> progresses;

    Job(Metadata metadata, List<Partition> partitions) {
        this.metadata = metadata;
        this.progresses = partitions.stream().map(Progress::new).collect(Collectors.toList());
    }

    List<Split> batch(int size) {
        return progresses.stream().map(progress -> progress.next(size)).collect(Collectors.toList());
    }

    Metadata getMetadata() {
        return metadata;
    }

    static class Metadata {
        private final String id;
        private final Cohort cohort;

        Metadata(String id, Cohort cohort) {
            this.id = id;
            this.cohort = cohort;
        }
    }

    private class Progress {
        private final Partition partition;
        private long checkpoint;

        Progress(Partition partition) {
            this.partition = partition;
            this.checkpoint = -1;
        }

        Split next(int size) {
            return new Split(getMetadata(), partition, checkpoint + 1, size);
        }
    }
}