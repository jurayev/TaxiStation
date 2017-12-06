package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.List;

public class Counter {

    public static long countCarsPrice(List<Taxi> carsList){
        long countCar = 0;
        for (Taxi taxiPrice : carsList) {
            countCar += taxiPrice.getVehiclePrice();
        }
        return countCar;
    }
}
