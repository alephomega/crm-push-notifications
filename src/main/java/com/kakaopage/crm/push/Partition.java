package com.kakaopage.crm.push;

import java.util.Arrays;

class Partition {
    private final int id;
    private final String bucket;
    private final String key;

    Partition(int id, String bucket, String key) {
        this.id = id;
        this.bucket = bucket;
        this.key = key;
    }

    int getId() {
        return id;
    }

    String getBucket() {
        return bucket;
    }

    String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Partition) {
            return id == ((Partition) obj).getId() && bucket.equals(((Partition) obj).getBucket()) && key.equals(((Partition) obj).getKey());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new String[] { String.valueOf(id), bucket, key });
    }
}
