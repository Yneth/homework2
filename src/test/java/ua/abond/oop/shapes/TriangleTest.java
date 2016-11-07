package ua.abond.oop.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInfinityArg() {
        getArea(Double.NEGATIVE_INFINITY, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveInfinityArg() {
        getArea(Double.POSITIVE_INFINITY, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNan() {
        getArea(Double.NaN, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInfinityArg1() {
        getArea(1.0, Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveInfinityArg1() {
        getArea(1.0, Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNan1() {
        getArea(1.0, Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFirstNegative() {
        getArea(-1.0, -3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSecondNegative() {
        getArea(1.0, -3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFirstZero() {
        getArea(0.0, -3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSecondZero() {
        getArea(1.0, 0.0);
    }

    private static double getArea(double a, double b) {
        return new Triangle(a, b).getArea();
    }
}