package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;

import java.util.List;

public class Counter {

    public static long countCarsPrice(List<PassengerTaxi> carsList){
        long countCar = 0;
        for (PassengerTaxi taxiPrice : carsList) {
            countCar += taxiPrice.getVehiclePrice();
        }
        return countCar;
    }
}
