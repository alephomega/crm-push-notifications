package com.kakaopage.crm.push;

interface MiniBatchListener {
    default void before() { }
    default void completed() { }
    default void failed(Exception e) { }
}
