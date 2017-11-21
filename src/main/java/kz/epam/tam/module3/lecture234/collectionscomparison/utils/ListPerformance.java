package kz.epam.tam.module3.lecture234.collectionscomparison.utils;

import kz.epam.tam.module3.lecture234.collectionscomparison.core.ListMethods;

class ListPerformance {

    private ListMethods list = new ListMethods();
    private long start;
    private long end;
    private long difference;

     void checkAdditionPerformanceOfArrayL(){
        start = System.currentTimeMillis();
        list.addElementsToArrayList();
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Addition performance of ArrayList is: " + difference + " ms");
    }

    void checkAdditionPerfomanceOfLinkedL(){
        start = System.currentTimeMillis();
        list.addElementsToLinkedList();
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Addition performance of LinkedList is: " + difference + " ms");
    }

    void checkSearchPerformanceOfArrayL(){
        start = System.currentTimeMillis();
        list.addElementsToArrayList().get(1000000);
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Search performance of ArrayList is: " + difference + " ms");
    }

    void checkSearchPerformanceOfLinkedL(){
        start = System.currentTimeMillis();
        list.addElementsToLinkedList().get(1000000);
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Search performance of LinkedList is: " + difference + " ms");
    }
    void checkDeletionPerformanceOfArrayL(){
        start = System.currentTimeMillis();
        list.addElementsToArrayList().remove(1000000);
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Deletion performance of ArrayList is: " + difference + " ms");
    }
    void checkDeletionPerformanceOfLinkedL(){
        start = System.currentTimeMillis();
        list.addElementsToLinkedList().remove(1000000);
        end = System.currentTimeMillis();
        difference = end - start;
        System.out.println("Deletion performance of LinkedList is: " + difference + " ms");
    }
}
