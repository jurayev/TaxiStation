package kz.epam.tam.module3.lecture2.task1.runner;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.TaxiStation;
import kz.epam.tam.module3.lecture2.task1.data.writer.TxtFileWriter;
import kz.epam.tam.module3.lecture2.task1.utils.AddAVehicleToStation;
import kz.epam.tam.module3.lecture2.task1.utils.FindByParameter;
import kz.epam.tam.module3.lecture2.task1.utils.FuelConsumptionComparator;
import kz.epam.tam.module3.lecture2.task1.Van;

import java.util.*;

/*TO DO
Определить иерархию легковых автомобилей.
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
        List<String> sortedByConsumptionList = new ArrayList<>();
        TxtFileWriter writer = new TxtFileWriter();
        long countCar = 0;
        String search = "Search result is empty";

        while(repeat){
            try{
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
                        writer.writeToFile(countCar, sortedByConsumptionList, search);
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
                             vanList = AddAVehicleToStation.fillBaseCharacteristicsVan();
                             vehicleList.addAll(vanList);
                             System.out.println("Completed!");
                         }
                         else{System.out.println("Incorrect choice. Please try again!");
                         }
                        break;
                    case 2:
                        System.out.println("Count taxi station budget");
                        for (TaxiStation taxiPrice : vehicleList){
                            countCar +=  taxiPrice.getVehiclePrice();
                        }
                        System.out.println("Budget is " + countCar);
                        break;
                    case 3:
                        System.out.println("Sort vehicle by fuel consumption");
                        Collections.sort(vehicleList, new FuelConsumptionComparator());
                        for (int i = 0; i < vehicleList.size(); i++){
                            sortedByConsumptionList.add("\n" + vehicleList.get(i).getInfo());
                            System.out.println(vehicleList.get(i).getInfo());
                        }
                        System.out.println("Completed!");
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
                            search = FindByParameter.findACarByParameter(param,carList);
                            System.out.println("Completed!");
                        }else if (n == 2){
                            System.out.println("Type a van parameter to search.");
                            scanner.nextLine();
                            String param = scanner.nextLine();
                            search = FindByParameter.findAVanByParameter(param,vanList);
                            System.out.println("Completed!");
                        }
                        else{
                            System.out.println("Incorrect choice. Please try again!");
                        }
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again!");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Oops, invalid data. Data must be only numeric. Please try again!");
            }catch (NullPointerException npe){
                System.out.println("Oops, number of vehicle you try to add is more than resource file contains. Please try again!");
            }
            catch (NegativeArraySizeException naze){
                System.out.println("Oops, negative number is prohibited. Please try again!");
            }

        }
    }
}
