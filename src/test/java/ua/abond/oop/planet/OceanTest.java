package ua.abond.oop.planet;

import static org.junit.Assert.*;

public class OceanTest extends GeographicObjectTest {

    @Override
    protected GeographicObject create(String name) {
        return new Ocean(name);
    }
}