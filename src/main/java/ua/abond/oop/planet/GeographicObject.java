package ua.abond.oop.planet;

import java.util.Objects;

public abstract class GeographicObject {
    protected final String name;

    public GeographicObject(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public void printName() {
        System.out.print(name);
    }

    public String getName() {
        return name;
    }
}
