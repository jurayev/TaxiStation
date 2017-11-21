package kz.epam.tam.module3.lecture234.collectionscomparison.runner;

import kz.epam.tam.module3.lecture234.collectionscomparison.utils.PerformanceHelper;

public class Runner {
    public static void main(String[] args){

        PerformanceHelper performance = new PerformanceHelper();
        performance.compareListsPerformance();
        performance.compareSetsPerformance();
        performance.compareMapsPerformance();
    }
}
