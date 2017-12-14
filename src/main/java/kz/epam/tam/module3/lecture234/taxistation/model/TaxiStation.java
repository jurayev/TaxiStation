package kz.epam.tam.module3.lecture234.taxistation.model;

import java.util.ArrayList;
import java.util.List;

public class TaxiStation {

    private List<Taxi> taxis = new ArrayList<>();


    public TaxiStation() {
    }
    public TaxiStation(List<Taxi> taxis) {
        this.taxis = taxis;
    }
    public void addTaxi(Taxi taxi){
        this.taxis.add(taxi);
    }
    public List<Taxi> getTaxis() {
        return taxis;
    }

    public String toString(){
        return taxis.toString();
    }

}
