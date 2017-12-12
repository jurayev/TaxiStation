package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.List;
import java.util.ResourceBundle;

public class Searcher {

    private static String result ="";

    public static String searchATaxi(List<Taxi> taxiList) throws EmptySearchResultException{
        String search = "Search result by: ";
        ResourceBundle bundle = ResourceBundle.getBundle("search");
        String param = bundle.getString("searchBy");
        String value = bundle.getString("value");
        try{
            switch (param){
                case "model":
                    search += findByModel(value, taxiList);
                    break;
                case "price":
                    search += findByPrice(Long.parseLong(value), taxiList);
                    break;
                case "consumption":
                    search += findByConsumption(Integer.parseInt(value), taxiList);
                    break;
                case "body":
                    search += findByBody(value, taxiList);
                    break;
                case "class":
                    search += findByClass(value, taxiList);
                    break;
            }
        }catch (NumberFormatException ignored){}
        if(search.equals("Search result by: ")){
            throw new EmptySearchResultException(search + "nothing found!");
        }
        return search;
    }

    private static String findByClass(String taxiClass, List<Taxi> taxis){
        for( Taxi taxi : taxis) {
            if (taxiClass.equals(taxi.getTaxiClass())) {
                result += "\nclass: " + taxi.getInfo();
            }
        }
        return result;
    }
    private static String findByBody(String body, List<Taxi> taxis){
        for( Taxi taxi : taxis) {
            if (body.equals(taxi.getBodyType())) {
                result += "\nbody: " + taxi.getInfo();
            }
        }
        return result;
    }
    private static String findByConsumption(Integer consumption, List<Taxi> taxis){
        for( Taxi taxi : taxis) {
            if (consumption.equals(taxi.getFuelConsumption())) {
                result += "\nconsumption: " + taxi.getInfo();
            }
        }
        return result;
    }
    private static String findByPrice(Long price, List<Taxi> taxis){
        for( Taxi taxi : taxis) {
            if (price.equals(taxi.getVehiclePrice())) {
                result += "\nprice: " + taxi.getInfo();
            }
        }
        return result;
    }
    private static String findByModel(String model, List<Taxi> taxis){
        for( Taxi taxi : taxis) {
            if (model.equals(taxi.getModel())) {
                result += "\nmodel: " + taxi.getInfo();
            }
        }
        return result;
    }
}
