package com.kakaopage.crm.push;

import com.amazonaws.services.glue.AWSGlue;
import com.amazonaws.services.glue.model.GetJobRunRequest;

public class Glue {
    private final AWSGlue client;

    public Glue(AWSGlue client) {
        this.client = client;
    }

    public void run() {
        GetJobRunRequest request = null;
        client.getJobRun(request);
    }
}
