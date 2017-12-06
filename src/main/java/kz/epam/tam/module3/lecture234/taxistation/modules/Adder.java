package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.data.readers.*;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;

import java.util.List;
import java.util.ResourceBundle;

public class Adder {

    public static List<Taxi> addCars() throws DataReaderNotFoundException,InvalidListSizeException,InvalidDataException{
        String picker = ResourceBundle.getBundle("workflowvariables").getString("reader");
        List<Taxi> taxiList;
        IReader reader;
        switch (picker) {
            case "txt":
                reader = new TXTFileReader();
                taxiList = reader.readData();
                break;
            case "xml":
                reader = new XMLReader();
                taxiList = reader.readData();
                break;
            case "json":
                reader = new JSONReader();
                taxiList = reader.readData();
                break;
            case "db":
                reader = new DBReader();
                taxiList = reader.readData();
                break;
            default:
                throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
        }
        return taxiList;
    }
}
