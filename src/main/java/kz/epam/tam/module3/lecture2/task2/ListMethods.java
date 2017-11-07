package kz.epam.tam.module3.lecture2.task2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListMethods {


    public ArrayList<String> addElementsToArrayList() {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add("1" + i);
        }
        list.add("element to find");
        return list;
    }


    public LinkedList<String> addElementsToLinkedList() {

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add("1" + i);
        }
        list.add("element to find");
        return list;
    }
}
