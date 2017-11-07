package kz.epam.tam.module3.lecture2.task2;

import java.util.HashMap;
import java.util.TreeMap;

public class MapMethods {

    public HashMap<Integer,String> addElementsToHashMap(){

        HashMap<Integer,String> map = new HashMap<>();
        for(int i = 0; i < 1000000; i++){
            map.put(i ,i + "1");
        }
        map.put(1000000,"element to find");
        return map;
    }


    public TreeMap<Integer,String> addElementsToTreeMap(){

        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i = 0; i < 1000000; i++){
            map.put(i ,i + "1");
        }
        map.put(1000000,"element to find");
        return map;
    }
}
