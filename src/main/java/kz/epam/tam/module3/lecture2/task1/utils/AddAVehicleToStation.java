package kz.epam.tam.module3.lecture2.task1.utils;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.Van;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddAVehicleToStation {

    private static Scanner sc = new Scanner(System.in);

    public static List<Car> fillBaseCharacteristicsCar(){
        Integer price = null;
        Integer cons = null;
        List<Car> carList  = new ArrayList<>();
        System.out.println("Type vehicle model");
        String model = sc.nextLine();
        System.out.println("Type vehicle body type");
        String btype = sc.nextLine();
        while(price == null || cons == null ){
            try{
                if(price == null){
                    System.out.println("Type vehicle price");
                    price = new Scanner(System.in).nextInt();
                    System.out.println("Type vehicle fuel consumption");
                    cons = new Scanner(System.in).nextInt();
                }
                else{
                    System.out.println("Type vehicle fuel consumption");
                    cons = new Scanner(System.in).nextInt();
                }

            }catch(InputMismatchException e){
                System.out.println("Oops,You have typed incorrect data type!Data must be only numeric");
            }
        }
        carList.add(new Car(model,price,cons,btype));
        return carList;
    }
    public static List<Van> fillBaseCharacteristicsVan(Scanner scanner){
        Integer price = null;
        Integer cons = null;
        List<Van> vanList  = new ArrayList<>();
        System.out.println("Type vehicle model");
        String model = sc.nextLine();
        try {
            System.out.println("Type vehicle price");
            price = scanner.nextInt();
            System.out.println("Type vehicle fuel consumption");
            cons = scanner.nextInt();
        }catch (InputMismatchException e){

        }
        System.out.println("Type vehicle fuel type");
        String ftype = sc.nextLine();
        System.out.println("Type vehicle number of seats");
        int nseats = scanner.nextInt();
        vanList.add(new Van(model,price,cons,nseats,ftype));
        return vanList;
    }
}
