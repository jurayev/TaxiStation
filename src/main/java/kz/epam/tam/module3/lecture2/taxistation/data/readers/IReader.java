package kz.epam.tam.module3.lecture2.taxistation.data.readers;

import kz.epam.tam.module3.lecture2.taxistation.model.Car;

import java.util.List;

public interface IReader {

    List<Car> readData();
}
