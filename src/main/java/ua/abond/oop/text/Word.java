package ua.abond.oop.text;

import java.util.Objects;

public class Word {
    private final String text;

    public Word(String text) {
        Objects.requireNonNull(text);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Word))
            return false;

        Word word1 = (Word) o;

        return getText() != null ? getText().equals(word1.getText()) : word1.getText() == null;

    }

    @Override
    public int hashCode() {
        return getText() != null ? getText().hashCode() : 0;
    }
}
