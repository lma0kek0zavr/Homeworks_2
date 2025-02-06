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
        List<Product> deletedProducts = new ArrayList<>();
        String productName = name.toLowerCase();
        
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) { 
            List<Product> values = entry.getValue();

            for (Product p : values) {
                if (p.getProductName().equals(productName)) {
                    deletedProducts.add(p);
                    values.remove(p);
                }
            }
        }
        
        return deletedProducts;
    }

    public int getBasketPrice() {
        int sum = 0;
        
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) { 
            List<Product> values = entry.getValue();

            for (Product p : values) {
                sum += p.getProductPrice();
            }
        }

        return sum;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) { 
            String key = entry.getKey();
            List<Product> values = entry.getValue();

            System.out.println(key + ": \n");
            for (Product p : values) {
                System.out.println(p.toString());
            }
            System.out.println("----------");
        }

        System.out.println("Итого: " + getBasketPrice());

        System.out.println("Специальнных товаров: " + getSpecialProductCount());
    }

    public boolean checkByName(String name) { 
        if (basket.isEmpty()) { 
            return false; 
        }

        if (basket.containsValue(basket.get(name))) { 
            return true; 
        }

        return false;
    }

    public void eraseBasket() {
        basket.clear();
    }

    private int getSpecialProductCount() { 
        int count = 0;
        
        return count;
    }
}
