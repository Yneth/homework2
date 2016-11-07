package ua.abond.oop.text;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sentence {
    private final List<Word> words;

    public Sentence(List<Word> words) {
        Objects.requireNonNull(words);
        this.words = words;
    }

    public List<Word> getWords() {
        return Collections.unmodifiableList(words);
    }

    @Override
    public String toString() {
        return words.stream().map(Word::toString).collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Sentence))
            return false;

        Sentence sentence = (Sentence) o;

        return getWords() != null ? getWords().equals(sentence.getWords()) : sentence.getWords() == null;

    }

    @Override
    public int hashCode() {
        return getWords() != null ? getWords().hashCode() : 0;
    }
}
