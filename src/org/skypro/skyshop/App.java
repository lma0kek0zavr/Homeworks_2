package org.skypro.skyshop;

import java.util.Set;

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