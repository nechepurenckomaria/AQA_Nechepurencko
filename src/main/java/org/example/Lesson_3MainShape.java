package org.example;

public class Lesson_3MainShape {
    public static void main(String[] args) {

        Shape circle = new Circle(10, "Фиолетовый", "Зеленый") ;
        Shape rectangle = new Rectangle(4, 6, "Красный", "Желтый");
        Shape triangle = new Triangle(3, 3, 4, "Синий", "Белый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();

    }
}
