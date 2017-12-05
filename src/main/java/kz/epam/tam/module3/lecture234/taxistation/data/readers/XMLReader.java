package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.data.parsers.CargoTaxiSAXParser;
import kz.epam.tam.module3.lecture234.taxistation.data.parsers.PassengerTaxiSAXParser;
import kz.epam.tam.module3.lecture234.taxistation.model.CargoTaxi;
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

    public List<PassengerTaxi> readData(String file) {
        List<Vehicle> data = new ArrayList<>();
        List<CargoTaxi> cTaxi = new ArrayList<>();
        List<PassengerTaxi> pTaxi = new ArrayList<>();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            String bundle = ResourceBundle.getBundle("filepath").getString(file);
            switch (file){
                case "passengerTaxiXML":
                    PassengerTaxiSAXParser taxiHandler = new PassengerTaxiSAXParser();
                    parser.parse(new File(bundle), taxiHandler);
                    pTaxi = taxiHandler.getResult();
                    data.addAll(pTaxi);

                    break;
                /*case "cargoTaxiXML":
                    CargoTaxiSAXParser cargoHandler = new CargoTaxiSAXParser();
                    parser.parse(new File(bundle), cargoHandler);
                    cTaxi = cargoHandler.getResult();
                    data.addAll(cTaxi);
                    return cTaxi;
                    break;*/
                default:
                    ///throw new DataReaderNotFoundException("Data Reader Not Found! Please,check the reader name.");
            }

        }catch (SAXException | IOException |ParserConfigurationException e) {
            e.printStackTrace();
        }
        return pTaxi;
    }
}
