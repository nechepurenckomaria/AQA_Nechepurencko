package org.example;

public class ColaExerciseTwo {
    public static void main (String [] args) {
        Product [] products = new Product[5];

        products [0] = new Product("Coca-Cola Original", "01.04.2026", "Coca-Cola", "Russia", 120, true);
        products [1] = new Product("Dobry Cola", "02.04.2026", "Multon Partners", "Russia", 150, false);
        products [2] = new Product("CoolCola", "03.04.2026", "Ochakovo", "Russia", 110, true);
        products [3] = new Product("Cola Chernogolovka", "04.04.2005", "Aqualife", "Russia", 140, false);
        products [4] = new Product("Everless Cola", "05.04.2026", "PepsiCo Holdings", "Russia", 160, true);
        for (Product product : products) {
            product.printInfo();
        }
    }
}
