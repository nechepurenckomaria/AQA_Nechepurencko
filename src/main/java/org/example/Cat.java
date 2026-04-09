package org.example;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat (String name) {
        super(name);
        this.isFull = false;
        catCount ++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(getName() + "пробежал" + distance + "м");
        } else {
            System.out.println(getName() + "не пробежал" + distance + "м");
        };
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + "не умеет плавать");

    }

    @Override
    public void eat (Plate plate) {
        int appetite = 10;

        if (plate.getFood() >= appetite) {
            plate.decreaseFood (appetite);
            isFull = true;
        }
    }
    @Override
    public boolean isFull () {
        return isFull;
    }
    public static int getCatCount () {
        return catCount;
    }

}
