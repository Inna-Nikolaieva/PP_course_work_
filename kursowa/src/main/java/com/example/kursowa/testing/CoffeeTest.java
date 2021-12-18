package com.example.kursowa.testing;

import com.example.kursowa.fillingthevan.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    @Test
    public void testGetCoffeeName() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        String result = coffee.getProductName();
        Assertions.assertEquals("vegetable", result);
    }

    @Test
    public void testGetCoffeeSort() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        String result = coffee.getCoffeeSort();
        Assertions.assertEquals("sort", result);
    }

    @Test
    public void testGetCoffeeType() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        String result = coffee.getCoffeeType();
        Assertions.assertEquals("type", result);
    }

    @Test
    public void testGetCoffeeAmount() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        Double result = coffee.getAmount();
        Assertions.assertEquals(10.0, result);
    }

    @Test
    public void testGetCoffeeWeight() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        Double result = coffee.getGrossWeight();
        Assertions.assertEquals(10.0, result);
    }

    @Test
    public void testGetCoffeeVolume() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        Double result = coffee.getGrossVolume();
        Assertions.assertEquals(10.0, result);
    }

    @Test
    public void testGetCoffeePack() {
        Coffee coffee = new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        String result = coffee.getCoffeePack();
        Assertions.assertEquals("pack", result);
    }

    @Test
    public void testSetCoffeeName() {
        Coffee coffee = new Coffee();
        coffee.setProductName("name");
        Assertions.assertEquals(coffee.getProductName(), "name");
    }

    @Test
    public void testSetCoffeeSort() {
        Coffee coffee = new Coffee();
        coffee.setCoffeeSort("sort");
        Assertions.assertEquals(coffee.getProductName(), "sort");
    }

    @Test
    public void testSetCoffeeType() {
        Coffee coffee = new Coffee();
        coffee.setCoffeeType("type");
        Assertions.assertEquals(coffee.getProductName(), "type");
    }

    @Test
    public void testSetCoffeeAmount() {
        Coffee coffee = new Coffee();
        coffee.setAmount(100.0);
        Assertions.assertEquals(coffee.getGrossWeight(), 100.0);
    }

    @Test
    public void testSetCoffeeWeight() {
        Coffee coffee = new Coffee();
        coffee.setGrossWeight(100.0);
        Assertions.assertEquals(coffee.getGrossWeight(), 100.0);
    }

    @Test
    public void testSetCoffeeVolume() {
        Coffee coffee = new Coffee();
        coffee.setGrossVolume(100.0);
        Assertions.assertEquals(coffee.getGrossVolume(), 100.0);
    }

    @Test
    public void testSetCoffeePack() {
        Coffee coffee = new Coffee();
        coffee.setCoffeePack("pack");
        Assertions.assertEquals(coffee.getCoffeePack(), "pack");
    }

    @Test
    public void testGetCoffeeQuality() {
        Coffee coffee = new Coffee();
        coffee.setAmount(200.0);
        coffee.setGrossWeight(100.0);
        Assertions.assertEquals(coffee.getQuality(), 2.0);
    }
}
