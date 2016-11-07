package ua.abond.oop.planet;

import static org.junit.Assert.*;

public class ContinentTest extends GeographicObjectTest {

    @Override
    protected GeographicObject create(String name) {
        return new Continent(name);
    }
}