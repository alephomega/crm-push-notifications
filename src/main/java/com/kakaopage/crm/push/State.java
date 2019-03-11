package com.kakaopage.crm.push;

import java.util.Optional;

enum State {
    PENDING(0),
    PARTITIONING(1),
    PARTITIONING_COMPLETED(2),
    MESSAGING(3),
    COMPLETED(4);

    private final int progress;

    State(int progress) {
        this.progress = progress;
    }

    boolean isStarted() {
        return progress > PENDING.progress;
    }

    boolean isRunning() {
        return progress > PENDING.progress && progress < COMPLETED.progress;
    }

    boolean isCompleted() {
        return this == COMPLETED;
    }

    boolean before(State state) {
        return progress < state.progress;
    }

    boolean after(State state) {
        return progress > state.progress;
    }

    static Optional<State> next(State state) {
        int progress = state.progress;
        return Optional.ofNullable(State.of(progress + 1));
    }

    private static State of(int progress) {
        switch (progress) {
            case 0: return PENDING;
            case 1: return PARTITIONING;
            case 2: return PARTITIONING_COMPLETED;
            case 3: return MESSAGING;
            case 4: return COMPLETED;
            default: return null;
        }
    }
}