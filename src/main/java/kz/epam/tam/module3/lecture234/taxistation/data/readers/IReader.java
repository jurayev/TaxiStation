package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;

import java.util.List;

public interface IReader {

    void readData(String file)throws InvalidListSizeException,InvalidDataException;

    //List<Vehicle> readCTaxiData(String file)throws InvalidListSizeException,InvalidDataException;
}
