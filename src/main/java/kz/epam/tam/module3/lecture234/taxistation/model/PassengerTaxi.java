package kz.epam.tam.module3.lecture234.taxistation.model;

public class PassengerTaxi extends Vehicle {
    private String bodyType;
    private  String taxiClass;

    public PassengerTaxi(){super();}

    public PassengerTaxi(String model, long vehiclePrice, int fuelConsumption, String bodyType, String taxiClass){
        super(model, vehiclePrice, fuelConsumption);
        this.bodyType = bodyType;
        this.taxiClass = taxiClass;
    }

    public String getBodyType(){
        return bodyType;
    }
    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }
    public String getTaxiClass() {
        return taxiClass;
    }

    public void setTaxiClass(String taxiClass) {
        this.taxiClass = taxiClass;
    }
    public String getInfo(){
        return super.getInfo() + ", Body type: " + this.bodyType + ", Class: " + this.taxiClass;
    }
}
