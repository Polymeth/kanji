package com.kanji.lexer;

import com.kanji.source.Source;
import com.kanji.token.Token;
import com.kanji.token.TokenType;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final static String END_OF_FILE = "EoF";
    private final static String END_OF_LINE = "";
    private final static String DELIMITER = " ";

    private final String content;
    public List<Token> tokens = new ArrayList<>();
    public Lexer(String str) {
        this.content = str;
        tokens = lex(content);
    }

    private List<Token> lex (String str) {
        List<Token> tokens = new ArrayList<>();
        Source source = new Source(str);
        while (!source.chars().equals("EoF")){
            if (source.chars().matches("[a-zA-Z]")) {
                tokens.add(scanString(source));
            } else if (source.chars().matches("[.0-9]")) {
                tokens.add(new Token(TokenType.Number, source.chars()));
                source.nextChar();
            } else if (source.chars().matches("[=\\/\\(\\)\\'\\+\\-]")) {
                tokens.add(new Token(TokenType.Operator, source.chars()));
                source.nextChar();
            } else if (source.chars().equals(";")) {
                tokens.add(new Token(TokenType.EOL, source.chars()));
                source.nextChar();
            } else if (source.chars().equals(":")) {
                tokens.add(new Token(TokenType.EOL, source.chars()));
                source.nextChar();
            } else {
                source.nextChar();
            }
        }
        return tokens;
    }

    private Token scanString(Source source){
        String str = "";
        while (source.chars().matches("[a-zA-Z]") && source.chars() != END_OF_FILE && source.chars() != END_OF_LINE && source.chars() != DELIMITER) {
            str+= source.chars();
            source.nextChar();
        }
        return (new Token(TokenType.String, str));
    }
}
