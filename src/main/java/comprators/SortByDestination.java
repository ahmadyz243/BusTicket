package comprators;

import domain.ComService;

import java.util.Comparator;

public class SortByDestination implements Comparator<ComService> {


    @Override
    public int compare(ComService o1, ComService o2) {
        return o1.getDestinationCity().compareTo(o2.getDestinationCity());
    }
}
