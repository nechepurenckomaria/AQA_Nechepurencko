package org.example;

public abstract class Animal {
    private String  name;
    private static int animalCount = 0;

    public Animal (String name) {
        this.name = name;
        animalCount ++;
    }
    public String getName () {
        return name;
    }
    public abstract void run (int distance);
    public abstract void swim (int distance);

    public void eat (Plate plate) {
    }
    public boolean isFull () {
        return false;
    }
    public static int getAnimalCount () {
        return animalCount;
    }
}
