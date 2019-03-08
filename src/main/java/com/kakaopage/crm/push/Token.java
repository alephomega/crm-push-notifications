package com.kakaopage.crm.push;

public class Token {

    private final int id;

    public Token(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Token) {
            return id == ((Token) obj).id;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}