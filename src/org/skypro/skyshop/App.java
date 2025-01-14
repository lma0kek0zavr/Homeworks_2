package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product simpleProduct_1 = new SimpleProduct("Яйца", 10);
        Product simpleProduct_2 = new SimpleProduct("Молоко", 20);
        Product simpleProduct_3 = new SimpleProduct("Сыр", 30);

        Product discounteProduct_1 = new DiscountedProduct("Колбаса", 50, 10);
        Product discounteProduct_2 = new DiscountedProduct("Творог", 60, 15);
        Product discounteProduct_3 = new DiscountedProduct("Творожный сырок", 999, 20);

        Product fixedProduct_1 = new FixPriceProduct("Хлеб");

        productBasket.addProduct(simpleProduct_1);
        productBasket.addProduct(simpleProduct_2);
        productBasket.addProduct(simpleProduct_3);
        productBasket.addProduct(discounteProduct_1);
        productBasket.addProduct(discounteProduct_2);
        productBasket.addProduct(discounteProduct_3);
        productBasket.addProduct(fixedProduct_1);

        productBasket.printBasket();

        System.out.println(productBasket.checkByName("сыр"));

        System.out.println(productBasket.getBasketPrice());

        productBasket.eraseBasket();

        productBasket.printBasket();
    }
}
