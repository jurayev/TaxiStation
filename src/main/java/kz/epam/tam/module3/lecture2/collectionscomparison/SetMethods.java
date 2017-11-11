package kz.epam.tam.module3.lecture2.collectionscomparison;

import java.util.HashSet;
import java.util.TreeSet;

public class SetMethods {

    public HashSet<String> addElementsToHashSet(){

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 1000000; i++){
            set.add("1" + i);
        }
        set.add("element to find");
        return set;
    }

    public TreeSet<String> addElementsToTreeSet(){

        TreeSet<String> set = new TreeSet<>();
        for(int i = 0; i < 1000000; i++){
            set.add("1" + i);
        }
        set.add("element to find");
        return set;
    }
}
