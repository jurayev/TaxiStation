package kz.epam.tam.module3.lecture234.taxistation.runner;
/*
import kz.epam.tam.module3.lecture234.taxistation.data.readers.DBReader;
import kz.epam.tam.module3.lecture234.taxistation.data.readers.IReader;
import kz.epam.tam.module3.lecture234.taxistation.data.readers.JSONReader;
import kz.epam.tam.module3.lecture234.taxistation.data.readers.XMLReader;
import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddAVehicleFromTXT;
import kz.epam.tam.module3.lecture234.taxistation.utils.FindByParameter;
import kz.epam.tam.module3.lecture234.taxistation.utils.FuelConsumptionComparator;

import java.util.*;

public class Runner1 {

    public static void main(String[] args){
        boolean repeat = true;

        List<PassengerTaxi> carList = new ArrayList<>();
        List<Taxi> vehicleList = new ArrayList<>();
        List<String> sortedByConsumptionList = new ArrayList<>();
        long countCar = 0;
        String search = "Search result is empty";

        while(repeat){
            try{
                System.out.println("1 - add new vehicle to station");
                System.out.println("2 - count taxi station budget");
                System.out.println("3 - show list of vehicle ordered by fuel consumption");
                System.out.println("4 - find a vehicle");
                System.out.println("0 - Exit");

                int choice = new Scanner(System.in).nextInt();

                switch (choice){
                    case 0:
                        repeat = false;
                        TxtFileWriter writer = new TxtFileWriter();
                        //writer.writeToFile(countCar,carListToWrite, sortedByConsumptionList, search);
                        System.out.println("Exit");
                        break;
                    case 1:
                        System.out.println("Choose a reader");
                        System.out.println("1 - TXT");
                        System.out.println("2 - XML");
                        System.out.println("3 - JSON");
                        System.out.println("4 - DB");

                        int reader = new Scanner(System.in).nextInt();;

                        if(reader == 1){
                            try{
                                AddAVehicleFromTXT vehicle = new AddAVehicleFromTXT();
                                carList = vehicle.fillBaseCharacteristicsCar();
                                vehicleList.addAll(carList);
                            }catch (InvalidListSizeException e){
                                System.out.println(e.getMessage() + " Actual number of fields is " + e.getExceptionCause() +
                                        ". Please check an input data and try again!");
                            }catch (InvalidDataException ide){
                                System.out.println(ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                                        ", consumption is " + ide.getExceptionConsumption());
                            }catch (NullPointerException npe){
                                System.out.println("Oops, number of vehicle you try to add is more than resource file contains. Please try again!");
                            }catch (NegativeArraySizeException e){
                                System.out.println("Oops, negative number is prohibited. Please try again!");
                            }
                        }else if(reader == 2){
                            IReader ireader = new JSONReader();
                            carList = ireader.readData();
                            //XMLReader xml = new XMLReader();
                            //carList = xml.readData();
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
                        for (Taxi taxiPrice : vehicleList){
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
                        try{
                            System.out.println("Type a car parameter to search.");

                            String param = new Scanner(System.in).nextLine();
                            search = FindByParameter.findACarByParameter(param,carList);
                            System.out.println("Completed!");
                        }catch (EmptySearchResultException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again!");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Oops, invalid data. Data must be only numeric. Please try again!");
            }
        }
    }
}*/
