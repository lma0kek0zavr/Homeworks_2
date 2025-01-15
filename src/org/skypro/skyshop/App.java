package org.skypro.skyshop;

import java.util.Arrays;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        Product simpleProduct1 = new SimpleProduct("Яйца", 10);
        Product simpleProduct2 = new SimpleProduct("Молоко", 20);
        Product simpleProduct3 = new SimpleProduct("Сыр", 30);

        Product discounteProduct1 = new DiscountedProduct("Колбаса", 50, 10);
        Product discounteProduct2 = new DiscountedProduct("Творог", 60, 15);
        Product discounteProduct3 = new DiscountedProduct("Творожный сырок", 999, 20);

        Product fixedProduct1 = new FixPriceProduct("Хлеб");

        Article cheeseArticle = new Article("Хороший сыр", "Отличный сыр по отличной цене");
        Article milkArticle = new Article("Лучшее молоко", "Срок годности заканчивается завтра");

        SearchEngine engine = new SearchEngine(10);

        engine.add(simpleProduct1);
        engine.add(simpleProduct2);
        engine.add(simpleProduct3);
        engine.add(discounteProduct1);
        engine.add(discounteProduct2);
        engine.add(discounteProduct3);
        engine.add(fixedProduct1);
        engine.add(cheeseArticle);
        engine.add(milkArticle);

        Searchable[] productsQueryResult = engine.search("Яйца", "Колбаса", "Хлеб", "Творог", "Творожный сырок");

        System.out.println(Arrays.toString(productsQueryResult));

        Searchable[] articlesQueryResult = engine.search("Хороший сыр", "Лучшее молоко");

        System.out.println(Arrays.toString(articlesQueryResult));
    }
}