package kz.epam.tam.module3.lecture234.taxistation.workflow;

import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.modules.*;

import java.util.ArrayList;
import java.util.List;

public class TaxiStationCreator {

    public void createTaxiStation(){

        List<Taxi> taxiList = new ArrayList<>();
        String errors = null;
        try {
            taxiList = Adder.addCars();
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
        List<String> addedTaxisList = new ArrayList<>();
        Converter.convertObjectsToString(taxiList,addedTaxisList);
        long countCar = Counter.countCarsPrice(taxiList);
        List<String> sortedList = new ArrayList<>();
        Sorter.sortCars(taxiList,sortedList);
        String search = Searcher.searchACar(taxiList);
        TxtFileWriter writer = new TxtFileWriter();
        writer.writeToFile(countCar, addedTaxisList, sortedList, search, errors);
    }
}

