package comprators;

import domain.ComService;

import java.util.Comparator;

public class SortByCompany implements Comparator<ComService> {
    @Override
    public int compare(ComService o1, ComService o2) {
        return o1.getCompany().getName().compareTo(o2.getCompany().getName());
    }
}

