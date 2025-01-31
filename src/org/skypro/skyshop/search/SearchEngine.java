package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() { 
        searchables = new ArrayList<>();
    }

    public List<Searchable> search(String query) { 
        List<Searchable> found = new ArrayList<>();
        Iterator<Searchable> iterator = searchables.iterator();

        while (iterator.hasNext()) { 
            Searchable searchable = iterator.next();
            int count = searchable.getSearchTerm(searchable.searchTerm(), query);
            if (count > 0) {
                found.add(searchable);
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
