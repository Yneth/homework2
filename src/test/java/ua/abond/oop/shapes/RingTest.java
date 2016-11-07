package ua.abond.oop.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RingTest {
    private static final double DELTA = 0.01;

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeZeroArg() {
        getArea(-0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeArg() {
        getArea(-1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInfinityArg() {
        getArea(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveInfinityArg() {
        getArea(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNan() {
        getArea(Double.NaN);
    }

    @Test
    public void getArea() throws Exception {
        assertEquals(Math.PI, getArea(1.0), DELTA);
        assertEquals(12.57, getArea(2.0), DELTA);
        assertEquals(12.57, getArea(2.0), DELTA);
        assertEquals(28.27, getArea(3.0), DELTA);
        assertEquals(78.54, getArea(5.0), DELTA);
        assertEquals(153.94, getArea(7.0), DELTA);
        assertEquals(254.47, getArea(9.0), DELTA);
        assertEquals(272.96, getArea(9.321312), DELTA);
        assertEquals(47777.8, getArea(123.321312), DELTA);
        assertEquals(3488.14, getArea(33.321312), DELTA);
    }

    private static double getArea(double radius) {
        return new Ring(radius).getArea();
    }
}