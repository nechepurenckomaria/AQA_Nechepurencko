package org.example;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean reserved ;

    public Product (String name, String productionDate, String manufacturer, String country, double price, boolean reserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }
    public void printInfo () {
        System.out.println ("Название:" + name + ", Дата:" + productionDate + ", Производитель:" + manufacturer + ", Страна:" + country + ", Цена:" + price + ", Забронирован:"
        + reserved) ;

    }
}
