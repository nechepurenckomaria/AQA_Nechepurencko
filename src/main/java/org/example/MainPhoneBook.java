package org.example;

public class MainPhoneBook {
    public static void main(String[] args) {

        PhoneBook ph = new PhoneBook();

        ph.add("Stark", "12345");
        ph.add("Stark", "67890");
        ph.add("Lannister", "11121");
        ph.add("Lannister", "13141");
        ph.add("Targaryen", "15161");
        ph.add("Martell", "17181");

        System.out.println("Stark:" + ph.get("Stark"));
        System.out.println("Lannister:" + ph.get("Lannister"));
        System.out.println("Targaryen:" + ph.get("Targaryen"));
        System.out.println("Martell:" + ph.get("Martell"));
        System.out.println("Tyrell:" + ph.get("Tyrell"));
    }
}
