package lecture2.sketch;/*package kz.epam.tam.module3.lecture2.runner;

import kz.epam.tam.module3.lecture2.Car;
import kz.epam.tam.module3.lecture2.TaxiStation;
import kz.epam.tam.module3.lecture2.utils.FuelConsumptionComparator;
import kz.epam.tam.module3.lecture2.utils.FuelConsumptionComparatorVan;
import kz.epam.tam.module3.lecture2.Van;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TO DO
/*Определить иерархию легковых автомобилей.
Создать таксопарк.
Посчитать стоимость автопарка.
Провести сортировку автомобилей парка по расходу топлива.
Найти автомобиль в компании, соответствующий заданному диапазону параметров.*/
/*public class Runner {

    public static void main(String[] args){
        boolean repeat = true;

        /*Car car = new Car(2);
        Van van = new Van(2);
        System.out.println(Van.TYPE);*/
/*
        List<Car> carList = new ArrayList<>();
        List<Van> vanList = new ArrayList<>();

        carList.add(new Car("bmw",3000,15));
        carList.add(new Car("VW",3000,17));
        carList.add(new Car("opel",3000,8));
        carList.add(new Car("toyta",3000,10));
        carList.add(new Car("buick",3000,3));

        vanList.add(new Van("bmw",3000,15));
        vanList.add(new Van("VW",3000,16));
        vanList.add(new Van("opel",3000,9));
        vanList.add(new Van("toyta",3000,10));
        vanList.add(new Van("buick",3000,8));
        while(repeat){
            System.out.println("1 - add new vehicle to station");
            System.out.println("2 - count taxi station budget");
            System.out.println("3 - show list of vehicle ordered by fuel consumption");
            System.out.println("4 - find a vehicle");
            System.out.println("0 - Exit");

            Scanner scanner = new Scanner (System.in);
            int choice = scanner.nextInt();

            switch (choice){
                case 0:
                    repeat = false;
                    System.out.println("Exit");
                    break;
                case 1:
                    System.out.println("What type of vehicle would you like to add?");
                    System.out.println("1 - Car");
                    System.out.println("2 - Van");
                    int type = scanner.nextInt();
                     if (type == 1){
                         System.out.println("Type vehicle model");
                         String model = scanner.nextLine();
                         System.out.println("Type vehicle price");
                         long price = scanner.nextInt();
                         System.out.println("Type vehicle fuel consumption");
                         int cons = scanner.nextInt();
                         carList.add(new Car(model,price,cons));
                     }
                     else if(type == 2){
                         System.out.println("Type vehicle model");
                         String model = scanner.nextLine();
                         System.out.println("Type vehicle price");
                         long price = scanner.nextInt();
                         System.out.println("Type vehicle fuel consumption");
                         int cons = scanner.nextInt();
                         vanList.add(new Van(model,price,cons));
                     }
                     else{System.out.println("Incorrect choice. Please try again!");
                     }
                    break;
                case 2:
                    System.out.println("count taxi station budget");
                    long countCar = 0;
                    long countVan = 0;
                    for (Car taxiPrice : carList){
                        countCar +=  taxiPrice.getVehiclePrice();
                    }
                    System.out.println("budget is " + countCar);
                    for (Van taxiPrice1 : vanList){
                        countVan += taxiPrice1.getVehiclePrice();
                    }
                    System.out.println("budget is " + countVan);
                    long finalcount = countCar + countVan;
                    System.out.println("final budget is " + finalcount);
                    break;
                case 3:
                    System.out.println("sort vehicle by fuel consumption");
                    System.out.println("Choose type of vehicle");
                    System.out.println("1 - Car");
                    System.out.println("2 - Van");
                    int t = scanner.nextInt();

                    if (t == 1){
                        Collections.sort(carList, new FuelConsumptionComparator());
                        System.out.println(Car.TYPE + ":");
                        for (int i = 0; i < carList.size(); i++) {
                            System.out.println(carList.get(i).getModel() + " " + carList.get(i).getFuelConsumption());
                        }
                    }else if(t == 2){
                        Collections.sort(vanList, new FuelConsumptionComparatorVan());
                        System.out.println(Van.TYPE + ":");
                        for (int i = 0; i < vanList.size(); i++){
                            System.out.println(vanList.get(i).getModel() + " " + vanList.get(i).getFuelConsumption());
                        }
                    }else{System.out.println("Incorrect choice. Please try again!");
                        }
                    break;
                case 4:
                    System.out.println("find a vehicle by parameter.");
                    System.out.println("Choose type of vehicle");
                    System.out.println("1 - Car");
                    System.out.println("2 - Van");
                    int m = scanner.nextInt();

                    if (m == 1){
                        System.out.println("Type vehicle parameter to search.");

                    }else if (m == 2){
                        System.out.println("Type vehicle parameter to search.");
                    }
                    default:
                        System.out.println("Incorrect choice. Please try again!");


            }
        }
    }
}*/
