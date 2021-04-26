package by.gsu.pms;

import java.util.Scanner;

public class Word {
    private String text;

    public Word(Scanner scanner){
        if (!scanner.hasNext()){
            throw new IllegalArgumentException("Scanner is empty");
        }
        setText(scanner.next());
    }

    public Word(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(text.matches(".*\\s.*")){
            throw new IllegalArgumentException("word must not contains space");
        }
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
