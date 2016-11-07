package ua.abond.oop.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapeTest {
    private static final double DELTA = 0.01;

    @Test(expected = NullPointerException.class)
    public void testNullArg() {
        new Ring(1).sumOfAreas(null);
    }

    @Test
    public void testSumOfAreasSymmetry() throws Exception {
        Shape s0 = new Parallelogram(1, 2);
        Shape s1 = new Ring(1);
        assertEquals(5.14, sum(s0, s1), DELTA);
        Shape temp = s0;
        s0 = s1;
        s1 = temp;
        assertEquals(5.14, sum(s0, s1), DELTA);
    }

    private double sum(Shape s0, Shape s1) {
        return s0.sumOfAreas(s1);
    }

}