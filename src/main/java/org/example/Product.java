package org.example;

public class Product implements Products {
    Long sum;

    public Product(Long sum) {
        this.sum = sum;
    }

    @Override
    public void writeDown() {
        System.out.println("Штучный товар = " + getSum());
    }

    @Override
    public Long getSum() {
        return sum;
    }

}