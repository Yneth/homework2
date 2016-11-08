package ua.abond.oop.planet;

public class IslandTest extends GeographicObjectTest {

    @Override
    protected GeographicalObject create(String name) {
        return new Island(name);
    }
}