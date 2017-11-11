package kz.epam.tam.module3.lecture2.taxistation.utils;

import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;
import kz.epam.tam.module3.lecture2.taxistation.exception.EmptySearchResultException;

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
            else if(value.equals(car.getBodytype())){
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
    public static String findAVanByParameter(String value, List<Van> list)throws EmptySearchResultException{
        String vanOutPut = "Search result:";
        for( Van van : list){
            Integer fuelConsumption = van.getFuelConsumption();
            Long vehiclePrice = van.getVehiclePrice();
            Integer numberOfSeats = van.getNumberOfSeats();
            if(value.equals(van.getModel())){
                vanOutPut += "\n" + van.getInfo();
            }
            else if(value.equals(fuelConsumption.toString())){
                vanOutPut += "\n" + van.getInfo();
            }
            else if(value.equals(vehiclePrice.toString())){
                vanOutPut += "\n" + van.getInfo();
            }
            else if(value.equals(van.getFuelType())){
                vanOutPut += "\n" + van.getInfo();
            }
            else if(value.equals(numberOfSeats.toString())){
                vanOutPut += "\n" + van.getInfo();
            }
        }
        if(vanOutPut.equals("Search result:")){
            throw new EmptySearchResultException(vanOutPut + " nothing found!");
        }else{
            System.out.println(vanOutPut);
        }
        return vanOutPut;
    }
}

