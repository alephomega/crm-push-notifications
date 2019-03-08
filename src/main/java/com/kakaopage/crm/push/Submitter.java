package com.kakaopage.crm.push;

import com.amazonaws.services.batch.AWSBatch;
import com.amazonaws.services.batch.AWSBatchClientBuilder;
import com.amazonaws.services.batch.model.SubmitJobRequest;
import com.amazonaws.services.batch.model.SubmitJobResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Submitter {
    private static final Gson GSON = new GsonBuilder().create();
    static void submit(Task task) {
        String description = GSON.toJson(task);

        AWSBatch client = AWSBatchClientBuilder.standard().build();
        SubmitJobRequest request = new SubmitJobRequest();
        SubmitJobResult result = client.submitJob(request);
    }
}
