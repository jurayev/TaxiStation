package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;

import java.util.List;

public class FindByParameter {

    public static String findACarByParameter(String value, List<Car> list)throws EmptySearchResultException{
        String carOutPut = "Search result:";
        for( Car car : list){
            Integer fuelConsumption = car.getFuelConsumption();
            Long vehiclePrice = car.getVehiclePrice();
            if(value.equals(car.getModel())){
                carOutPut += "\n" + car.getInfo();
            }
            else if(value.equals(fuelConsumption.toString())){
                carOutPut += "\n" + car.getInfo();
            }
            else if(value.equals(vehiclePrice.toString())){
                carOutPut += "\n" + car.getInfo();
            }
            else if(value.equals(car.getBodyType())){
                carOutPut += "\n" + car.getInfo();
            }
        }
        if(carOutPut.equals("Search result:")){
            throw new EmptySearchResultException(carOutPut + " nothing found!");
        }else{
            System.out.println(carOutPut);
        }
        return carOutPut;
    }
}

