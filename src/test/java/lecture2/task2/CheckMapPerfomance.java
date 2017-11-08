package lecture2.task2;


import org.testng.annotations.Test;


import java.util.HashMap;

import java.util.TreeMap;

public class CheckMapPerfomance {

    public static HashMap<Integer,String> addElementsToHashMap(){

        HashMap<Integer,String> map = new HashMap<>();
        for(int i = 0; i < 100; i++){
            map.put(i ,i + "1");
            System.out.println(map.values());
        }
        map.put(100,"element to find");
        System.out.println(map.values());
        return map;
    }


    public static TreeMap<Integer,String> addElementsToTreeMap(){

        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i = 0; i < 100; i++){
            map.put(i ,"1" + i);
            System.out.println(map.values());
        }
        map.put(100,"element to find");
        System.out.println(map.values());
        return map;
    }

    @Test
    public void addElementsToHashMapTest(){
        TreeMap<Integer,String> map = CheckMapPerfomance.addElementsToTreeMap();
    }

    /*public TreeMap<Integer,String> addElementsToTreeMap1(){

        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i = 0; i < 1000000; i++){
            map.put(i ,i + "1");
            System.out.println(map.values());
        }
        map.put(1000000,"element to find");
        return map;
    }

    public void printElements(TreeMap<Integer,String> map){
        for(int i = 0;i < map.size(); i++){
            System.out.println(map.);
        }
    }*/
}
