package kz.epam.tam.module3.lecture2.taxistation.utils;

import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidDataException;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidListSizeException;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;

import java.util.List;

public interface VehicleCreator {

    List<Car> fillBaseCharacteristicsCar() throws InvalidListSizeException, InvalidDataException;
    List<Van> fillBaseCharacteristicsVan() throws InvalidListSizeException, InvalidDataException;
}
