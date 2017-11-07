package kz.epam.tam.module3.lecture2.task1.utils;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.Van;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAVehicleToStation {

    private static Scanner sc = new Scanner(System.in);

    public static List<Car> fillBaseCharacteristicsCar(Scanner scanner){
        List<Car> carList  = new ArrayList<>();
        System.out.println("Type vehicle model");
        String model = sc.nextLine();
        System.out.println("Type vehicle body type");
        String btype = sc.nextLine();
        System.out.println("Type vehicle price");
        long price = scanner.nextInt();
        System.out.println("Type vehicle fuel consumption");
        int cons = scanner.nextInt();
        carList.add(new Car(model,price,cons,btype));
        return carList;
    }
    public static List<Van> fillBaseCharacteristicsVan(Scanner scanner){
        List<Van> vanList  = new ArrayList<>();
        System.out.println("Type vehicle model");
        String model = sc.nextLine();
        System.out.println("Type vehicle price");
        long price = scanner.nextInt();
        System.out.println("Type vehicle fuel consumption");
        int cons = scanner.nextInt();
        System.out.println("Type vehicle fuel type");
        String ftype = sc.nextLine();
        System.out.println("Type vehicle number of seats");
        int nseats = scanner.nextInt();
        vanList.add(new Van(model,price,cons,nseats,ftype));
        return vanList;
    }
}
