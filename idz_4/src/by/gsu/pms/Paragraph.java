package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paragraph {
    List<Sentence> sentences = new ArrayList<>();

    public  Paragraph(Scanner scanner){
        while (scanner.hasNext()){
            sentences.add(new Sentence(scanner));
        }
    }

    public Paragraph(String text) {
        String[] strings = text.split("\\.\\s");
        for (String string: strings) {
            sentences.add(new Sentence(string));
        }
    }

    public List<Sentence> getSentences() {
        return new ArrayList<>(sentences);
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = new ArrayList<>(sentences);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence: sentences) {
            result.append(sentence.toString());
        }
        return result.toString();
    }
}
