package ua.abond.oop.shapes.util;

public final class Doubles {
    private Doubles() {
    }

    public static void requireFinitePositive(double val, String message) {
        if (Double.compare(val, 0.0) <= 0
                || Double.isNaN(val)
                || Double.isInfinite(val)) {
            throw new IllegalArgumentException(message);
        }
    }
}
