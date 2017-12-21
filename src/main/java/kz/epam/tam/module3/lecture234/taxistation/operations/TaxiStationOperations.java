package kz.epam.tam.module3.lecture234.taxistation.operations;

import kz.epam.tam.module3.lecture234.taxistation.data.readers.*;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;

import java.util.Collections;
import java.util.Comparator;

public class TaxiStationOperations {

    private TaxiStation result = new TaxiStation();

    public TaxiStation readTaxiStationFromFile(String fileExtension) throws DataReaderNotFoundException,InvalidListSizeException,InvalidDataException {
        TaxiStation taxiStation;
        IReader reader;
        switch (fileExtension) {
            case "txt":
                reader = new TXTFileReader();
                break;
            case "xml":
                reader = new XMLReader();
                break;
            case "json":
                reader = new JSONReader();
                break;
            case "db":
                reader = new DBReader();
                break;
            default:
                throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
        }
        taxiStation = reader.readData();
        return taxiStation;
    }

    public long countCarsPrice(TaxiStation taxiStation){
        long countPrice = 0;
        for (Taxi taxiPrice : taxiStation.getTaxis()) {
            countPrice += taxiPrice.getVehiclePrice();
        }
        return countPrice;
    }

    public TaxiStation sortCars(TaxiStation taxiStation){
        Collections.sort(taxiStation.getTaxis(), new TaxisComparator());
        return taxiStation;
    }

    public TaxiStation searchATaxi(TaxiStation taxiStation,String param,String value) throws EmptySearchResultException {
        try{
            switch (param){
                case "model":
                    findByModel(value, taxiStation);
                    break;
                case "price":
                    findByPrice(Long.parseLong(value), taxiStation);
                    break;
                case "consumption":
                    findByConsumption(Integer.parseInt(value), taxiStation);
                    break;
                case "body":
                    findByBody(value, taxiStation);
                    break;
                case "class":
                    findByClass(value, taxiStation);
                    break;
            }
        }catch (NumberFormatException e){
            e.getStackTrace();
        }
        if(result.getTaxis().isEmpty()){
            throw new EmptySearchResultException("Search result: nothing found!");
        }
        return result;
    }
    private void findByClass(String taxiClass, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (taxiClass.equals(taxi.getTaxiClass())) {
                result.addTaxi(taxi);
            }
        }
    }
    private void findByBody(String body, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (body.equals(taxi.getBodyType())) {
                result.addTaxi(taxi);
            }
        }
    }
    private void findByConsumption(Integer consumption, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (consumption.equals(taxi.getFuelConsumption())) {
                result.addTaxi(taxi);
            }
        }
    }
    private void findByPrice(Long price, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (price.equals(taxi.getVehiclePrice())) {
                result.addTaxi(taxi);
            }
        }
    }
    private void findByModel(String model, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (model.equals(taxi.getModel())) {
                result.addTaxi(taxi);
            }
        }
    }

    private class TaxisComparator implements Comparator<Taxi>{
        @Override
        public int compare(Taxi o1, Taxi o2){   ////ascending order
            return o1.getFuelConsumption() - o2.getFuelConsumption();
        }
    }

}

