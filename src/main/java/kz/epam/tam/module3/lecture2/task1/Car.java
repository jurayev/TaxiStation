package kz.epam.tam.module3.lecture2.task1;

public class Car extends TaxiStation {
    private static final String TYPE = "Car" ;
    private String bodyType;

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
///add getInfo method
    public String getInfo(){
        return super.getInfo() + ", Body type: " + this.bodyType;
    }
}
