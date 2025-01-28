package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String productName;

    public Product(String productName) {
        if (productName.isBlank() || productName.isEmpty() || productName == null) {
            throw new IllegalArgumentException("Неправильное имя");
        } else {
            this.productName = productName;
        }
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();
}
