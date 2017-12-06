package kz.epam.tam.module3.lecture234.taxistation.modules;


import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.List;

public class Converter {

    public static void convertObjectsToString(List<Taxi> taxiList, List<String> addedCarsList){

        for (int i = 0; i < taxiList.size(); i++) {
            addedCarsList.add("\n" + taxiList.get(i).getInfo());
        }
    }
}
