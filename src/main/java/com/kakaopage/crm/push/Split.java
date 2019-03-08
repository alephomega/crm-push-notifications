package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
class Split {
    private final Job.Metadata metadata;
    private final Partition partition;
    private final long offset;
    private final int length;

    Split(Job.Metadata metadata, Partition partition, long offset, int length) {
        this.metadata = metadata;
        this.partition = partition;
        this.offset = offset;
        this.length = length;
    }
}
