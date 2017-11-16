package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import com.google.gson.Gson;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddCarsToListJsonHelper;
import kz.epam.tam.module3.lecture234.taxistation.model.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class JSONReader implements IReader {

    private static final ResourceBundle configBundle = ResourceBundle.getBundle("filepath");

    public List<Car> readData(){
        Gson gson = new Gson();
        AddCarsToListJsonHelper jsonHelper;
        List<Car> data = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configBundle.getString("json")));
            jsonHelper = gson.fromJson(reader,AddCarsToListJsonHelper.class);
            data = jsonHelper.getCars();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
