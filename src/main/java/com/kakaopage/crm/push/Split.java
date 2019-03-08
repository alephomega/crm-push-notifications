package com.kakaopage.crm.push;

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

    Partition getPartition() {
        return partition;
    }

    long getOffset() {
        return offset;
    }

    private int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Split) {
            return partition.equals(((Split) obj).getPartition()) && offset == ((Split) obj).getOffset() && length == ((Split) obj).getLength();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return 31*(31*(31 + partition.hashCode()) + Long.hashCode(offset)) + Integer.hashCode(length);
    }
}
