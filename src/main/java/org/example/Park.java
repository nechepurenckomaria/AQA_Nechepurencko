package org.example;

public class Park {

    private class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction (String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public void printInfo () {
            System.out.println("Аттракцион:" + name + ", Время работы:" + workingHours + ", Цена:" + price);
        }
    }
    public static void main (String [] args) {
        Park park = new Park();

        Attraction [] attractions = new Attraction[3];
        attractions [0] = park.new Attraction("Roller Coaster", "10:00 - 22:00", 500);
        attractions [1] = park.new Attraction("Ferris Wheel", "09:00 - 21:00", 300);
        attractions [2] = park.new Attraction("Freefall Tower", "11:00 - 23:00", 400);

        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }
}
