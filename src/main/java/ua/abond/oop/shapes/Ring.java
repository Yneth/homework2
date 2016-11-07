package ua.abond.oop.shapes;

import ua.abond.oop.shapes.util.Doubles;

public class Ring implements Shape {
    private final double radius;

    public Ring(double radius) {
        Doubles.requireFinitePositive(radius, "Radius cannot be negative or zero.");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}
