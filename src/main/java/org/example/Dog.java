package org.example;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog (String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(getName() + "пробежал" + distance + "м");
        } else {
            System.out.println(getName() + "не пробежал" + distance + "м");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(getName() + "проплыл" + distance + "м");
        } else {
            System.out.println(getName() + "не проплыл" + distance + "м");
        }

    }
    public static int getDogCount () {
        return dogCount;
    }

}

