package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.List;

public class Counter {

    public static long countCarsPrice(List<Taxi> taxisList){
        long countPrice = 0;
        for (Taxi taxiPrice : taxisList) {
            countPrice += taxiPrice.getVehiclePrice();
        }
        return countPrice;
    }
}
