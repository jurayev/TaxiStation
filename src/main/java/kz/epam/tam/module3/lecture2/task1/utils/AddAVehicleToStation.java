package kz.epam.tam.module3.lecture2.task1.utils;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.Van;
import kz.epam.tam.module3.lecture2.task1.data.reader.TxtFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAVehicleToStation {
    private  static final String PATH_TO_CAR_TXT = "src\\main\\resources\\car.txt";
    private  static final String PATH_TO_VAN_TXT = "src\\main\\resources\\van.txt";

    public static List<Car> fillBaseCharacteristicsCar(){
        List<Car> carList  = new ArrayList<>();
        TxtFileReader data = new TxtFileReader();
        String[][] info = data.readFile(PATH_TO_CAR_TXT);
        for(int i =0; i < info.length; i++){
            try {
                carList.add(new Car(info[i][0], Long.parseLong(info[i][1]), Integer.parseInt(info[i][2]), info[i][3]));
            }catch (NumberFormatException e){
                carList.add(new Car(info[i][0],Long.parseLong(info[i][1].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")),info[i][3]));
            }
        }
        return carList;
    }

    public static List<Van> fillBaseCharacteristicsVan(){
        TxtFileReader data = new TxtFileReader();
        List<Van> vanList  = new ArrayList<>();
        String[][] info = data.readFile(PATH_TO_VAN_TXT);
        for(int i =0; i < info.length; i++){
            try{
            vanList.add(new Van(info[i][0],Long.parseLong(info[i][1]),Integer.parseInt(info[i][2]),Integer.parseInt(info[i][3]),info[i][4]));
            }catch (NumberFormatException e){
                vanList.add(new Van(info[i][0],Long.parseLong(info[i][1].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][3].replaceAll("[^0-9]", "")), info[i][4]));
            }
        }
        return vanList;
    }
    /*public static List<Car> fillBaseCharacteristicsCar(){
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
    }*/
}
