package ua.abond.oop.planet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public abstract class GeographicObjectTest {
    @Test
    public void printName() throws Exception {
        String name = "Test Name";
        GeographicalObject obj = create(name);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        obj.printName();

        assertEquals(name, out.toString());

        System.setOut(System.out);
    }

    @Test
    public void getName() throws Exception {
        String name = "Test Name";
        GeographicalObject obj = create(name);

        assertEquals(name, obj.getName());
    }

    @Test(expected = NullPointerException.class)
    public void createWithNullArg() throws Exception {
        GeographicalObject obj = create(null);
    }

    protected abstract GeographicalObject create(String name);
}