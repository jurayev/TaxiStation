package kz.epam.tam.module3.lecture234.taxistation.data.parsers;

import org.xml.sax.helpers.DefaultHandler;
import kz.epam.tam.module3.lecture234.taxistation.model.CargoTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class CargoTaxiSAXParser extends DefaultHandler {

    private CargoTaxi cargoTaxi;
    private List<CargoTaxi> cargoTaxis = new ArrayList<>();
    private StringBuilder thisElement;

    public CargoTaxiSAXParser() {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = new StringBuilder();
        if (qName.equals("cargoTaxi")) {
            this.cargoTaxi = new CargoTaxi();
        }
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("cargoTaxi")) {
            this.cargoTaxis.add(this.cargoTaxi);
        } else {
            String elementVal = this.thisElement.toString();
            switch (qName){
                case "model":
                    this.cargoTaxi.setModel(elementVal);
                    break;
                case "price":
                    long price;
                    try {
                        price = Long.parseLong(elementVal);
                    }catch (NumberFormatException e){
                        price = Long.parseLong(elementVal.replaceAll("[^0-9]", ""));
                    }this.cargoTaxi.setVehiclePrice(price);
                    break;
                case "consumption":
                    int cons = parseData(elementVal);
                    this.cargoTaxi.setFuelConsumption(cons);
                    break;
                case "capacity":
                    int capacity = parseData(elementVal);
                    this.cargoTaxi.setCapacity(capacity);
                    break;
                case "shipping":
                    this.cargoTaxi.setShipping(elementVal);
            }
        }
        this.thisElement = new StringBuilder();
    }

    public void endDocument() throws SAXException {
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.thisElement.append(ch, start, length);
    }
    public int parseData(String elementVal){
        int var;
        try{
            var = Integer.parseInt(elementVal);
        }catch (NumberFormatException e){
            var = Integer.parseInt(elementVal.replaceAll("[^0-9]", ""));
        }
        return var;
    }

    public List<CargoTaxi> getResult(){
        return this.cargoTaxis;
    }
}