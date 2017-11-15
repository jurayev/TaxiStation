package kz.epam.tam.module3.lecture2.taxistation.data.readers;

import com.google.gson.Gson;
import kz.epam.tam.module3.lecture2.taxistation.utils.AddCarsToListJsonHelper;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JSONReader implements IReader {

    private static String ABS_PATH = "src\\main\\resources\\cars.json";

    public List<Car> readData(){
        Gson gson = new Gson();
        AddCarsToListJsonHelper jsonHelper;
        List<Car> data = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ABS_PATH));
            jsonHelper = gson.fromJson(reader,AddCarsToListJsonHelper.class);
            data = jsonHelper.getCars();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
