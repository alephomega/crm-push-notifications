package com.kakaopage.crm.push;

interface BatchListener {
    default void before() { }
    default void completed() { }
    default void failed(Exception e) { }
}
