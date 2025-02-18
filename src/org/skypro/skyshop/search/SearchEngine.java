package org.skypro.skyshop.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() { 
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String... query) { 
        Set<Searchable> found;

        found = searchables.stream()
            .filter(s -> Arrays.stream(query).anyMatch(q -> s.getSearchTerm(s.searchTerm(), q) > 0))
            .collect(Collectors.toCollection(TreeSet::new));

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
