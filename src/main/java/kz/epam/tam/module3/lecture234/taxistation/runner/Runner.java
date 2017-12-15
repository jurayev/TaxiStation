package kz.epam.tam.module3.lecture234.taxistation.runner;

import kz.epam.tam.module3.lecture234.taxistation.workflow.TaxiStationManipulator;



public class Runner {

    public static void main(String[] args) {

        TaxiStationManipulator manipulator = new TaxiStationManipulator();
        manipulator.manipulateTaxiStationMainFeatures();
    }
}
