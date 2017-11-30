package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.data.parsers.PassengerTaxiSAXParser;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;
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

    public List<Vehicle> readData(String file) {
        List<Vehicle> data = new ArrayList<>();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        PassengerTaxiSAXParser handler;
        try {
            SAXParser parser = parserFactory.newSAXParser();

            switch (file){
                case "passengerTaxiXML":
                    handler = new PassengerTaxiSAXParser();
                    parser.parse(new File(ResourceBundle.getBundle("filepath").getString(file)), handler);
                    List<PassengerTaxi> pTaxi = handler.getResult();
                    break;
            }

        }catch (SAXException | IOException |ParserConfigurationException e) {
            e.printStackTrace();
        }
        return data;
    }
}
