package com.wx.po;

public class Keyword {
    private String word;

    public Keyword() {
    }

    public Keyword(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "word='" + word + '\'' +
                '}';
    }
}
