package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<PassengerTaxi> {

    @Override
    public int compare(PassengerTaxi o1, PassengerTaxi o2){   ////ascending order
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }
}
