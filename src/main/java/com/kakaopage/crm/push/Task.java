package com.kakaopage.crm.push;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
class Task {
    private Token token;
    private List<Split> splits;

    Task(List<Split> splits) {
        this.splits = splits;
    }

    void run(Token token) {
        setToken(token);
        Collections.shuffle(splits);

        before();

        after();

    }

    private void before() {

    }

    private void after() {

    }

    private void setToken(Token token) {
        this.token = token;
    }

    boolean isRunning() {
        return token != null;
    }
}
