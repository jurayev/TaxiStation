package lecture4;

import kz.epam.tam.module3.lecture2.taxistation.data.readers.JSONReader;
import kz.epam.tam.module3.lecture2.taxistation.data.readers.XMLReader;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass {

    @Test
    public void XMLReaderTest() {
        XMLReader reader = new XMLReader();
        List<Car> cars = reader.readData("src\\main\\resources\\cars.xml");
        for(int i=0; i< cars.size(); i++){
        System.out.println(cars.get(i));
        }
    }

    @Test
    public void JSONReaderTest(){
        JSONReader reader = new JSONReader();
        reader.readData("src\\main\\resources\\cars.xml");
    }
}
