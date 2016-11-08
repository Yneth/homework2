package ua.abond.oop.planet;

public class OceanTest extends GeographicObjectTest {

    @Override
    protected GeographicalObject create(String name) {
        return new Ocean(name);
    }
}