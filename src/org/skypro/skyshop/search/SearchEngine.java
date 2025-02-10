package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() { 
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String... query) { 
        Set<Searchable> found = new TreeSet<>();

        for (Searchable searchable : searchables) {
            for (String q : query) {
                if (searchable.getSearchTerm(searchable.searchTerm(), q) > 0) {
                    found.add(searchable);
                }
            }
        }

        return found;
    }

    public boolean add(Searchable searchable) { 
        return searchables.add(searchable);
    }

    public Searchable findMostSuitableObject(String search) throws BestResultNotFoundException {
        Searchable mostSuitable = null;
        int max = 0;
        Iterator<Searchable> iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable searchables = iterator.next();
            max = searchables.getSearchTerm(searchables.searchTerm(), search);
            if (max > 0) {
                mostSuitable = searchables;
            }
        }

        if (mostSuitable == null) {
            throw new BestResultNotFoundException("Ничего не найдено");
        }

        return mostSuitable;
    }
}
