package ua.abond.oop.shapes;

import java.util.Objects;

@FunctionalInterface
public interface Shape {
    double getArea();

    default double sumOfAreas(Shape that) {
        Objects.requireNonNull(that);
        return this.getArea() + that.getArea();
    }
}
