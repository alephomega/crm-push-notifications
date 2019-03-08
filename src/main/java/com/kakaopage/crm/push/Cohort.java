package com.kakaopage.crm.push;

public class Cohort {
    private final String bucket;
    private final String key;
    private final String pattern;

    public Cohort(String bucket, String key, String pattern) {
        this.bucket = bucket;
        this.key = key;
        this.pattern = pattern;
    }

    public String getBucket() {
        return bucket;
    }

    public String getKey() {
        return key;
    }

    public String getPattern() {
        return pattern;
    }
}
