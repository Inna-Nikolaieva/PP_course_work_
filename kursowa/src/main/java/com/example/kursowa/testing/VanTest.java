package com.example.kursowa.testing;

import com.example.kursowa.fillingthevan.Coffee;
import com.example.kursowa.fillingthevan.ProductBox;
import com.example.kursowa.van.Van;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VanTest {

    @Test
    public void testGetVanAmount() {
        Van van=new Van(4000.0,6000.0);
        Double result = van.getAmount();
        Assertions.assertEquals(6000.0, result);
    }

    @Test
    public void testGetVanVolume() {
        Van van=new Van(4000.0,6000.0);
        Double result = van.getVolume();
        Assertions.assertEquals(4000.0, result);
    }

    @Test
    public void testAddPack() {
        //arrange
        Van van=new Van(4000.0,6000.0);
        Coffee coffee=new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack") ;
        //act
        van.addPack(coffee,10);
        ProductBox result=van.getProductBox().get(0);
        //assert
        Assertions.assertEquals(result.getProduct(), coffee);
        Assertions.assertEquals(result.getQuantity(), 10);
    }

    @Test
    public void testSortByPriceByWeight() {
        //arrange
        Van van=new Van(4000.0,6000.0);
        Coffee coffee1 = new Coffee("coffee1", "sort1", "type1", 10.0, 10.0, 10.0, "pack1");
        Coffee coffee2=new Coffee("coffee2", "sort2", "type2", 1000.0, 1000.0, 1000.0, "pack2") ;
        Coffee coffee3=new Coffee("coffee3", "sort3", "type3", 100.0, 100.0, 100.0, "pack3") ;
        van.addPack(coffee1,10);
        van.addPack(coffee2,10);
        van.addPack(coffee3,10);
        //act
        van.sortByPriceByWeight();
        //assert
        Assertions.assertEquals(coffee1, van.getProductBox().get(0).getProduct());
        Assertions.assertEquals(coffee3, van.getProductBox().get(1).getProduct());
        Assertions.assertEquals(coffee2, van.getProductBox().get(2).getProduct());
    }
}
