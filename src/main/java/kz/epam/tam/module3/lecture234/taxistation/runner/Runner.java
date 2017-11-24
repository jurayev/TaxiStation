package kz.epam.tam.module3.lecture234.taxistation.runner;

import kz.epam.tam.module3.lecture234.taxistation.data.readers.DBReader;
import kz.epam.tam.module3.lecture234.taxistation.data.readers.JSONReader;
import kz.epam.tam.module3.lecture234.taxistation.data.readers.XMLReader;
import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddAVehicleFromTXT;
import kz.epam.tam.module3.lecture234.taxistation.utils.FindByParameter;
import kz.epam.tam.module3.lecture234.taxistation.utils.FuelConsumptionComparator;

import java.util.*;

public class Runner {
    private static final ResourceBundle configBundle = ResourceBundle.getBundle("other");

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        List<String> sortedByConsumptionList = new ArrayList<>();
        List<String> addedCarsToStationList = new ArrayList<>();
        long countCar = 0;
        String search = "Search result is empty";

        System.out.println("Start");
        String picker = configBundle.getString("reader");
        if(picker.equals("txt")) {
            try {
                AddAVehicleFromTXT txt = new AddAVehicleFromTXT();
                carList = txt.fillBaseCharacteristicsCar();
            } catch (InvalidListSizeException e) {
                System.out.println(e.getMessage() + " Actual number of fields is " + e.getExceptionCause() +
                        ". Please check an input data and try again!");
            } catch (InvalidDataException ide) {
                System.out.println(ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                        ", consumption is " + ide.getExceptionConsumption());
            } catch (NullPointerException npe) {
                System.out.println("Oops, number of vehicle you try to add is more than resource file contains. Please try again!");
            } catch (NegativeArraySizeException e) {
                System.out.println("Oops, negative number is prohibited. Please try again!");
            }
        }
        else if(picker.equals("xml")) {
            XMLReader xml = new XMLReader();
            carList = xml.readData();
        }
        else if(picker.equals("json")) {
            JSONReader json = new JSONReader();
            carList = json.readData();
        }
        else if(picker.equals("db")) {
            DBReader db = new DBReader();
            carList = db.readData();
        }
        //// add to list for saving
        for (int i = 0; i < carList.size(); i++) {
            addedCarsToStationList.add("\n" + carList.get(i).getInfo());
            System.out.println(carList.get(i).getInfo());
        }

        for (Car taxiPrice : carList) {
            countCar += taxiPrice.getVehiclePrice();
        }

        Collections.sort(carList, new FuelConsumptionComparator());
        for (int i = 0; i < carList.size(); i++) {
            sortedByConsumptionList.add("\n"+ carList.get(i).getInfo());
            System.out.println(carList.get(i).getInfo());
        }

        try {
            String param = configBundle.getString("search");
            search = FindByParameter.findACarByParameter(param, carList);
        } catch (EmptySearchResultException e) {
            System.out.println(e.getMessage());
        }
        TxtFileWriter writer = new TxtFileWriter();
        writer.writeToFile(countCar,addedCarsToStationList, sortedByConsumptionList, search);
        System.out.println("Exit");
    }
}
