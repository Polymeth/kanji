package com.kanji.source;

public class Source {
    String source;
    int index;
    public Source(String str) {
        this.source = str;
        index = 0;
    }

    public String chars() {
        if (index > source.length() - 1) {
            return "EoF";
        } else {
            return String.valueOf(source.charAt(index));
        }
    }

    public void nextChar() {
        index++;
    }
}
