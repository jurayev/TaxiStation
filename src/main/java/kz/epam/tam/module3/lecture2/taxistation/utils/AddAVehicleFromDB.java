package kz.epam.tam.module3.lecture2.taxistation.utils;

import kz.epam.tam.module3.lecture2.taxistation.data.readers.TXTFileReader;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;

import java.util.ArrayList;
import java.util.List;


public class AddAVehicleFromDB implements VehicleCreator{
    private  static final String PATH_TO_CAR_TXT = "src\\main\\resources\\car.txt";
    private  static final String PATH_TO_VAN_TXT = "src\\main\\resources\\van.txt";

    @Override
    public List<Car> fillBaseCharacteristicsCar(){
        List<Car> carList = new ArrayList<>();
        TXTFileReader data = new TXTFileReader();



        return carList;
    }
    public List<Van> fillBaseCharacteristicsVan(){
        TXTFileReader data = new TXTFileReader();
        List<Van> vanList  = new ArrayList<>();


        return vanList;
    }

}
