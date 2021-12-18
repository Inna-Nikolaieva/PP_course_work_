package com.example.kursowa.fillingthevan;

public class Coffee extends Product {
    private String coffeeSort;
    private String coffeeType;
    private String coffeePack;

    public Coffee(String name, String sort, String type, Double price,
                  Double netWeight, Double netVolume, String pack) {
        this.productName = name;
        this.coffeeSort = sort;
        this.coffeeType = type;
        this.amount = price;
        this.coffeePack = pack;
        this.grossWeight = netWeight;
        this.grossVolume = netVolume;
    }

    public Coffee() {

    }

    public String getCoffeeSort() {
        return coffeeSort;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public String getCoffeePack() {
        return coffeePack;
    }

    public void setCoffeeSort(String coffeeSort) {
        this.coffeeSort = coffeeSort;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public void setCoffeePack(String coffeePack) {
        this.coffeePack = coffeePack;
    }

    @Override
    public Double getQuality() {
        return (this.amount / this.grossWeight);
    }

    @Override
    public String toString() {
        String string;
        string = productName + "\t\t\t" + coffeeSort + "\t\t\t" + coffeeType + "\t\t\t" + amount + "\t\t\t" + grossWeight +
                "\t\t\t" + grossVolume + "\t\t\t" + coffeePack;
        return string;
    }
}
