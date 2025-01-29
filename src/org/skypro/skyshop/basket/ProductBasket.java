package org.skypro.skyshop.basket;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private List<Product> basket;

    public ProductBasket() {
        basket = new LinkedList<>();
    }

    public void addProduct(Product product) {
        basket.add(product);
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> basketIterator = basket.iterator();
        name = name.toLowerCase();

        while (basketIterator.hasNext()) {
            Product p = basketIterator.next();
            if (p != null && p.getProductName().toLowerCase().equals(name)) {
               deletedProducts.add(p);
               basketIterator.remove();
            }
        }

        return deletedProducts;
    }

    public int getBasketPrice() {
        int sum = 0;
        Iterator<Product> basketIterator = basket.iterator();
        
        while (basketIterator.hasNext()) {
            Product p = basketIterator.next();
            if (p != null) {
                sum += p.getProductPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        Iterator<Product> basketIterator = basket.iterator();

        if (checkBasketForNull()) {
            System.out.println("Корзина пуста.");
            return;
        }

        while (basketIterator.hasNext()) {
            Product p = basketIterator.next();
            if (p != null) {
                System.out.println(p.toString());
            }
        }

        System.out.println("Итого: " + getBasketPrice());

        System.out.println("Специальнных товаров: " + getSpecialProductCount());
    }

    public boolean checkByName(String name) { 
        Iterator<Product> basketIterator = basket.iterator();

        if (basket.size()== 0) { return false; }

        while(basketIterator.hasNext()) {
            Product p = basketIterator.next();
            if (p != null && p.getProductName().toLowerCase().equals(name.toLowerCase())) {
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
        Iterator<Product> basketIterator = basket.iterator();

        while(basketIterator.hasNext()) {
            Product p = basketIterator.next();
            if (p != null && p.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBasketForNull() {
        boolean result = false;
        Iterator<Product> basketIterator = basket.iterator();

        while(basketIterator.hasNext()) {
            Product p = basketIterator.next();
            if (p == null) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
