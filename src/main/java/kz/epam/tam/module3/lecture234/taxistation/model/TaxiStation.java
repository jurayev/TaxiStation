package kz.epam.tam.module3.lecture234.taxistation.model;

import java.util.ArrayList;
import java.util.List;

public class TaxiStation {

    private List<Taxi> taxis;


    public TaxiStation(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public String toString(){
        List<String> taxisList = new ArrayList<>();
        for (int i = 0; i < taxis.size(); i++) {
            taxisList.add("\n" + taxis.get(i).getInfo());
        }
        return taxisList.toString();
    }

}
