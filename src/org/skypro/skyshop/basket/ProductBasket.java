package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private List<Product> basket;

    public ProductBasket() {
        basket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        basket.add(product);
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        String productName = name.toLowerCase();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getProductName().toLowerCase().equals(productName)) {
               deletedProducts.add(p);
               iterator.remove();
            }
        }

        return deletedProducts;
    }

    public int getBasketPrice() {
        int sum = 0;
        
        for (Product p : basket) {
            sum += p.getProductPrice();
        }

        return sum;
    }

    public void printBasket() {
        if (basket.size() == 0) {
            System.out.println("Корзина пуста.");
            return;
        }

        
        for (Product p : basket) {
            System.out.println(p.toString());
        }

        System.out.println("Итого: " + getBasketPrice());

        System.out.println("Специальнных товаров: " + getSpecialProductCount());
    }

    public boolean checkByName(String name) { 
        if (basket.size()== 0) { return false; }

        for (Product p : basket) {
            if (p.getProductName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void eraseBasket() {
        basket.clear();
    }

    private int getSpecialProductCount() { 
        int count = 0;

        for (Product p : basket) {
            if (p.isSpecial()) {
                count++;
            }
        }
        return count;
    }
}
