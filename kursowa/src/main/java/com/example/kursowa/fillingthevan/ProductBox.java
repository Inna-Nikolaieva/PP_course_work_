package com.example.kursowa.fillingthevan;

import java.util.Objects;

public class ProductBox implements Comparable<ProductBox> {
    private Product product;
    private int quantity;

    public ProductBox(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductBox() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(ProductBox other) {
        return (int) (this.product.getQuality() - other.product.getQuality());
    }

    @Override
    public String toString() {
        return this.product.toString() + " - " + this.quantity + " pcs\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof ProductBox) {
            ProductBox tmpProductBox = (ProductBox) obj;
            return tmpProductBox.product.equals(this.product);
        }
        return false;
    }
}
