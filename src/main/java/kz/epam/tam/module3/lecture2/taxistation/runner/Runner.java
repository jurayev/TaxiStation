package kz.epam.tam.module3.lecture2.taxistation.runner;

import kz.epam.tam.module3.lecture2.taxistation.data.readers.DBReader;
import kz.epam.tam.module3.lecture2.taxistation.data.readers.JSONReader;
import kz.epam.tam.module3.lecture2.taxistation.data.readers.XMLReader;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture2.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture2.taxistation.exception.EmptySearchResultException;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidDataException;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidListSizeException;
import kz.epam.tam.module3.lecture2.taxistation.utils.AddAVehicleFromTXT;
import kz.epam.tam.module3.lecture2.taxistation.utils.FindByParameter;
import kz.epam.tam.module3.lecture2.taxistation.utils.FuelConsumptionComparator;

import java.util.*;

public class Runner {

    public static void main(String[] args){
        boolean repeat = true;

        List<Car> carList = new ArrayList<>();
        List<TaxiStation> vehicleList = new ArrayList<>();
        List<String> sortedByConsumptionList = new ArrayList<>();
        long countCar = 0;
        String search = "Search result is empty";
        Scanner scanner = new Scanner (System.in);

        while(repeat){
            try{
                System.out.println("1 - add new vehicle to station");
                System.out.println("2 - count taxi station budget");
                System.out.println("3 - show list of vehicle ordered by fuel consumption");
                System.out.println("4 - find a vehicle");
                System.out.println("0 - Exit");

                int choice = scanner.nextInt();

                switch (choice){
                    case 0:
                        repeat = false;
                        TxtFileWriter writer = new TxtFileWriter();
                        writer.writeToFile(countCar, sortedByConsumptionList, search);
                        System.out.println("Exit");
                        break;
                    case 1:
                        System.out.println("Choose a reader");
                        System.out.println("1 - TXT");
                        System.out.println("2 - XML");
                        System.out.println("3 - JSON");
                        System.out.println("4 - DB");
                        int reader = scanner.nextInt();
                        if(reader == 1){
                            AddAVehicleFromTXT vehicle = new AddAVehicleFromTXT();
                            carList = vehicle.fillBaseCharacteristicsCar();
                            vehicleList.addAll(carList);
                        }else if(reader == 2){
                            XMLReader xml = new XMLReader();
                            carList = xml.readData();
                            vehicleList.addAll(carList);
                        }else if(reader == 3){
                            JSONReader vehicle = new JSONReader();
                            carList = vehicle.readData();
                            vehicleList.addAll(carList);
                        }else if(reader == 4){
                            DBReader vehicle = new DBReader();
                            carList = vehicle.readData();
                            vehicleList.addAll(carList);
                        }else{
                            System.out.println("Incorrect choice. Please try again!");
                        }
                        System.out.println("Completed!");
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
                        System.out.println("Type a car parameter to search.");
                        scanner.nextLine();
                        String param = scanner.nextLine();
                        search = FindByParameter.findACarByParameter(param,carList);
                        System.out.println("Completed!");
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again!");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Oops, invalid data. Data must be only numeric. Please try again!");
            }catch (NullPointerException npe){
                System.out.println("Oops, number of vehicle you try to add is more than resource file contains. Please try again!");
            }catch (NegativeArraySizeException e){
                System.out.println("Oops, negative number is prohibited. Please try again!");
            }catch (InvalidListSizeException e){
                System.out.println(e.getMessage() + " Actual number of fields is " + e.getExceptionCause() + ". Please check an input data and try again!");
            }catch (EmptySearchResultException e){
                System.out.println(e.getMessage());
            }catch (InvalidDataException ide){
                System.out.println(ide.getMessage() + "Found: price is " + ide.getExceptionPrice() + ", consumption is " + ide.getExceptionConsumption());
            }
        }
    }
}
