package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;

import java.util.List;

public class Converter {

    public static void convertObjectsToString(List<Car> carsList,List<String> addedCarsList){

        for (int i = 0; i < carsList.size(); i++) {
            addedCarsList.add("\n" + carsList.get(i).getInfo());
            System.out.println(carsList.get(i).getInfo());
        }
    }
}
