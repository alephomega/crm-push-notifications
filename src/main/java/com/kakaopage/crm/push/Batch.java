package com.kakaopage.crm.push;

import java.util.List;

public class Batch {

    private final Configuration config;

    public Batch(Configuration config) {
        this.config = config;
    }

    void run() {
        before();

        int iteration = 0;
        while (true) {
            Context context = iterationContext(config);
            List<Job> jobs = jobs(context);
            if (jobs.isEmpty()) {
                break;
            }

            MiniBatch.of(config, ++iteration, jobs).run(config.getConcurrency());
        }

        after();
    }

    private Context iterationContext(Configuration config) {
        return null;
    }

    private List<Job> jobs(Context context) {
        return null;
    }

    private void before() {

    }

    private void after() {

    }
}