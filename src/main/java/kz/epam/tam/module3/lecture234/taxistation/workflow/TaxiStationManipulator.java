package kz.epam.tam.module3.lecture234.taxistation.workflow;

import kz.epam.tam.module3.lecture234.taxistation.data.writers.TxtFileWriter;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture234.taxistation.modules.*;

import java.util.List;

public class TaxiStationManipulator {

    public void manipulateTaxiStationMainFeatures(){
        String errors = "";
        TxtFileWriter writer = new TxtFileWriter();
        try {
            TaxiStation st = new TaxiStation(Adder.addCars());
            List<Taxi> taxis = st.getTaxis();
            writer.writeToFile(st.toString(),false);
            writer.writeToFile(Long.toString(Counter.countCarsPrice(taxis)),true);
            writer.writeToFile(Sorter.sortCars(taxis).toString(),true);
            writer.writeToFile(Searcher.searchATaxi(taxis),true);
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
        }catch (EmptySearchResultException e) {
            e.getMessage();
            System.out.println(e.getMessage());
        }
        if(!errors.equals("")){
            writer.writeToFile(errors,false);
        }
    }
}

