package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    List<Sentence> sentences = new ArrayList<>();

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
}
