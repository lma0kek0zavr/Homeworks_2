package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Хлеб", 100);
        Product product2 = new SimpleProduct("Молоко", 200);
        Product product3 = new SimpleProduct("Сыр", 300);
        Product product4 = new SimpleProduct("Яблоки", 400);
        Product product5 = new SimpleProduct("Хлеб рисовый", 500);
        Product product6 = new SimpleProduct("Хлеб черный", 600);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        basket.printBasket();

        List<Product> deletedProducts = new ArrayList<>();

        deletedProducts = basket.deleteProduct("Хлеб");

        System.out.println("---------------------------------");

        print(deletedProducts);

        System.out.println("---------------------------------");

        basket.printBasket();

        deletedProducts = basket.deleteProduct("null");

        System.out.println("---------------------------------");

        print(deletedProducts);

        System.out.println("---------------------------------");

        basket.printBasket();

        SearchEngine engine = new SearchEngine();

        engine.add(product1);
        engine.add(product2);
        engine.add(product3);
        engine.add(product4);
        engine.add(product5);
        engine.add(product6);

        List<Searchable> found = engine.search("хлеб");

        print(found);
    }

    static void print(List list) {
        if (list.size() == 0) { 
            System.out.println("Список пустой");
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}