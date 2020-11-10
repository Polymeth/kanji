package com.kanji.lexer;

import com.kanji.source.Source;
import com.kanji.token.Token;
import com.kanji.token.TokenType;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String content;
    public Lexer(String str) {
        this.content = str;
        lex(content);
    }

    private List<Token> lex (String str) {
        List<Token> tokens = new ArrayList<>();
        Source source = new Source(str);
        while (source.chars() != "EoF"){
            if (source.chars().matches("[a-zA-Z]")) {
                tokens.add(new Token(TokenType.String, source.chars()));
                source.nextChar();
            }
        }
        return tokens;
    }
}
