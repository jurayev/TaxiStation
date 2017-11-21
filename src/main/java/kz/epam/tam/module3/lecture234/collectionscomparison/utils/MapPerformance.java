package kz.epam.tam.module3.lecture234.collectionscomparison.utils;

import kz.epam.tam.module3.lecture234.collectionscomparison.core.MapMethods;

class MapPerformance {

    private MapMethods map = new MapMethods();
    private long start;
    private long end;
    private long difference;

    void checkAdditionPerformanceOfHashMap() {
        start = System.currentTimeMillis();
        map.addElementsToHashMap();
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Addition performance of HashMap is: " + difference + " ms");
    }

    void checkAdditionPerformanceOfTreeMap() {
        start = System.currentTimeMillis();
        map.addElementsToTreeMap();
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Addition performance of TreeMap is: " + difference + " ms");
    }

    void checkSearchPerformanceOfHashMap() {
        start = System.currentTimeMillis();
        map.addElementsToHashMap().containsValue("element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Search performance of HashMap is: " + difference + " ms");
    }

    void checkSearchPerformanceOfTreeMap() {
        start = System.currentTimeMillis();
        map.addElementsToTreeMap().containsValue("element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Search performance of TreeMap is: " + difference + " ms");
    }

    void checkDeletionPerformanceOfHashMap() {
        start = System.currentTimeMillis();
        map.addElementsToHashMap().remove(1000000, "element to find");
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Performance of HashMap is: " + difference + " ms");
    }

    void checkDeletionPerformanceOfTreeMap() {
        start = System.currentTimeMillis();
        map.addElementsToTreeMap().remove(1000000, "element to find");
        end= System.currentTimeMillis();
        difference = end - start;
        System.out.println("Performance of TreeMap is: " + difference + " ms");
    }
}
