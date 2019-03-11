package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
class Job {
    private final Metadata metadata;
    private State state;

    Job(Metadata metadata, State state) {
        this.metadata = metadata;
        this.state = state;
    }

    void setState(State state) {
        this.state = state;
    }

    @Getter
    @EqualsAndHashCode
    @ToString
    static class Metadata {
        private final String id;
        private final Cohort cohort;

        Metadata(String id, Cohort cohort) {
            this.id = id;
            this.cohort = cohort;
        }
    }
}
