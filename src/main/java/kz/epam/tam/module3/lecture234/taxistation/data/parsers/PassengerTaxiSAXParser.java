package kz.epam.tam.module3.lecture234.taxistation.data.parsers;

import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PassengerTaxiSAXParser extends DefaultHandler {

    private PassengerTaxi passengerTaxi;
    private List<PassengerTaxi> passengerTaxis = new ArrayList<>();
    private StringBuilder thisElement;

    public PassengerTaxiSAXParser() {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = new StringBuilder();
        if (qName.equals("passengerTaxi")) {
            this.passengerTaxi = new PassengerTaxi();
        }
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("passengerTaxi")) {
            this.passengerTaxis.add(this.passengerTaxi);
        } else {
            String elementVal = this.thisElement.toString();
            switch (qName){
                case "model":
                    this.passengerTaxi.setModel(elementVal);
                    break;

                case "price":
                    long price;
                    try {
                        price = Long.parseLong(elementVal);
                    }catch (NumberFormatException e){
                        price = Long.parseLong(elementVal.replaceAll("[^0-9]", ""));
                    }this.passengerTaxi.setVehiclePrice(price);
                    break;
                case "consumption":
                    int cons;
                    try{
                        cons = Integer.parseInt(elementVal);
                    }catch (NumberFormatException e){
                        cons = Integer.parseInt(elementVal.replaceAll("[^0-9]", ""));
                    }
                    this.passengerTaxi.setFuelConsumption(cons);
                    break;
                case "btype":
                    this.passengerTaxi.setBodyType(elementVal);
                    break;
                case "class":
                    this.passengerTaxi.setTaxiClass(elementVal);
            }
        }
        this.thisElement = new StringBuilder();
    }

    public void endDocument() throws SAXException {
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.thisElement.append(ch, start, length);
    }

    public List<PassengerTaxi> getResult(){
        return this.passengerTaxis;
    }

}


