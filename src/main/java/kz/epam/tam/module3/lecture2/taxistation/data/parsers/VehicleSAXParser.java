package kz.epam.tam.module3.lecture2.taxistation.data.parsers;

import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class VehicleSAXParser extends DefaultHandler {

    private Car car;
    private List<Car> cars = new ArrayList<>();
    private Van van;
    private List<Van> vans = new ArrayList<>();
    private StringBuilder thisElement;

    public VehicleSAXParser() {
    }

    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with Cars Info...");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = new StringBuilder();
        if (qName.equals("car")) {
            this.car = new Car();
        }else if (qName.equals("van")) {
            this.van = new Van();
        }

    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("car")) {
            System.out.println(this.car.getInfo());
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
            }
        }
        /*if (qName.equals("van")) {
            System.out.println(this.van.getInfo());
            this.vans.add(this.van);
        } else {
            String elementVal = this.thisElement.toString();
            if (qName.equals("model")) {
                this.van.setModel(elementVal);
            } else if (qName.equals("price")) {
                this.van.setVehiclePrice(Long.parseLong(elementVal));
            } else if (qName.equals("consumption")) {
                this.van.setFuelConsumption(Integer.parseInt(elementVal));
            } else if (qName.equals("seats")) {
                this.van.setNumberOfSeats(Integer.parseInt(elementVal));
            } else if (qName.equals("ftype")) {
                this.van.setFuelType(elementVal);
            }
        }*/

        this.thisElement = new StringBuilder();
    }

    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML document with Cars Info...");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.thisElement.append(ch, start, length);
    }

    /*public Employee getEmployeeById(int id) {
        Employee result = null;
        Iterator var4 = this.employees.iterator();

        while(var4.hasNext()) {
            Employee employee = (Employee)var4.next();
            if (employee.getId() == id) {
                result = employee;
            }
        }*/

    public List<Car> getResultCar(){
        return this.cars;
    }
    public List<Van> getResultVan(){
        return this.vans;
    }
}


