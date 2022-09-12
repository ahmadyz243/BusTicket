package comprators;

import domain.ComService;

import java.util.Comparator;

public class SortByOrigin implements Comparator<ComService> {
    @Override
    public int compare(ComService o1, ComService o2) {
        return o1.getOriginCity().compareTo(o2.getOriginCity());
    }
}
