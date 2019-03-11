package com.kakaopage.crm.push;

import lombok.Getter;

@Getter
class Context {
    private Configuration config;

    Context(Configuration config) {
        this.config = config;
    }
}