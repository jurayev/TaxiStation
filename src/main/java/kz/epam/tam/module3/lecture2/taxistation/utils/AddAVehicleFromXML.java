package kz.epam.tam.module3.lecture2.taxistation.utils;

import kz.epam.tam.module3.lecture2.taxistation.data.readers.TXTFileReader;
import kz.epam.tam.module3.lecture2.taxistation.data.readers.XMLReader;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidDataException;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidListSizeException;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;

import java.util.ArrayList;
import java.util.List;


public class AddAVehicleFromXML implements VehicleCreator{
    private  static final String PATH_TO_CAR_XML = "src\\main\\resources\\cars.xml";
    private  static final String PATH_TO_VAN_XML = "src\\main\\resources\\van.xml";

    @Override
    public List<Car> fillBaseCharacteristicsCar(){
        List<Car> carList;
        XMLReader xml = new XMLReader();
        carList = xml.readData(PATH_TO_CAR_XML);
        return carList;
    }
    public List<Van> fillBaseCharacteristicsVan(){
        List<Van> vanList = new ArrayList<>();
        /*XMLReader xml = new XMLReader(PATH_TO_CAR_XML);
        vanList = xml.readData();
*/
        return vanList;
    }

}
