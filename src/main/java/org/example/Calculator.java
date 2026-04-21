package org.example;

public class Calculator {
    public static int add (int a, int b) {
        return a + b;
    }
    public static int subtract (int a, int b) {
        return a - b;
    }
    public static int multiply (int a, int b) {
        return a * b;
    }
    public static int divide (int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("division by zero");
        }
        return a/b;
    }
}
