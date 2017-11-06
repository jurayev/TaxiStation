package kz.epam.tam.module3.lecture2.utils;

import kz.epam.tam.module3.lecture2.TaxiStation;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<TaxiStation> {

    @Override
    public int compare(TaxiStation o1,TaxiStation o2){   ////ascending order
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }
}
