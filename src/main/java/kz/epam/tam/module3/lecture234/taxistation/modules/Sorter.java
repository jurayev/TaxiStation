package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import kz.epam.tam.module3.lecture234.taxistation.utils.FuelConsumptionComparator;

import java.util.Collections;
import java.util.List;

public class Sorter {

    public static void sortCars(List<Car>carsList, List<String> sortedList){

        Collections.sort(carsList, new FuelConsumptionComparator());
        for (int i = 0; i < carsList.size(); i++) {
            sortedList.add("\n"+ carsList.get(i).getInfo());
            System.out.println(carsList.get(i).getInfo());
        }
    }
}
