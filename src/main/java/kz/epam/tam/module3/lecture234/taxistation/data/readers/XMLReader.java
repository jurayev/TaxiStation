package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.data.parsers.TaxiSAXParser;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture234.taxistation.property.PropertyProvider;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLReader implements IReader{

    public TaxiStation readData() {
        TaxiStation taxiStation = new TaxiStation();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        TaxiSAXParser handler;
        try {
            SAXParser parser = parserFactory.newSAXParser();
            handler = new TaxiSAXParser();
            parser.parse(new File(PropertyProvider.getProperty("xml")), handler);
            taxiStation = handler.getResult();
        }catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return taxiStation;
    }

}
