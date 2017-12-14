package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.data.readers.*;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;

import java.util.ResourceBundle;

public class Adder {

    public static TaxiStation addCars() throws DataReaderNotFoundException,InvalidListSizeException,InvalidDataException{
        String picker = ResourceBundle.getBundle("reader").getString("reader");

        TaxiStation taxiStation;
        IReader reader;
        switch (picker) {
            case "txt":
                reader = new TXTFileReader();
                taxiStation = reader.readData();
                break;
            case "xml":
                reader = new XMLReader();
                taxiStation = reader.readData();
                break;
            case "json":
                reader = new JSONReader();
                taxiStation = reader.readData();
                break;
            case "db":
                //reader = new DBReader();
                taxiStation = new DBReader().readData();
                break;
            default:
                throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
        }
        return taxiStation;
    }
}
