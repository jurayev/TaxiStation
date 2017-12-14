package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;

import java.util.List;

public class Counter {

    public static long countCarsPrice(TaxiStation taxiStation){
        long countPrice = 0;
        for (Taxi taxiPrice : taxiStation.getTaxis()) {
            countPrice += taxiPrice.getVehiclePrice();
        }
        return countPrice;
    }
}
