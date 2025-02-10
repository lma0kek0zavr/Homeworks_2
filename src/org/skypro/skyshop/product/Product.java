package org.skypro.skyshop.product;

import java.util.Objects;

import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.SearchableComparator;

public abstract class Product implements Searchable, Comparable<Searchable> {
    protected String productName;
    private SearchableComparator comparator;

    public Product(String productName) {
        if (productName.isBlank() || productName.isEmpty() || productName == null) {
            throw new IllegalArgumentException("Неправильное имя");
        } 

        this.productName = productName;

        comparator = new SearchableComparator();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productName == product.getProductName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public int compareTo(Searchable o) {
        return comparator.compare(this, o);
    }
}
