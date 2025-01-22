package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) { 
        searchables = new Searchable[size];
    }

    public Searchable[] search(String... query) { 
        Searchable[] found = new Searchable[5];
        int count = 0;

        for (int i = 0; i < searchables.length; i++) { 
            for (int j = 0; j < query.length; j++) {
                if (count == 5) { break; }
                if (searchables[i] != null) {
                    if (searchables[i].searchTerm().toLowerCase().contains(query[j].toLowerCase())) {
                        found[count] = searchables[i];
                        count++;
                    }
                }
            }
        }

        return found;
    }

    public boolean add(Searchable searchable) { 
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return true;
            }
        }
        return false;
    }

    public Searchable findMostSuitableObject(String search) throws BestResultNotFoundException {
        Searchable mostSuitable = null;
        int max = 0;
        for (int i = 0; i < searchables.length; i++) { 
            max = searchables[i].getSearchTerm(searchables[i].searchTerm(), search);
            if (max > 0) {
                mostSuitable = searchables[i];
            }
        }

        if (mostSuitable == null) {
            throw new BestResultNotFoundException("Ничего не найдено");
        }

        return mostSuitable;
    }
}
