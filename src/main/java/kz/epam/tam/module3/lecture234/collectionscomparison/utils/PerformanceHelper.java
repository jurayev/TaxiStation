package kz.epam.tam.module3.lecture234.collectionscomparison.utils;

public class PerformanceHelper {

    public void compareListsPerformance(){
        ListPerformance listPerformance = new ListPerformance();
        System.out.println("Performance measurement is started!");
        System.out.println("==================================================");
        System.out.println("Compare List's performance!");
        System.out.println("***Adding items to a list***");
        listPerformance.checkAdditionPerformanceOfArrayL();
        listPerformance.checkAdditionPerfomanceOfLinkedL();
        System.out.println("***Searching items in a list***");
        listPerformance.checkSearchPerformanceOfArrayL();
        listPerformance.checkSearchPerformanceOfLinkedL();
        System.out.println("***Deleting items from a list***");
        listPerformance.checkDeletionPerformanceOfArrayL();
        listPerformance.checkDeletionPerformanceOfLinkedL();
        System.out.println("==================================================");
    }
    public void compareSetsPerformance(){
        SetPerformance setPerformance = new SetPerformance();
        System.out.println("Compare Set's performance!");
        System.out.println("***Adding items to a set***");
        setPerformance.checkAdditionPerformanceOfHashSet();
        setPerformance.checkAdditionPerformanceOfTreeSet();
        System.out.println("***Searching items in a set***");
        setPerformance.checkSearchPerformanceOfHashSet();
        setPerformance.checkSearchPerformanceOfTreeSet();
        System.out.println("***Deleting items from a set***");
        setPerformance.checkDeletionPerformanceOfHashSet();
        setPerformance.checkDeletionPerformanceOfTreeSet();
        System.out.println("==================================================");
    }
    public void compareMapsPerformance(){
        MapPerformance mapPerformance = new MapPerformance();
        System.out.println("Compare Map's performance!");
        System.out.println("***Adding items in a map***");
        mapPerformance.checkAdditionPerformanceOfHashMap();
        mapPerformance.checkAdditionPerformanceOfTreeMap();
        System.out.println("***Searching items in a map***");
        mapPerformance.checkSearchPerformanceOfHashMap();
        mapPerformance.checkSearchPerformanceOfTreeMap();
        System.out.println("***Deleting items from a map***");
        mapPerformance.checkDeletionPerformanceOfHashMap();
        mapPerformance.checkDeletionPerformanceOfTreeMap();
        System.out.println("==================================================");
    }

}
