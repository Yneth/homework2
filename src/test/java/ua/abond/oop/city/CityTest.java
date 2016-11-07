package ua.abond.oop.city;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {
    @Test(expected = NullPointerException.class)
    public void testFirstArgNull() throws Exception {
        new City(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testSecondArgNull() throws Exception {
        new City("", null);
    }

    @Test
    public void testGetName() throws Exception {
        String name = "Test";
        assertEquals(name, create(name).getName());
    }

    @Test
    public void testGetDetails() throws Exception {
        City.Details details = new City.Details();
        City c = new City("", details);

        assertEquals(details, c.getDetails());
    }

    private City create(String name) {
        return new City(name, new City.Details());
    }
}