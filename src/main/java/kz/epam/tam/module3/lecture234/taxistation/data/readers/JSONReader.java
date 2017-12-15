package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture234.taxistation.property.PropertyProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader implements IReader {

    public TaxiStation readData(){
        Gson gson = new Gson();
        BufferedReader reader = null;
        TaxiStation taxiStation = new TaxiStation();
        try {
            reader = new BufferedReader(new FileReader(PropertyProvider.getProperty("json")));
            taxiStation = gson.fromJson(reader, TaxiStation.class);
        }catch (IOException|JsonSyntaxException e) {
            e.printStackTrace();
        }catch (NumberFormatException e) {
            e.getCause();
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
