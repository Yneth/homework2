package ua.abond.oop.text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Text {
    private String header;
    private final List<Sentence> sentences;

    public Text(String header, List<Sentence> sentences) {
        Objects.requireNonNull(header, "Header cannot be null");
        Objects.requireNonNull(sentences, "Sentences cannot be null");

        this.header = header;
        this.sentences = sentences;
    }

    public void print() {
        System.out.print(toString());
    }

    public void appendSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void prependSentence(Sentence sentence) {
        sentences.add(0, sentence);
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public List<Sentence> getSentences() {
        return Collections.unmodifiableList(sentences);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(header).append("\n");
        result.append(sentences.stream().map(Sentence::toString).collect(Collectors.joining(". ")));
        return result.toString();
    }

    public static Text fromString(String header, String text) {
        String[] sentenceArray = text.trim().split("\\.");
        List<Sentence> sentences = Arrays.stream(sentenceArray)
                .map(s -> Arrays.stream(s.trim().split(" ")).map(Word::new).collect(Collectors.toList()))
                .map(Sentence::new)
                .collect(Collectors.toList());
        return new Text(header, sentences);
    }
}
