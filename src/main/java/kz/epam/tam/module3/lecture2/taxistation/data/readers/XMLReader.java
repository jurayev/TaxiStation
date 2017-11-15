package kz.epam.tam.module3.lecture2.taxistation.data.readers;

import kz.epam.tam.module3.lecture2.taxistation.data.parsers.VehicleSAXParser;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader implements IReader{
    private  static final String PATH_TO_CAR_XML = "src\\main\\resources\\cars.xml";
    public List<Car> readData() {
        List<Car> data = new ArrayList<>();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        VehicleSAXParser handler;
        try {
            SAXParser parser = parserFactory.newSAXParser();
            handler = new VehicleSAXParser();
            parser.parse(new File(PATH_TO_CAR_XML), handler);
            data = handler.getResultCar();
        }catch (SAXException e1) {
            System.out.println("Parsing failed: " + e1.getMessage());
        }catch (IOException e2) {
            System.out.println("Parsing failed: " + e2.getMessage());
        }catch (ParserConfigurationException e3) {
            System.out.println("Parsing failed: " + e3.getMessage());
        }
        return data;
    }

}
