package com.kakaopage.crm.push;

public class Configuration {
    private int concurrency;
    private int partitions;
    private int splitSize;

    public int getSplitSize() {
        return splitSize;
    }

    public int getConcurrency() {
        return concurrency;
    }

    public int getPartitions() {
        return partitions;
    }
}
