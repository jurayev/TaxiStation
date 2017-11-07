package kz.epam.tam.module3.lecture2.task1.utils;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.Van;

import java.util.List;

public class FindByParameter {

    public static void findACarByParameter(String value, List<Car> list){

        for( Car car : list){
            Integer fuelConsumption = car.getFuelConsumption();
            Long vehiclePrice = car.getVehiclePrice();
            if(value.equals(car.getModel())){
                System.out.println(car.getInfo());
            }
            else if(value.equals(fuelConsumption.toString())){
                System.out.println(car.getInfo());
            }
            else if(value.equals(vehiclePrice.toString())){
                System.out.println(car.getInfo());
            }
            else if(value.equals(car.getBodytype())){
                System.out.println(car.getInfo());
            }
            /*else{
                System.out.println("Sorry,could not find anything by:" + value);

            }*/
        }
    }
    public static void findAVanByParameter(String value, List<Van> list){

        for( Van van : list){
            Integer fuelConsumption = van.getFuelConsumption();
            Long vehiclePrice = van.getVehiclePrice();
            Integer numberOfSeats = van.getNumberOfSeats();
            if(value.equals(van.getModel())){
                System.out.println(van.getInfo());
            }
            else if(value.equals(fuelConsumption.toString())){
                System.out.println(van.getInfo());
            }
            else if(value.equals(vehiclePrice.toString())){
                System.out.println(van.getInfo());
            }
            else if(value.equals(van.getFuelType())){
                System.out.println(van.getInfo());
            }
            else if(value.equals(numberOfSeats.toString())){
                System.out.println(van.getInfo());
            }
        }
    }
}

