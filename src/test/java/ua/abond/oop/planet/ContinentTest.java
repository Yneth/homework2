package ua.abond.oop.planet;

public class ContinentTest extends GeographicObjectTest {

    @Override
    protected GeographicalObject create(String name) {
        return new Continent(name);
    }
}