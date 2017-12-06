package kz.epam.tam.module3.lecture234.taxistation.data.parsers;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TaxiSAXParser extends DefaultHandler {

    private Taxi taxi;
    private List<Taxi> taxis = new ArrayList<>();
    private StringBuilder thisElement;

    public TaxiSAXParser() {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = new StringBuilder();
        if (qName.equals("Taxi")) {
            this.taxi = new Taxi();
        }
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("Taxi")) {
            this.taxis.add(this.taxi);
        } else {
            String elementVal = this.thisElement.toString();
            switch (qName){
                case "model":
                    this.taxi.setModel(elementVal);
                    break;

                case "price":
                    long price;
                    try {
                        price = Long.parseLong(elementVal);
                    }catch (NumberFormatException e){
                        price = Long.parseLong(elementVal.replaceAll("[^0-9]", ""));
                    }this.taxi.setVehiclePrice(price);
                    break;
                case "consumption":
                    int cons;
                    try{
                        cons = Integer.parseInt(elementVal);
                    }catch (NumberFormatException e){
                        cons = Integer.parseInt(elementVal.replaceAll("[^0-9]", ""));
                    }
                    this.taxi.setFuelConsumption(cons);
                    break;
                case "btype":
                    this.taxi.setBodyType(elementVal);
                    break;
                case "class":
                    this.taxi.setTaxiClass(elementVal);
            }
        }
        this.thisElement = new StringBuilder();
    }

    public void endDocument() throws SAXException {
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.thisElement.append(ch, start, length);
    }

    public List<Taxi> getResult(){
        return this.taxis;
    }
}


