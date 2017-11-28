package kz.epam.tam.module3.lecture234.taxistation.runner;

import kz.epam.tam.module3.lecture234.taxistation.workflow.TaxiStationCreator;



public class Runner {

    public static void main(String[] args) {

        TaxiStationCreator creator = new TaxiStationCreator();
        creator.createTaxiStation();
    }
}
