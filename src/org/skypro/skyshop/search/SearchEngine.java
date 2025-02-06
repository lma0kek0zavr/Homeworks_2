package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() { 
        searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String query) { 
        Map<String, Searchable> found = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm(searchable.searchTerm(), query) > 0) {
                found.put(searchable.searchTerm(), searchable);
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
