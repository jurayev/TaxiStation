package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;

import java.util.List;

public class Counter {

    public static long countCarsPrice(List<Car> carsList){
        long countCar = 0;
        for (Car taxiPrice : carsList) {
            countCar += taxiPrice.getVehiclePrice();
        }
        return countCar;
    }
}
