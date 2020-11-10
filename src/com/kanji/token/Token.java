package com.kanji.token;

public class Token {
    public TokenType type;
    public String str;
    public Token(TokenType type, String str) {
        this.type = type;
        this.str = str;
    }
}
