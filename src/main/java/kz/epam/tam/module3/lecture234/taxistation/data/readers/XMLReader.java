package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.data.parsers.VehicleSAXParser;
import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class XMLReader implements IReader{

    private static final ResourceBundle configBundle = ResourceBundle.getBundle("filepath");

    public List<Car> readData() {
        List<Car> data = new ArrayList<>();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        VehicleSAXParser handler;
        try {
            SAXParser parser = parserFactory.newSAXParser();
            handler = new VehicleSAXParser();
            parser.parse(new File(configBundle.getString("xml")), handler);
            data = handler.getResultCar();
        }catch (SAXException | IOException |ParserConfigurationException e) {
            e.printStackTrace();
        }
        return data;
    }

}