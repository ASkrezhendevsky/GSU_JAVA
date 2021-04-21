package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    List<Word> words = new ArrayList<>();

    public Sentence(String text) {
        String[] strings = text.split("\\s");
        for (String string: strings) {
            words.add(new Word(string));
        }
    }

    public List<Word> getWords() {
        return new ArrayList<>(words);
    }

    public void setWords(List<Word> words) {
        this.words = new ArrayList<>(words);
    }
}
