package kz.epam.tam.module3.lecture234.collectionscomparison.utils;

import kz.epam.tam.module3.lecture234.collectionscomparison.core.SetMethods;

class SetPerformance {

    private SetMethods set = new SetMethods();
    private long start;
    private long end;
    private long difference;

    void checkAdditionPerformanceOfHashSet() {
        start = System.currentTimeMillis();
        set.addElementsToHashSet();
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Addition performance of HashSet is: " + difference + " ms");
    }

    void checkAdditionPerformanceOfTreeSet() {
        start = System.currentTimeMillis();
        set.addElementsToTreeSet();
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Addition performance of TreeSet is: "+ difference +" ms");
    }
    void checkSearchPerformanceOfHashSet() {
        start = System.currentTimeMillis();
        set.addElementsToHashSet().contains("element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Search performance of HashSet is: " + difference + " ms");
    }
    void checkSearchPerformanceOfTreeSet() {
        start = System.currentTimeMillis();
        set.addElementsToTreeSet().contains("element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Search performance of TreeSet is: " + difference + " ms");
    }
    void checkDeletionPerformanceOfHashSet() {
        start = System.currentTimeMillis();
        set.addElementsToHashSet().remove("element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Deletion performance of HashSet is: " + difference + " ms");
    }
    void checkDeletionPerformanceOfTreeSet(){
        start = System.currentTimeMillis();
        set.addElementsToTreeSet().remove("element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Deletion performance of TreeSet is: " + difference + " ms");
    }
}
