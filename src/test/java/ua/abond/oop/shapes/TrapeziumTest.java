package ua.abond.oop.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrapeziumTest {

    private static final double DELTA = 0.01;

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInfinityArg() {
        getArea(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInfinityArg1() {
        getArea(1.0, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInfinityArg2() {
        getArea(1.0, 1.0, Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveInfinityArg() {
        getArea(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveInfinityArg1() {
        getArea(1.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositiveInfinityArg2() {
        getArea(1.0, 1.0, Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNan() {
        getArea(Double.NaN, Double.NaN, Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNan1() {
        getArea(1.0, Double.NaN, Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNan2() {
        getArea(1.0, 1.0, Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFirstNegative() {
        getArea(-1.0, -3.0, -9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSecondNegative() {
        getArea(1.0, -3.0, -9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThirdNegative() {
        getArea(1.0, 3.0, -9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorFirstZero() {
        getArea(0.0, 0.0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSecondZero() {
        getArea(1.0, 0.0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThirdZero() {
        getArea(1.0, 1.0, 0);
    }

    @Test
    public void getArea() throws Exception {
        assertEquals(1.0, getArea(1.0, 1.0, 1.0), DELTA);
        assertEquals(5.5, getArea(1.0, 1.0, 10.0), DELTA);
        assertEquals(10.0, getArea(1.0, 10.0, 10.0), DELTA);
        assertEquals(32454.0, getArea(2.0, 322.0, 32132.0), DELTA);
        assertEquals(32454.12, getArea(2.0, 322.12312, 32132.0), DELTA);
        assertEquals(32454.33, getArea(2.0, 322.12312, 32132.2112), DELTA);
        assertEquals(64354.33, getArea(2.0, 32222.12312, 32132.2112), DELTA);
    }

    private static double getArea(double height, double botBase, double topBase) {
        return new Trapezium(height, botBase, topBase).getArea();
    }
}

