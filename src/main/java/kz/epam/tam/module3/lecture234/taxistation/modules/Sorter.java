package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture234.taxistation.utils.FuelConsumptionComparator;

import java.util.Collections;

public class Sorter {

    public static TaxiStation sortCars(TaxiStation taxiStation){
        Collections.sort(taxiStation.getTaxis(), new FuelConsumptionComparator());
        return taxiStation;
    }
}
