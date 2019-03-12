package com.kakaopage.crm.push;

import com.amazonaws.services.glue.AWSGlue;
import com.amazonaws.services.glue.model.StartJobRunRequest;
import com.amazonaws.services.glue.model.StartJobRunResult;

public class Glue {
    private final AWSGlue client;

    public Glue(AWSGlue client) {
        this.client = client;
    }

    public void run(String jobName, Configuration config) {
        StartJobRunRequest request = new StartJobRunRequest();
        StartJobRunResult result = client.startJobRun(request);
    }
}