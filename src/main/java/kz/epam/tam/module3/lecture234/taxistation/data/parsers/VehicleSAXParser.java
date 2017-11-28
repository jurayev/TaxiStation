package kz.epam.tam.module3.lecture234.taxistation.data.parsers;

import kz.epam.tam.module3.lecture234.taxistation.model.Car;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class VehicleSAXParser extends DefaultHandler {

    private Car car;
    private List<Car> cars = new ArrayList<>();
    private StringBuilder thisElement;

    public VehicleSAXParser() {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = new StringBuilder();
        if (qName.equals("car")) {
            this.car = new Car();
        }
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("car")) {
            this.cars.add(this.car);
        } else {
            String elementVal = this.thisElement.toString();
            switch (qName){
                case "model":
                    this.car.setModel(elementVal);
                    break;
                case "price":
                    this.car.setVehiclePrice(Long.parseLong(elementVal));
                    break;
                case "consumption":
                    this.car.setFuelConsumption(Integer.parseInt(elementVal));
                    break;
                case "btype":
                    this.car.setBodyType(elementVal);
                    break;
                case "class":
                    this.car.setTaxiClass(elementVal);
            }
        }
        this.thisElement = new StringBuilder();
    }

    public void endDocument() throws SAXException {
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.thisElement.append(ch, start, length);
    }

    public List<Car> getResultCar(){
        return this.cars;
    }
}


