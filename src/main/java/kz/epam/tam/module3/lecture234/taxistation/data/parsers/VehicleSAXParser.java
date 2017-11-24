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
            if (qName.equals("model")) {
                this.car.setModel(elementVal);
            } else if (qName.equals("price")) {
                this.car.setVehiclePrice(Long.parseLong(elementVal));
            } else if (qName.equals("consumption")) {
                this.car.setFuelConsumption(Integer.parseInt(elementVal));
            } else if (qName.equals("btype")) {
                this.car.setBodyType(elementVal);
            } else if (qName.equals("usage")) {
                this.car.setUsage(elementVal);
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


