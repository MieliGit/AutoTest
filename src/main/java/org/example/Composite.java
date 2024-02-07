package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Composite implements Products {

    private List<Products> products = new ArrayList<>();

    void addProduct(Products product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public void writeDown() {
        for (Products product : products) {
            product.writeDown();
        }
    }

    @Override
    public Long getSum() {
        AtomicReference<Long> result = new AtomicReference<>(0L);
        products.forEach(iProduct -> {
            result.set(result.get() + iProduct.getSum());
        });
        return result.get();
    }
}