package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2){   ////ascending order
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }
}
