package org.example;

public class Triangle {
    public static double area (double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("base and height must be > 0");

        }
        return 0.5 * base * height;
    }

}
