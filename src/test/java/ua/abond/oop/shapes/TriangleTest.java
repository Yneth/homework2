package ua.abond.oop.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    private static final double DELTA = 0.01;

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
        getArea(0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSecondZero() {
        getArea(1.0, 0.0);
    }

    @Test
    public void testGetArea() {
        assertEquals(66.05, getArea(1321, 0.1), DELTA);
        assertEquals(21136, getArea(1321, 32), DELTA);
        assertEquals(10584, getArea(49, 432), DELTA);
        assertEquals(93009, getArea(43, 4326), DELTA);
        assertEquals(93015.91, getArea(43, 4326.321321), DELTA);
        assertEquals(93710.54, getArea(43.32112, 4326.321321), DELTA);
    }

    private static double getArea(double a, double b) {
        return new Triangle(a, b).getArea();
    }
}