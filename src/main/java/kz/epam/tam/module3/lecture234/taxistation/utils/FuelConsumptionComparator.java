package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2){   ////ascending order
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }
}
