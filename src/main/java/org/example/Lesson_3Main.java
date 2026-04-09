package org.example;

public class Lesson_3Main {
    public static void main(String[] args) {

        Animal [] animals = {
                new Dog("Шарик"),
                new Dog("Бобик"),
                new Cat("Мурзик"),
                new Cat("Барсик")

        };
        for (Animal animal : animals) {
            animal.run(150);
            animal.swim(5);
        }
        Plate plate = new Plate(15);

        for (Animal animal : animals) {
            animal.eat(plate);
        }
            for (Animal animal1 : animals) {
                System.out.println(animal1.getName() + "сытость" + animal1.isFull());
            }
            System.out.println("Животных:" + Animal.getAnimalCount());
            System.out.println("Собак:" + Dog.getDogCount());
            System.out.println("Кошек" + Cat.getCatCount());
        }
    }

