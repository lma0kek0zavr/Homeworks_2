package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Map<String, List<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!basket.containsKey(product.getProductName())) {
            basket.put(product.getProductName(), new ArrayList<>());
        }
        
        basket.get(product.getProductName()).add(product);
    }

    public List<Product> deleteProduct(String name) {
        return basket.remove(name);
    }

    public int getBasketPrice() {
        return basket.values().stream()
            .flatMap(List::stream)
            .mapToInt(Product::getProductPrice)
            .sum();
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        
        basket.entrySet().stream()
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
            

        System.out.println("Итого: " + getBasketPrice());

        System.out.println("Специальнных товаров: " + getSpecialProductCount());
    }

    public boolean checkByName(String name) { 
        boolean isContain = false;
        String productName = name.toLowerCase();

        if (basket.isEmpty()) { 
            return false; 
        }

        isContain = basket.values().stream()
            .flatMap(List::stream)
            .anyMatch(p -> p.getProductName().toLowerCase().equals(productName));

        return isContain;
    }

    public void eraseBasket() {
        basket.clear();
    }

    private long getSpecialProductCount() { 
        long count = 0;
        
        count = basket.values().stream()
            .flatMap(List::stream)
            .filter(Product::isSpecial)
            .count();

        return count;
    }
}
