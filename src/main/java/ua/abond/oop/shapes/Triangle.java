package ua.abond.oop.shapes;

import ua.abond.oop.shapes.util.Doubles;

public class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        Doubles.requireFinitePositive(base, "Base cannot be negative or zero.");
        Doubles.requireFinitePositive(height, "Height cannot be negative or zero.");

        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return base * height * 0.5;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}
