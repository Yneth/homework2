package ua.abond.oop.text;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TextTest {

    @Test
    public void testCreateFromString() {
        String sentence0 = "Here we can see a lot of seamless text. ";
        String sentence1 = "Just writing something to make it look like I love testing.";
        String sentence2 = "But I don't.";

        String text = sentence0 + sentence1 + sentence2;

        String header = "Love testing";
        Text t = Text.fromString(header, text);
        assertEquals(3, t.getSentences().size());
        assertEquals(header, t.getHeader());

        assertEquals(9, t.getSentences().get(0).getWords().size());
        assertEquals(11, t.getSentences().get(1).getWords().size());
        assertEquals(3, t.getSentences().get(2).getWords().size());
    }

    @Test
    public void testPrint() {
        String sentence0 = "Some new text. ";
        String sentence1 = "   AHhaha tests";

        String text = sentence0 + sentence1;

        String header = "Love testing";
        Text t = Text.fromString(header, text);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        t.print();

        String expected = header + "\n" +
                String.join(". ", sentence0.trim().replace(".", ""), sentence1.trim());
        assertEquals(expected, out.toString());

        System.setOut(System.out);
    }

    @Test
    public void testPrepend() {
        String sentence0 = "Some new text. ";
        String sentence1 = "   AHhaha tests";

        String text = sentence0 + sentence1;

        String header = "Love testing";
        Text t = Text.fromString(header, text);

        Sentence s = new Sentence(Arrays.asList(new Word("Some"), new Word("new"), new Word("text")));
        t.prependSentence(s);
        assertEquals(3, t.getSentences().size());
        assertEquals(s, t.getSentences().get(0));
    }

    @Test
    public void testAppend() {
        String sentence0 = "Some new text. ";
        String sentence1 = "   AHhaha tests";

        String text = sentence0 + sentence1;

        String header = "Love testing";
        Text t = Text.fromString(header, text);
        Sentence s = new Sentence(Arrays.asList(new Word("Some"), new Word("new"), new Word("text")));
        t.appendSentence(s);
        assertEquals(3, t.getSentences().size());
        assertEquals(s, t.getSentences().get(2));
    }

}