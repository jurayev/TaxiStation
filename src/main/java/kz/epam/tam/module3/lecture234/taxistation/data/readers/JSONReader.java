package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddTaxisToListJsonHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class JSONReader implements IReader {
    private List<Taxi> taxis;

    public List<Taxi> readData(){
        Gson gson = new Gson();
        AddTaxisToListJsonHelper jsonHelper;
        List<Taxi> data = new ArrayList<>();
        BufferedReader reader;
        Taxi taxi = new Taxi();
        try {
            reader = new BufferedReader(new FileReader(ResourceBundle.getBundle("filepath").getString("json")));
            JSONReader j = gson.fromJson(reader, JSONReader.class);
            data = j.taxis;
            //System.out.println(data1.getInfo());
        }catch (IOException|JsonSyntaxException e) {
            e.printStackTrace();
        }catch (NumberFormatException e) {
            e.getCause();
        }
        return data;
    }
}
