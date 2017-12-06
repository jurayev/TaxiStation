package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<Taxi> {

    @Override
    public int compare(Taxi o1, Taxi o2){   ////ascending order
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }
}
