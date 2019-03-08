package com.kakaopage.crm.push;

import java.util.Collections;
import java.util.List;

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

    void setToken(Token token) {
        this.token = token;
    }

    Token getToken() {
        return token;
    }

    boolean isRunning() {
        return token != null;
    }
}
