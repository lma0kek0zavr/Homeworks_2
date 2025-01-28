package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        try {
            Product simpleProduct1 = new SimpleProduct("    ", 0);
            Product discountedProduct1 = new DiscountedProduct("Колбаса", 100, -10);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            Product simpleProduct2 = new SimpleProduct("сырссырсыыырсырсссссыр", 100);
            Product discountedProduct2 = new DiscountedProduct("Творог", 150, 20);
            SearchEngine engine = new SearchEngine(2);
            engine.add(simpleProduct2);
            engine.add(discountedProduct2);

            Searchable result;
            Searchable result2;

            try {
                result = engine.findMostSuitableObject("Сыр");
                System.out.println(result.toString());
                result2 = engine.findMostSuitableObject("Пончик");
            } catch (BestResultNotFoundException e) { 
                System.err.println(e.getMessage());
            } 
        }
    }
}