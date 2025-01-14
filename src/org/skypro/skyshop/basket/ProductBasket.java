package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket;

    public ProductBasket() {
        basket = new Product[7];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                break;
            }
        }
    }

    public int getBasketPrice() {
        int sum = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                sum += basket[i].getProductPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        if (checkBasketForNull()) {
            System.out.println("Корзина пуста.");
            return;
        }

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                System.out.println(basket[i]);
            }
        }

        System.out.println("Итого: " + getBasketPrice());

        System.out.println("Специальнных товаров: " + getSpecialProductCount());
    }

    public boolean checkByName(String name) { 
        if (basket.length == 0) { return false; }

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null && basket[i].getProductName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void eraseBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }

    private int getSpecialProductCount() { 
        int count = 0;

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null && (basket[i].isSpecial())) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBasketForNull() {
        boolean result = false;

        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                result = true;
            }
            else {
                result = false;
                break;
            }
        }
        return result;
    }
}
