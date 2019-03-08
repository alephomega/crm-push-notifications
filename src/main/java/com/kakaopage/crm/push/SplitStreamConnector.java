package com.kakaopage.crm.push;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;

import java.io.InputStream;

public class SplitStreamConnector {

    private final AmazonS3 s3;

    public SplitStreamConnector(AmazonS3 s3) {
        this.s3 = s3;
    }

    public InputStream connect(Split split) {
        Partition partition = split.getPartition();

        GetObjectRequest request = new GetObjectRequest(partition.getBucket(), partition.getKey());

        long offset = split.getOffset();
        request.setRange(offset);

        return s3.getObject(request).getObjectContent();
    }
}
