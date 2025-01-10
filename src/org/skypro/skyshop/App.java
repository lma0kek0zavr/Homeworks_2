package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 15);
        Product eggs = new Product("Eggs", 20);

        productBasket.addProduct(milk);
        productBasket.addProduct(bread);
        productBasket.addProduct(eggs);

        productBasket.printBasket();

        System.out.println("_______________________________");

        System.out.println("Стоимость корзины: " + productBasket.getBasketPrice());

        System.out.println("_______________________________");

        System.out.println(productBasket.checkByName("milk"));

        System.out.println("_______________________________");

        productBasket.eraseBasket();

        productBasket.printBasket();
    }
}
