package lecture2.task2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckListPerfomance {


    @Test
    public void addElementsToArrayListTest(){

        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i < 1000000; i++){
            list.add("1" + i);
        }
        Assert.assertEquals(list.size(),1000000);
    }

    @Test
    public void addElementsToLinkedListTest(){

        LinkedList<String> list = new LinkedList<>();
        for(int i =0; i < 1000000; i++){
            list.add("1" + i);
        }
        Assert.assertEquals(list.size(),1000000);
    }

    public static ArrayList<String> addElementsToArrayList(){

        ArrayList<String> alist = new ArrayList<>();
        for(int i =0; i < 1000000; i++){
            alist.add("1" + i);
        }
        alist.add("element to find");
        return alist;
    }
    public static LinkedList<String> addElementsToLinkedList(){

        LinkedList<String> llist = new LinkedList<>();
        for(int i =0; i < 1000000; i++){
            llist.add("1" + i);
        }
        llist.add("element to find");
        return llist;
    }

    @Test
    public void findElementArrayListTest(){

        Assert.assertEquals(CheckListPerfomance.addElementsToArrayList().get(1000000),"element to find");
    }

    @Test
    public void findElementLinkedListTest(){

        Assert.assertEquals(CheckListPerfomance.addElementsToLinkedList().get(1000000),"element to find");
    }

    @Test
    public void deleteElementArrayListTest(){
            ArrayList<String> list = CheckListPerfomance.addElementsToArrayList();
            Assert.assertEquals(list.remove(1000000),"element to find");
            Assert.assertEquals(list.size(),1000000);
        }

    @Test
    public void deleteElementLinkedListTest(){
        LinkedList<String> list = CheckListPerfomance.addElementsToLinkedList();
        Assert.assertEquals(list.remove(1000000),"element to find");
        Assert.assertEquals(list.size(),1000000);
    }


}
