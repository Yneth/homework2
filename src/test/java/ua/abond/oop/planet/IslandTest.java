package ua.abond.oop.planet;

import static org.junit.Assert.*;

public class IslandTest extends GeographicObjectTest {

    @Override
    protected GeographicObject create(String name) {
        return new Island(name);
    }
}