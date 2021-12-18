package com.example.kursowa.fillingthevan;

abstract public class Product {

    protected String productName;
    protected Double amount;
    protected Double grossVolume;
    protected Double grossWeight;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getGrossVolume() {
        return grossVolume;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setGrossVolume(Double grossVolume) {
        this.grossVolume = grossVolume;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }


    public Double getQuality() {
        return (this.amount / this.grossWeight);
    }
}