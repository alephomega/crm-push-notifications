package com.kakaopage.crm.push;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Configuration {
    private int concurrency;
    private int partitions;
    private int splitSize;
}
