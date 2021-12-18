package com.example.kursowa.van;

import com.example.kursowa.fillingthevan.Product;
import com.example.kursowa.fillingthevan.ProductBox;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Van {

    private final Double volume;
    private Double freeVolume;
    private final Double amount;
    private Double freeAmount;
    private final List<ProductBox> productBox = new ArrayList<>();

    public Van(Double volume, Double amount) {
        this.volume = volume;
        freeVolume = volume;

        this.amount = amount;
        freeAmount = amount;
    }

    public boolean addPack(Product product, int quantity) {

        double addVolume = quantity * product.getGrossVolume();
        double addAmount = quantity * product.getAmount();
        if (addAmount > freeAmount) {
            return true;
        }
        if (addVolume > freeVolume) {
            return true;
        }
        freeAmount -= addAmount;
        freeVolume -= addVolume;
        ProductBox newPack = new ProductBox(product, quantity);
        int index = productBox.indexOf(newPack);
        if (index >= 0) {
            int oldQuantity = productBox.get(index).getQuantity();
            productBox.get(index).setQuantity(oldQuantity + quantity);
        } else {
            productBox.add(newPack);
        }
        return false;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getVolume() {
        return volume;
    }

    public List<ProductBox> getProductBox() {
        return productBox;
    }

    public Double getFreeVolume() {
        return freeVolume;
    }

    public Double getFreeAmount() {
        return freeAmount;
    }

    public void makeWagonEmpty() {
        productBox.clear();
        freeVolume = volume;
        freeAmount = amount;
    }

    public void sortByPriceByWeight() {
        Collections.sort(productBox);
        System.out.println("|Назва|\t\t\t|Сорт кави|\t\t|Тип|\t\t|Ціна|\t\t|Вага|\t\t|Об'єм|\t\t|Тип пакування|");
        for (int index = 0; index < productBox.size(); index++) {
            System.out.print((index + 1) + productBox.get(index).toString());
        }
    }

    public void findProductBySomeParameters(Double priceFrom, Double priceTo, Double weightFrom,
                                            Double weightTo, Double volumeFrom, Double volumeTo) {
        System.out.println("|Назва|\t\t\t|Сорт кави|\t\t|Тип|\t\t|Ціна|\t\t|Вага|\t\t|Об'єм|\t\t|Тип пакування|");
        for (int index = 0; index < productBox.size(); index++) {
            if (productBox.get(index).getProduct().getAmount() >= priceFrom &&
                    productBox.get(index).getProduct().getAmount() <= priceTo &&
                    productBox.get(index).getProduct().getGrossWeight() <= weightFrom &&
                    productBox.get(index).getProduct().getAmount() >= weightTo &&
                    productBox.get(index).getProduct().getGrossVolume() >= volumeFrom &&
                    productBox.get(index).getProduct().getGrossVolume() <= volumeTo)
                System.out.println(productBox.get(index).toString());
        }
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        for (ProductBox b : productBox) {
            string.append(b.toString());
        }
        return string.toString();
    }
}