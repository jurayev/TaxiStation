package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;

import java.util.ResourceBundle;

public class Searcher {

    private static TaxiStation result = new TaxiStation();

    public static TaxiStation searchATaxi(TaxiStation taxiStation) throws EmptySearchResultException{
        //String search = "Search result by: ";
        ResourceBundle bundle = ResourceBundle.getBundle("search");
        String param = bundle.getString("searchBy");
        String value = bundle.getString("value");
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
        }catch (NumberFormatException ignored){}
        if(result.getTaxis().isEmpty()){
            throw new EmptySearchResultException("Search result: nothing found!");
        }
        return result;
    }

    private static void findByClass(String taxiClass, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (taxiClass.equals(taxi.getTaxiClass())) {
                result.addTaxi(taxi);
                //result += "\nclass: " + taxi.toString();
            }
        }
    }
    private static void findByBody(String body, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (body.equals(taxi.getBodyType())) {
                result.addTaxi(taxi);
                //result += "\nbody: " + taxi.toString();
            }
        }
    }
    private static void findByConsumption(Integer consumption, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (consumption.equals(taxi.getFuelConsumption())) {
                result.addTaxi(taxi);
                //result += "\nconsumption: " + taxi.toString();
            }
        }
    }
    private static void findByPrice(Long price, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (price.equals(taxi.getVehiclePrice())) {
                result.addTaxi(taxi);
                //result += "\nprice: " + taxi.toString();
            }
        }
    }
    private static void findByModel(String model, TaxiStation taxiStation){
        for( Taxi taxi : taxiStation.getTaxis()) {
            if (model.equals(taxi.getModel())) {
                result.addTaxi(taxi);
                //result += "\nmodel: " + taxi.toString();
            }
        }
    }
}
