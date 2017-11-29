package kz.epam.tam.module3.lecture234.taxistation.workflow;

import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import kz.epam.tam.module3.lecture234.taxistation.modules.*;

import java.util.ArrayList;
import java.util.List;

public class TaxiStationCreator {

    public void createTaxiStation(){

        System.out.println("Start");
        ///add
        List<Car> carsList = new ArrayList<>();
        String errors = null;
        try {
            carsList.addAll(Adder.addCars());
        }catch (DataReaderNotFoundException e){
            errors = e.getMessage();
            System.out.println(e.getMessage());
        }catch (InvalidListSizeException e) {
            errors = e.getMessage()+ " Actual number of fields is " + e.getExceptionCause() +
                    ". Please check an input data and try again!";
            System.out.println(e.getMessage() + " Actual number of fields is " + e.getExceptionCause() +
                    ". Please check an input data and try again!");
        }catch (InvalidDataException ide) {
            errors = ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                    ", consumption is " + ide.getExceptionConsumption();
            System.out.println(ide.getMessage() + "Found: price is " + ide.getExceptionPrice() +
                    ", consumption is " + ide.getExceptionConsumption());
        }
        //// add to list for saving
        List<String> addedCarsList = new ArrayList<>();
        Converter.convertObjectsToString(carsList,addedCarsList);
/// count price
        long countCar = Counter.countCarsPrice(carsList);
///sort
        List<String> sortedList = new ArrayList<>();
        Sorter.sortCars(carsList,sortedList);
///search
        String search = Searcher.searchACar(carsList);
        ////write
        TxtFileWriter writer = new TxtFileWriter();
        writer.writeToFile(countCar, addedCarsList, sortedList, search, errors);
        System.out.println("Exit");
    }
}
