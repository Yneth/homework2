package ua.abond.oop.shapes;

import ua.abond.oop.shapes.util.Doubles;

public class Trapezium implements Shape {
    private final double height;
    private final double bottomBase;
    private final double topBase;

    public Trapezium(double height, double bottomBase, double topBase) {
        Doubles.requireFinitePositive(height, "Height cannot be negative or zero.");
        Doubles.requireFinitePositive(bottomBase, "BottomBase cannot be negative or zero.");
        Doubles.requireFinitePositive(topBase, "TopBase cannot be negative or zero.");

        this.height = height;
        this.bottomBase = bottomBase;
        this.topBase = topBase;
    }

    @Override
    public double getArea() {
        return (bottomBase + topBase) * height * 0.5;
    }

    public double getHeight() {
        return height;
    }

    public double getBottomBase() {
        return bottomBase;
    }

    public double getTopBase() {
        return topBase;
    }
}
