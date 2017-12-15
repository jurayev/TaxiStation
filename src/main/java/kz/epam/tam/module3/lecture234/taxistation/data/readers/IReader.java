package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;

public interface IReader {

    TaxiStation readData()throws InvalidListSizeException,InvalidDataException;
}
