package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class TXTFileReader implements IReader{

    public TaxiStation readData() throws InvalidListSizeException,InvalidDataException{
        BufferedReader reader = null;
        String line;
        TaxiStation taxiStation = new TaxiStation();
        try{
            reader = new BufferedReader(new FileReader(ResourceBundle.getBundle("filepath").getString("txt")));
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length != 5) {
                    throw new InvalidListSizeException("A car must contain 5 obligatory fields.",data.length);
                }
                try {
                    if(Long.parseLong(data[1]) <= 0 || Integer.parseInt(data[2]) <= 0){
                        throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                                data[1],data[2]);}
                    taxiStation.addTaxi(new Taxi(data[0], Long.parseLong(data[1]), Integer.parseInt(data[2]), data[3], data[4]));
                } catch (NumberFormatException e) {
                    if(Long.parseLong(data[1].replaceAll("[^0-9]", "")) <= 0 ||
                            Integer.parseInt(data[2].replaceAll("[^0-9]", "")) <= 0){
                        throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                                data[1],data[2]);}
                    taxiStation.addTaxi(new Taxi(data[0], Long.parseLong(data[1].replaceAll("[^0-9]", "")),
                            Integer.parseInt(data[2].replaceAll("[^0-9]", "")), data[3], data[4]));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return taxiStation;
    }
}
