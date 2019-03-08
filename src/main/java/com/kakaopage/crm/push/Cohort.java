package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
class Cohort {
    private final String bucket;
    private final String key;
    private final String pattern;

    public Cohort(String bucket, String key, String pattern) {
        this.bucket = bucket;
        this.key = key;
        this.pattern = pattern;
    }
}
