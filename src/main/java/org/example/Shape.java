package org.example;

public interface Shape {
    double getArea ();
    double getPerimeter ();
    String getFillColor ();
    String getBorderColor ();

    default void printInfo () {
        System.out.println("Площадь:" + getArea());
        System.out.println("Периметр:" + getPerimeter());
        System.out.println("Цвет звливки:" + getFillColor());
        System.out.println("Цвет границы:" + getBorderColor());
    }
}
