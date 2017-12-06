package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.List;

public class FindByParameter {

    public static String findACarByParameter(String value, List<Taxi> list)throws EmptySearchResultException{
        String carOutPut = "Search result:";
        for( Taxi taxi : list){
            if(value.equals(taxi.getModel())){
                carOutPut += "\n" + taxi.getInfo();
            }
            else if(value.equals(Integer.toString(taxi.getFuelConsumption())) ){
                carOutPut += "\n" + taxi.getInfo();
            }
            else if(value.equals(Long.toString(taxi.getVehiclePrice())) ){
                carOutPut += "\n" + taxi.getInfo();
            }
            else if(value.equals(taxi.getBodyType())){
                carOutPut += "\n" + taxi.getInfo();
            }
            else if(value.equals(taxi.getTaxiClass())){
                carOutPut += "\n" + taxi.getInfo();
            }
        }
        if(carOutPut.equals("Search result:")){
            throw new EmptySearchResultException(carOutPut + " nothing found!");
        }
        return carOutPut;
    }
}

