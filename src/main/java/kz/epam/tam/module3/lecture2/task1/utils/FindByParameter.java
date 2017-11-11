package kz.epam.tam.module3.lecture2.task1.utils;

import kz.epam.tam.module3.lecture2.task1.Car;
import kz.epam.tam.module3.lecture2.task1.Van;

import java.util.List;

public class FindByParameter {

    public static String findACarByParameter(String value, List<Car> list){
        String carOutput = "Search result:";
        for( Car car : list){
            Integer fuelConsumption = car.getFuelConsumption();
            Long vehiclePrice = car.getVehiclePrice();
            if(value.equals(car.getModel())){
                carOutput += "\n" + car.getInfo();
            }
            else if(value.equals(fuelConsumption.toString())){
                carOutput += "\n" + car.getInfo();
            }
            else if(value.equals(vehiclePrice.toString())){
                carOutput += "\n" + car.getInfo();
            }
            else if(value.equals(car.getBodytype())){
                carOutput += "\n" + car.getInfo();
            }
        }
        System.out.println(carOutput);
        return carOutput;
    }
    public static String findAVanByParameter(String value, List<Van> list){
        String carOutput = "Search result:";
        for( Van van : list){
            Integer fuelConsumption = van.getFuelConsumption();
            Long vehiclePrice = van.getVehiclePrice();
            Integer numberOfSeats = van.getNumberOfSeats();
            if(value.equals(van.getModel())){
                carOutput += "\n" + van.getInfo();
            }
            else if(value.equals(fuelConsumption.toString())){
                carOutput += "\n" + van.getInfo();
            }
            else if(value.equals(vehiclePrice.toString())){
                carOutput += "\n" + van.getInfo();
            }
            else if(value.equals(van.getFuelType())){
                carOutput += "\n" + van.getInfo();
            }
            else if(value.equals(numberOfSeats.toString())){
                carOutput += "\n" + van.getInfo();
            }
        }
        System.out.println(carOutput);
        return carOutput;
    }
}

