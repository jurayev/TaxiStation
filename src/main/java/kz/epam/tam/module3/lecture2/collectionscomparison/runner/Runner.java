package kz.epam.tam.module3.lecture2.collectionscomparison.runner;

import kz.epam.tam.module3.lecture2.collectionscomparison.ListMethods;
import kz.epam.tam.module3.lecture2.collectionscomparison.MapMethods;
import kz.epam.tam.module3.lecture2.collectionscomparison.SetMethods;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        boolean repeat = true;
        System.out.println("Performance measurement is started!");
        Scanner scanner = new Scanner(System.in);
        while (repeat){
            System.out.println("Choose an item from the menu:");
            System.out.println("1 - Check performance of Lists");
            System.out.println("2 - Check performance of Sets");
            System.out.println("3 - Check performance of Maps");
            System.out.println("0 - Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    repeat = false;
                    System.out.println("Exit");
                    break;
                case 1:
                    ListMethods list = new ListMethods();
                    System.out.println("Compare Lists performance!");
                    System.out.println("Pick one from the menu");
                    System.out.println("1 - Adding items to a list");
                    System.out.println("2 - Searching items in a list");
                    System.out.println("3 - Deleting items from a list");
                    int listpicker = scanner.nextInt();
                    if(listpicker == 1) {
                        System.out.println("Adding items!");
                        long startOfArrayList = System.currentTimeMillis();
                        list.addElementsToArrayList();
                        long endOfArrayList = System.currentTimeMillis();
                        long differenceOfArrayList = endOfArrayList - startOfArrayList;
                        System.out.println("Performance of ArrayList is: " + differenceOfArrayList + " ms");

                        long startOfLinkedList = System.currentTimeMillis();
                        list.addElementsToLinkedList();
                        long endOfLinkedList = System.currentTimeMillis();
                        long differenceOfLinkedList = endOfLinkedList - startOfLinkedList;
                        System.out.println("Performance of LinkedList is: " + differenceOfLinkedList + " ms");
                    }else if(listpicker == 2){
                        System.out.println("Searching items!");
                        long startOfArrayList = System.currentTimeMillis();
                        String resultA = list.addElementsToArrayList().get(1000000);
                        long endOfArrayList = System.currentTimeMillis();
                        long differenceOfArrayList = endOfArrayList - startOfArrayList;
                        System.out.println("Performance of ArrayList is: " + differenceOfArrayList + " ms");

                        long startOfLinkedList = System.currentTimeMillis();
                        String resultB = list.addElementsToLinkedList().get(1000000);
                        long endOfLinkedList = System.currentTimeMillis();
                        long differenceOfLinkedList = endOfLinkedList - startOfLinkedList;
                        System.out.println("Performance of LinkedList is: " + differenceOfLinkedList + " ms");
                    }
                    else if(listpicker == 3){
                        System.out.println("Deleting items!");
                        long startOfArrayList = System.currentTimeMillis();
                        String resultA = list.addElementsToArrayList().remove(1000000);
                        long endOfArrayList = System.currentTimeMillis();
                        long differenceOfArrayList = endOfArrayList - startOfArrayList;
                        System.out.println("Performance of ArrayList is: " + differenceOfArrayList + " ms");

                        long startOfLinkedList = System.currentTimeMillis();
                        String resultB = list.addElementsToLinkedList().remove(1000000);
                        long endOfLinkedList = System.currentTimeMillis();
                        long differenceOfLinkedList = endOfLinkedList - startOfLinkedList;
                        System.out.println("Performance of LinkedList is: " + differenceOfLinkedList + " ms");
                    }
                    else{
                        System.out.println("Incorrect choice,Try again!");
                    }
                    break;
                case 2:
                    System.out.println("Compare Sets performance!");
                    System.out.println("Pick one from the menu");
                    System.out.println("1 - Adding items to a set");
                    System.out.println("2 - Searching items in a set");
                    System.out.println("3 - Deleting items from a set");
                    SetMethods set = new SetMethods();
                    int setpicker = scanner.nextInt();
                    if(setpicker == 1) {
                        System.out.println("Adding items!");
                        long startOfHashSet = System.currentTimeMillis();
                        set.addElementsToHashSet();
                        long endOfHashSet = System.currentTimeMillis();
                        long differenceOfHashSet = endOfHashSet - startOfHashSet;
                        System.out.println("Performance of HashSet is: " + differenceOfHashSet + " ms");

                        long startOfTreeSet = System.currentTimeMillis();
                        set.addElementsToTreeSet();
                        long endOfTreeSet = System.currentTimeMillis();
                        long differenceOfTreeSet = endOfTreeSet - startOfTreeSet;
                        System.out.println("Performance of TreeSet is: " + differenceOfTreeSet + " ms");
                    }else if(setpicker == 2){
                        System.out.println("Searching items!");
                        long startOfHashSet = System.currentTimeMillis();
                        boolean resultA = set.addElementsToHashSet().contains("element to find");
                        long endOfHashSet = System.currentTimeMillis();
                        long differenceOfHashSet = endOfHashSet - startOfHashSet;
                        System.out.println("Performance of HashSet is: " + differenceOfHashSet + " ms");

                        long startOfTreeSet = System.currentTimeMillis();
                        boolean resultB = set.addElementsToTreeSet().contains("element to find");
                        long endOfTreeSet = System.currentTimeMillis();
                        long differenceOfTreeSet = endOfTreeSet - startOfTreeSet;
                        System.out.println("Performance of TreeSet is: " + differenceOfTreeSet + " ms");
                    }
                    else if(setpicker == 3){
                        System.out.println("Deleting items!");
                        long startOfHashSet = System.currentTimeMillis();
                        boolean resultA = set.addElementsToHashSet().remove("element to find");
                        long endOfHashSet = System.currentTimeMillis();
                        long differenceOfHashSet = endOfHashSet - startOfHashSet;
                        System.out.println("Performance of HashSet is: " + differenceOfHashSet + " ms");

                        long startOfTreeSet = System.currentTimeMillis();
                        boolean resultB = set.addElementsToTreeSet().remove("element to find");
                        long endOfTreeSet = System.currentTimeMillis();
                        long differenceOfTreeSet = endOfTreeSet - startOfTreeSet;
                        System.out.println("Performance of TreeSet is: " + differenceOfTreeSet + " ms");
                    }
                    else{
                        System.out.println("Incorrect choice,Try again!");
                    }
                    break;
                case 3:
                    System.out.println("Compare Maps performance!");
                    System.out.println("Pick one from the menu:");
                    System.out.println("1 - Adding items to a map");
                    System.out.println("2 - Searching items in a map");
                    System.out.println("3 - Deleting items from a map");
                    MapMethods map = new MapMethods();
                    int mappicker = scanner.nextInt();
                    if(mappicker == 1) {
                        System.out.println("Adding items!");
                        long startOfHashMap = System.currentTimeMillis();
                        map.addElementsToHashMap();
                        long endOfHashMap = System.currentTimeMillis();
                        long differenceOfHashMap = endOfHashMap - startOfHashMap;
                        System.out.println("Performance of HashMap is: " + differenceOfHashMap + " ms");

                        long startOfTreeMap = System.currentTimeMillis();
                        map.addElementsToTreeMap();
                        long endOfTreeMap = System.currentTimeMillis();
                        long differenceOfTreeMap = endOfTreeMap - startOfTreeMap;
                        System.out.println("Performance of TreeMap is: " + differenceOfTreeMap + " ms");
                    }else if(mappicker == 2){
                        System.out.println("Searching items!");
                        long startOfHashMap = System.currentTimeMillis();
                        boolean resultA = map.addElementsToHashMap().containsValue("element to find");
                        long endOfHashMap = System.currentTimeMillis();
                        long differenceOfHashMap = endOfHashMap - startOfHashMap;
                        System.out.println("Performance of HashMap is: " + differenceOfHashMap + " ms");

                        long startOfTreeMap = System.currentTimeMillis();
                        boolean resultB = map.addElementsToTreeMap().containsValue("element to find");
                        long endOfTreeMap = System.currentTimeMillis();
                        long differenceOfTreeMap = endOfTreeMap - startOfTreeMap;
                        System.out.println("Performance of TreeMap is: " + differenceOfTreeMap + " ms");
                    }
                    else if(mappicker == 3){
                        System.out.println("Deleting items!");
                        long startOfHashMap = System.currentTimeMillis();
                        boolean resultA = map.addElementsToHashMap().remove(1000000,"element to find");
                        long endOfHashMap = System.currentTimeMillis();
                        long differenceOfHashMap = endOfHashMap - startOfHashMap;
                        System.out.println("Performance of HashMap is: " + differenceOfHashMap + " ms");

                        long startOfTreeMap = System.currentTimeMillis();
                        boolean resultB = map.addElementsToTreeMap().remove(1000000,"element to find");
                        long endOfTreeMap = System.currentTimeMillis();
                        long differenceOfTreeMap = endOfTreeMap - startOfTreeMap;
                        System.out.println("Performance of TreeMap is: " + differenceOfTreeMap + " ms");
                    }
                    else{
                        System.out.println("Incorrect choice,Try again!");
                    }
                    break;
                default:
                    System.out.println("Incorrect choice,Try again!");
            }

        }
    }
}
