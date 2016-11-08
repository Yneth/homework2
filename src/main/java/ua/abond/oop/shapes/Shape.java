package ua.abond.oop.shapes;

import java.util.Objects;

public abstract class Shape {
    public abstract double getArea();

    public double sumOfAreas(Shape that) {
        Objects.requireNonNull(that);
        return this.getArea() + that.getArea();
    }
}
