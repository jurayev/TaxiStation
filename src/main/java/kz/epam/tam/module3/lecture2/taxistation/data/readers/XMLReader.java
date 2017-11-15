package kz.epam.tam.module3.lecture2.taxistation.data.readers;

import kz.epam.tam.module3.lecture2.taxistation.data.parsers.VehicleSAXParser;
import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.TaxiStation;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {

    public List<Car> readData(String absPath) {
        List<Car> data = new ArrayList<>();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        VehicleSAXParser handler;
        try {
            SAXParser parser = parserFactory.newSAXParser();
            handler = new VehicleSAXParser();
            parser.parse(new File(absPath), handler);
            data = handler.getResultCar();
        }catch (SAXException e1) {
            System.out.println("Parsing fails: " + e1.getMessage());
        }catch (IOException e2) {
            System.out.println("Parsing fails: " + e2.getMessage());
        }catch (ParserConfigurationException e3) {
            System.out.println("Parsing fails: " + e3.getMessage());
        }
        return data;
    }

}
