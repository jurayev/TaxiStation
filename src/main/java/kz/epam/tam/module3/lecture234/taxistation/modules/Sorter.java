package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.utils.FuelConsumptionComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {

    public static List<String> sortCars(List<Taxi> taxiList){
        List<String> sortedList = new ArrayList<>();
        Collections.sort(taxiList, new FuelConsumptionComparator());
        for (int i = 0; i < taxiList.size(); i++) {
            sortedList.add("\n"+ taxiList.get(i).getInfo());
        }
        return sortedList;
    }
}
