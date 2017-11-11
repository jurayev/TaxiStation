package lecture2.sketch;

import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture2.taxistation.utils.FuelConsumptionComparator;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass {

    @Test
    public void carSortTest() {

        List<TaxiStation> vList = new ArrayList<>();

        vList.add(new Car("bmw",1000,15,"vagon"));
        vList.add(new Car("VW",1000,17,"sedan"));
        vList.add(new Car("opel",1000,8,"sedan"));
        vList.add(new Car("toyta",1000,10,"hatchback"));
        vList.add(new Car("buick",1000,3,"hatchback"));
        vList.add(new Van("van1",3000,15,5,"gas"));
        vList.add(new Van("van2",3000,17,6,"gas"));
        vList.add(new Van("van3",3000,8,5,"diesel"));
        vList.add(new Van("van4",3000,10,6,"gas"));
        vList.add(new Van("van5",3000,3,9,"gas"));

        System.out.println("list of cars ordered by fuel consumption");

        System.out.println("Before sort");

        for (int i = 0; i < vList.size(); i++){
            System.out.println(vList.get(i).getFuelConsumption());
        }

        System.out.println("After sort");
        Collections.sort(vList, new FuelConsumptionComparator());
        for (int i = 0; i < vList.size(); i++){
            System.out.println(vList.get(i).getFuelConsumption());
        }
    }


    @Test
    public void searchTest() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("bmw",3000,15,"sedan"));
        carList.add(new Car("VW",3000,17,"sedan"));
        carList.add(new Car("opel",1500,8,"hatchback"));
        carList.add(new Car("toyta",3000,10,"vagon"));
        carList.add(new Car("buick",3000,3,"hatchback"));
        //carList.add(new Van("van1",1000,3,5,"gas"));
        //carList.add(new Van("van2",3000,2,5,"gas"));
        ///FindByParameter.findACarByParameter("vagon", carList);
    }

    @Test
    public void counterTest(){
        List<TaxiStation> vList = new ArrayList<>();

        vList.add(new Car("bmw",1000,15,"vagon"));
        vList.add(new Car("VW",1000,17,"sedan"));
        vList.add(new Car("opel",1000,8,"sedan"));
        vList.add(new Car("toyta",1000,10,"hatchback"));
        vList.add(new Car("buick",1000,3,"hatchback"));
        vList.add(new Van("van1",1000,15,5,"gas"));
        vList.add(new Van("van2",1000,17,6,"gas"));
        vList.add(new Van("van3",1000,8,5,"gas"));
        vList.add(new Van("van4",1000,10,6,"gas"));
        vList.add(new Van("van5",1000,3,9,"gas"));
        System.out.println("count taxi station budget");
        long countCar = 0;
        for (TaxiStation taxiPrice : vList){
            countCar +=  taxiPrice.getVehiclePrice();
        }
        System.out.println("budget is " + countCar);
    }
    @Test
    public void listMethodsTest() {
        List<TaxiStation> cList = new ArrayList<>();
        List<TaxiStation> vList = new ArrayList<>();
        List<TaxiStation> newList = new ArrayList<>();

        cList.add(new Car("bmw",1000,15,"vagon"));
        cList.add(new Car("VW",1000,17,"sedan"));
        cList.add(new Car("opel",1000,8,"sedan"));
        cList.add(new Car("toyta",1000,10,"hatchback"));
        cList.add(new Car("buick",1000,3,"hatchback"));
        vList.add(new Van("van1",3000,15,5,"gas"));
        vList.add(new Van("van2",3000,17,6,"gas"));
        vList.add(new Van("van3",3000,8,5,"diesel"));
        vList.add(new Van("van4",3000,10,6,"gas"));
        vList.add(new Van("van5",3000,3,9,"gas"));
        newList.addAll(cList);
        for (int i = 0; i < newList.size(); i++){
            System.out.println(newList.get(i).getInfo());
        }
        System.out.println("----------------------------");
        newList.addAll(vList);
        for (int i = 0; i < newList.size(); i++){
            System.out.println(newList.get(i).getInfo());
        }




        }
    }

