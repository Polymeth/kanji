package com.kanji;

import com.kanji.lexer.Lexer;

public class Main {

    public static void main(String[] args) {
	    Lexer lexer = new Lexer("print('lol')");

	    for (int i = 0; i < lexer.tokens.size(); i++) {
	        System.out.println("[" + lexer.tokens.get(i).type + ", " + lexer.tokens.get(i).str + "]");
        }
    }
}
