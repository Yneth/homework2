package ua.abond.oop.planet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PlanetTest extends GeographicObjectTest {
    @Test(expected = NullPointerException.class)
    public void nullArg1() {
        new Planet("", null, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void nullArg2() {
        new Planet("", new LinkedList<>(), null, null);
    }
    @Test(expected = NullPointerException.class)
    public void nullArg3() {
        new Planet("", new LinkedList<>(), new LinkedList<>(), null);
    }


    @Test
    public void printContinentCount() throws Exception {
        String name = "Test Name";
        Planet obj = (Planet) create(name);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        obj.printContinentCount();

        assertEquals("Continent count: " + obj.getContinents().size(), out.toString());

        System.setOut(System.out);
    }

    @Test
    public void testBuilder() throws Exception {
        String name = "Test name";
        List<Continent> continents = Arrays.asList(new Continent("A"));
        List<Island> islands = Arrays.asList(new Island("A"));
        List<Ocean> oceans = Arrays.asList(new Ocean("A"));
        Planet planet = Planet.builder()
                .setName(name)
                .setContinents(continents)
                .setIslands(islands)
                .setOceans(oceans)
                .build();
        assertEquals(continents.size(), planet.getContinents().size());
        assertEquals(islands.size(), planet.getIslands().size());
        assertEquals(oceans.size(), planet.getOceans().size());
    }

    @Override
    protected GeographicalObject create(String name) {
        return new Planet(name,
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>()
        );
    }
}