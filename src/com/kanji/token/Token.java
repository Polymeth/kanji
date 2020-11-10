package com.kanji.token;

public class Token {
    TokenType type;
    String str;
    public Token(TokenType type, String str) {
        this.type = type;
        this.str = str;
    }
}
