package kz.epam.tam.module3.lecture234.taxistation.data.readers;


import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.CargoTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class TXTFileReader implements IReader<Vehicle>{

    public List<Vehicle> readPTaxiData(String file)throws InvalidListSizeException,InvalidDataException{
        BufferedReader reader = null;
        String line;
        List<Vehicle> vehicleList = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(ResourceBundle.getBundle("filepath").getString(file)));
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                listSizeAssertion(data);
                try {
                    switch (file){
                        case "passengerTaxiTXT":
                            passengerDataValidation(data);
                            vehicleList.add(new PassengerTaxi(data[0], Long.parseLong(data[1]), Integer.parseInt(data[2]), data[3], data[4]));
                            break;
                        case "cargoTaxiTXT":
                            cargoDataValidation(data);
                            vehicleList.add(new CargoTaxi(data[0], Long.parseLong(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]));
                            break;
                        default:
                            ///throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
                    }
                } catch (NumberFormatException e) {
                    switch (file){
                        case "passengerTaxiTXT":
                            passengerDataValidationUsingReplacement(data);
                            vehicleList.add(new PassengerTaxi(data[0], Long.parseLong(data[1].replaceAll("[^0-9]", "")),
                                    Integer.parseInt(data[2].replaceAll("[^0-9]", "")), data[3], data[4]));
                            break;
                        case "cargoTaxiTXT":
                            cargoDataValidationUsingReplacement(data);
                            vehicleList.add(new CargoTaxi(data[0], Long.parseLong(data[1].replaceAll("[^0-9]", "")),
                                    Integer.parseInt(data[2].replaceAll("[^0-9]", "")), Integer.parseInt(data[3].replaceAll("[^0-9]", "")), data[4]));
                            break;
                        default:
                            ///throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return vehicleList;
    }
    public void listSizeAssertion(String[] data)throws InvalidListSizeException{
        if (data.length != 5) {
            throw new InvalidListSizeException("A car must contain 5 obligatory fields.",data.length);
        }
    }
    public void passengerDataValidation(String[] data)throws InvalidDataException{
        if(Long.parseLong(data[1]) <= 0 || Integer.parseInt(data[2]) <= 0){
            throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                    data[1],data[2]);}
    }
    public void cargoDataValidation(String[] data)throws InvalidDataException{
        if(Long.parseLong(data[1]) <= 0 || Integer.parseInt(data[2]) <= 0|| Integer.parseInt(data[3]) <= 0){
            throw new InvalidDataException("Validation has detected invalid input data. Price , consumption , capacity must be positive and not equals to zero. ",
                    data[1],data[2]);}
    }
    public void passengerDataValidationUsingReplacement(String[] data)throws InvalidDataException{
        if(Long.parseLong(data[1].replaceAll("[^0-9]", "")) <= 0 ||
                Integer.parseInt(data[2].replaceAll("[^0-9]", "")) <= 0){
            throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                    data[1],data[2]);}
    }
    public void cargoDataValidationUsingReplacement(String[] data)throws InvalidDataException{
        if(Long.parseLong(data[1].replaceAll("[^0-9]", "")) <= 0 || Integer.parseInt(data[2].replaceAll("[^0-9]", "")) <= 0
                || Integer.parseInt(data[3].replaceAll("[^0-9]", "")) <= 0){
            throw new InvalidDataException("Validation has detected invalid input data. Price , consumption , capacity must be positive and not equals to zero. ",
                    data[1],data[2]);}
    }
}
