package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.data.readers.*;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.DataReaderNotFoundException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Adder {

    public void addVehicle() throws DataReaderNotFoundException,InvalidListSizeException,InvalidDataException{
        String picker = ResourceBundle.getBundle("workflowvariables").getString("reader");

        IReader reader;
        switch (picker) {
            case "txt":
                reader = new TXTFileReader();
                reader.readData("passengerTaxiTXT");

                break;
            /*case "xml":
                reader = new XMLReader();
                vehicleList.addAll(reader.readData("passengerTaxiXML"));
                vehicleList.addAll(reader.readData("cargoTaxiXML"));
                break;
            case "json":
                reader = new JSONReader();
                vehicleList.addAll(reader.readData("passengerTaxiJSON"));
                vehicleList.addAll(reader.readData("cargoTaxiJSON"));
                break;
            case "db":
                reader = new DBReader();
                vehicleList.addAll(reader.readData("SELECT * FROM PASSENGERTAXI"));
                vehicleList.addAll(reader.readData("SELECT * FROM CARGOTAXI"));
                break;*/
            default:
                throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
        }
    }
}
