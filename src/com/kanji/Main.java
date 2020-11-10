package com.kanji;

import com.kanji.lexer.Lexer;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String str = readStringFromFile("samples/helloworld.kj");
	    Lexer lexer = new Lexer(str);

	    for (int i = 0; i < lexer.tokens.size(); i++) {
	        System.out.println("[" + lexer.tokens.get(i).type + ", " + lexer.tokens.get(i).str + "]");
        }
    }

    // TODO: move this shit to some helper class
    public static String readStringFromFile(String fileName) {
        String string= "";
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String temp;
            boolean checkFirst = false;
            while((temp = br.readLine())!= null) {
                if(checkFirst) {
                    string += (" " + temp);
                }else {
                    string += temp;
                    checkFirst = true;
                }
            }
            br.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return string;

    }
}
