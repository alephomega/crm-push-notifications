package com.kakaopage.crm.push;

abstract class EventHandler<T extends Event> {

    abstract void handle(T event);
}