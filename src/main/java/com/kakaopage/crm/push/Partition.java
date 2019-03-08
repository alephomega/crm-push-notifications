package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
class Partition {
    private final int id;
    private final String bucket;
    private final String key;

    Partition(int id, String bucket, String key) {
        this.id = id;
        this.bucket = bucket;
        this.key = key;
    }
}