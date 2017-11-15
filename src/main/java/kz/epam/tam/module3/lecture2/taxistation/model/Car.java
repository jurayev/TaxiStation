package kz.epam.tam.module3.lecture2.taxistation.model;

public class Car extends TaxiStation {
    private String bodyType;

    public Car(){super();}

    public Car(String model, long vehiclePrice,int fuelConsumption,String bodyType){
        super(model, vehiclePrice, fuelConsumption);
        this.bodyType = bodyType;
    }

    public String getBodytype(){
        return bodyType;
    }
    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }

    public String getInfo(){
        return super.getInfo() + ", Body type: " + this.bodyType;
    }
}
