package org.skypro.skyshop;

import java.util.List;
import java.util.Set;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        Article article1 = new Article("Хлеб черный", "Лучший хлеб на свете");
        Article article2 = new Article("Хлеб рисовый", "Тот самый рисовый");
        Article article3 = new Article("Молоко", "Свежайщее");
        Article article4 = new Article("Сыр", "Самый мягкий и изысканный сыр на свете");
        Article article5 = new Article("Молоко", "Самое свежее молоко");
        Article article6 = new Article("Сыр", "Тот самый пармезан");
        Article article7 = new Article("Сыр", "Любимая всеми дружба");

        SearchEngine engine = new SearchEngine();

        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);
        engine.add(article5);
        engine.add(article6);
        engine.add(article7);

        Set<Searchable> found = engine.search("сыр", "хлеб", "молоко");

        print(found);

        Product product1 = new SimpleProduct("Хлеб черный", 100);
        Product product2 = new SimpleProduct("Хлеб рисовый", 200);
        Product product3 = new SimpleProduct("Молоко", 150);
        Product product4 = new SimpleProduct("Сыр", 400);
        Product product5 = new SimpleProduct("Сыр", 500);
        Product product6 = new FixPriceProduct("Молоко");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        List<Product> products = basket.deleteProduct("Хлеб черный");

        print(products);

        basket.printBasket();
    }

    static void print(List<?> list) {
        if (list.isEmpty()) { 
            System.out.println("Список пустой");
        }

        for (Object s : list) {
            System.out.println(s);
        }
    }

    static void print(Set<?> set) {
        if (set.isEmpty()) { 
            System.out.println("Список пустой");
        }

        for (Object s : set) {
            System.out.println(s);
        }
    }
}