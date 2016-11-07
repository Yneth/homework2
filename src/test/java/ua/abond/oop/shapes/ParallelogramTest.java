package ua.abond.oop.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParallelogramTest {

    private static final double DELTA = 0.0001;

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

    @Test
    public void testGetArea() throws Exception {
        assertEquals(264, getArea(22, 12), DELTA);
        assertEquals(10593, getArea(321, 33), DELTA);
        assertEquals(49, getArea(1, 49), DELTA);
        assertEquals(49, getArea(49, 1), DELTA);

        assertEquals(138949621621482672.0, getArea(432432432432.0, 321321.0), DELTA);
        assertEquals(3959103240540537548293152.0, getArea(321321321, 12321321312321312.0), DELTA);
        assertEquals(298057334286362533076.0, getArea(54654745643.0, 5453457532.0), DELTA);
    }

    private static double getArea(double base, double height) {
        return new Parallelogram(base, height).getArea();
    }
}