package comprators;

import domain.ComService;

import java.util.Comparator;

public class SortByDate implements Comparator<ComService> {

    @Override
    public int compare(ComService o1, ComService o2) {
        return o1.getDateAndTimeOfDeparture().compareTo(o2.getDateAndTimeOfDeparture());
    }
}
