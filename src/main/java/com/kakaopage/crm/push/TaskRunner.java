package com.kakaopage.crm.push;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TaskRunner {
    private final BlockingQueue<Token> tokens;

    TaskRunner(int concurrency) {
        LinkedBlockingQueue<Token> tokens = new LinkedBlockingQueue<>(concurrency);
        for (int i = 0; i < concurrency; i++) {
            while (true) {
                try {
                    tokens.put(new Token(i));
                    break;
                } catch (InterruptedException ignore) { }
            }
        }

        this.tokens = tokens;
    }

    void run(Task task) {
        if (task.isRunning()) {
            throw new IllegalStateException();
        }

        task.run(getToken());
    }

    private Token getToken() {
        while (true) {
            try {
                return tokens.take();
            } catch (InterruptedException ignore) { }
        }
    }

    void release(Token token) {
        while (true) {
            try {
                tokens.put(token);
                return;
            } catch (InterruptedException ignore) { }
        }
    }
}