package kz.epam.tam.module3.lecture2.task1.runner;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.TaxiStation;
import kz.epam.tam.module3.lecture2.task1.utils.AddAVehicleToStation;
import kz.epam.tam.module3.lecture2.task1.utils.FindByParameter;
import kz.epam.tam.module3.lecture2.task1.utils.FuelConsumptionComparator;
import kz.epam.tam.module3.lecture2.task1.Van;

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
public class Runner {

    public static void main(String[] args){
        boolean repeat = true;

        List<Car> carList = new ArrayList<>();
        List<Van> vanList = new ArrayList<>();
        List<TaxiStation> vehicleList = new ArrayList<>();

        /*carList.add(new Car("bmw",3000,15,"vagon"));
        carList.add(new Car("VW",3000,17,"sedan"));
        carList.add(new Car("opel",3000,8,"vagon"));
        carList.add(new Car("toyta",3000,10,"hatchback"));
        carList.add(new Car("buick",3000,3,"hatchback"));

        vanList.add(new Van("bmw",3000,15,7,"diesel"));
        vanList.add(new Van("VW",3000,9,7,"gas"));
        vanList.add(new Van("opel",3000,9,9,"gas"));
        vanList.add(new Van("toyta",3000,10,9,"diesel"));
        vanList.add(new Van("buick",3000,8,12,"diesel"));

        vehicleList.add(new Car("bmw",1000,15,"vagon"));
        vehicleList.add(new Car("VW",1000,17,"sedan"));
        vehicleList.add(new Car("opel",1000,8,"sedan"));
        vehicleList.add(new Car("toyta",1000,10,"hatchback"));
        vehicleList.add(new Car("buick",1000,3,"hatchback"));
        vehicleList.add(new Van("van1",3000,15,5,"gas"));
        vehicleList.add(new Van("van2",3000,17,6,"gas"));
        vehicleList.add(new Van("van3",3000,8,5,"diesel"));
        vehicleList.add(new Van("van4",3000,10,6,"gas"));
        vehicleList.add(new Van("van5",3000,3,9,"gas"));*/

        while(repeat){
            System.out.println("1 - add new vehicle to station");
            System.out.println("2 - count taxi station budget");
            System.out.println("3 - show list of vehicle ordered by fuel consumption");
            System.out.println("4 - find a vehicle");
            System.out.println("0 - Exit");

            Scanner scanner = new Scanner (System.in);
            Scanner sc = new Scanner (System.in);
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
                         carList = AddAVehicleToStation.fillBaseCharacteristicsCar();
                         vehicleList.addAll(carList);
                         System.out.println("Completed!");
                     }
                     else if(type == 2){
                         vanList = AddAVehicleToStation.fillBaseCharacteristicsVan(scanner);
                         vehicleList.addAll(vanList);
                         System.out.println("Completed!");
                     }
                     else{System.out.println("Incorrect choice. Please try again!");
                     }


                    break;
                case 2:
                    System.out.println("Count taxi station budget");
                    long countCar = 0;
                    for (TaxiStation taxiPrice : vehicleList){
                        countCar +=  taxiPrice.getVehiclePrice();
                    }
                    System.out.println("Budget is " + countCar);
                    break;
                case 3:
                    System.out.println("Sort vehicle by fuel consumption");
                    Collections.sort(vehicleList, new FuelConsumptionComparator());
                    for (int i = 0; i < vehicleList.size(); i++){
                        System.out.println(vehicleList.get(i).getInfo());
                    }
                    break;
                case 4:
                    System.out.println("Find a vehicle by parameter.");
                    System.out.println("Choose type of vehicle");
                    System.out.println("1 - Car");
                    System.out.println("2 - Van");
                    int n = scanner.nextInt();
                    if (n == 1){
                        System.out.println("Type a car parameter to search.");
                        scanner.nextLine();
                        String param = scanner.nextLine();
                        FindByParameter.findACarByParameter(param,carList);
                    }else if (n == 2){
                        System.out.println("Type a van parameter to search.");
                        String param = scanner.nextLine();
                        FindByParameter.findAVanByParameter(param,vanList);
                    }
                    else{
                        System.out.println("Incorrect choice. Please try again!");
                    }
                    break;
                default:
                    System.out.println("Incorrect choice. Please try again!");
                    break;

            }
        }
    }
}
