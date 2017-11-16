package kz.epam.tam.module3.lecture234.taxistation.utils;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import kz.epam.tam.module3.lecture234.taxistation.data.readers.TXTFileReader;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidDataException;
import kz.epam.tam.module3.lecture234.taxistation.exceptions.InvalidListSizeException;

import java.util.ArrayList;
import java.util.List;

public class AddAVehicleFromTXT {



    public List<Car> fillBaseCharacteristicsCar() throws InvalidListSizeException, InvalidDataException  {
        List<Car> carList = new ArrayList<>();
        TXTFileReader data = new TXTFileReader();
        String[][] info = data.readData();
        for(int i = 0; i < info.length; i++) {
            if (info[i].length != 4) {
                throw new InvalidListSizeException("A car must contain 4 obligatory fields.",info[i].length);
            }
            try {
                if(Long.parseLong(info[i][1]) <= 0 || Integer.parseInt(info[i][2]) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
                carList.add(new Car(info[i][0], Long.parseLong(info[i][1]), Integer.parseInt(info[i][2]), info[i][3]));
            } catch (NumberFormatException e) {
                if(Long.parseLong(info[i][1].replaceAll("[^0-9]", "")) <= 0 ||
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
                carList.add(new Car(info[i][0], Long.parseLong(info[i][1].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")), info[i][3]));
            }
        }
        return carList;
    }
}
