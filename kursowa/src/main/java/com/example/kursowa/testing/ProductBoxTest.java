package com.example.kursowa.testing;

import com.example.kursowa.fillingthevan.Coffee;
import com.example.kursowa.fillingthevan.ProductBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductBoxTest {

    @Test
    public void testGetProduct() {
        ProductBox productBox=new ProductBox();
        Coffee coffee= new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        Coffee result = (Coffee) productBox.getProduct();
        Assertions.assertEquals(coffee, result);
    }

    @Test
    public void testGetQuantity() {
        Coffee coffee= new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        ProductBox productBox=new ProductBox(coffee,12);
        Assertions.assertEquals(productBox.getQuantity(), 12);
    }

    @Test
    public void testSetProduct() {
        ProductBox productBox=new ProductBox();
        Coffee coffee= new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        productBox.setProduct(coffee);
        Assertions.assertEquals(productBox.getProduct(), coffee);
    }

    @Test
    public void testSetQuantity() {
        ProductBox productBox=new ProductBox();
        Coffee coffee= new Coffee("coffee", "sort", "type", 10.0, 10.0, 10.0, "pack");
        productBox.setQuantity(12);
        Assertions.assertEquals(productBox.getQuantity(), 12);
    }
}
