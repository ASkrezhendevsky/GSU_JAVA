package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sentence {
    List<Word> words = new ArrayList<>();

    public Sentence(Scanner scanner){
        while (scanner.hasNext()){
            words.add(new Word(scanner));
            if(words.get(words.size()-1).getText().matches("\\S*\\.$")){
                break;
            }
        }
    }

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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Word word: words) {
            result.append(word.toString()).append(" ");
        }
        return result.toString();
    }
}
