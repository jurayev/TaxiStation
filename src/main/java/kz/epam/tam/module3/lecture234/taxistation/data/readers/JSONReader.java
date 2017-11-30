package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kz.epam.tam.module3.lecture234.taxistation.model.CargoTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddCTaxiToListJsonHelper;
import kz.epam.tam.module3.lecture234.taxistation.utils.AddPTaxiToListJsonHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class JSONReader implements IReader {

    public List<Vehicle> readData(String file){
        Gson gson = new Gson();
        List<Vehicle> data = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ResourceBundle.getBundle("filepath").getString(file)));
            switch (file){
                case "passengerTaxiJSON":
                    AddPTaxiToListJsonHelper pTaxiHelper = gson.fromJson(reader,AddPTaxiToListJsonHelper.class);
                    List<PassengerTaxi> pTaxi = pTaxiHelper.getPassengerTaxis();
                    data.addAll(pTaxi);
                    break;
                case "cargoTaxiJSON":
                    AddCTaxiToListJsonHelper cTaxiHelper = gson.fromJson(reader,AddCTaxiToListJsonHelper.class);
                    List<CargoTaxi> cTaxi = cTaxiHelper.getCargoTaxis();
                    data.addAll(cTaxi);
                    break;
                default:
                    ///throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
            }

        } catch (IOException|JsonSyntaxException e) {
            e.printStackTrace();
        }catch (NumberFormatException e) {
            e.getCause();
        }
        return data;
    }
}
