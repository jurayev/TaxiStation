package kz.epam.tam.module3.lecture234.taxistation.model;

public class Car extends Vehicle {
    private String bodyType;
    private  String useAs;
    public Car(){super();}

    public Car(String model, long vehiclePrice,int fuelConsumption,String bodyType,String useAs){
        super(model, vehiclePrice, fuelConsumption);
        this.bodyType = bodyType;
        this.useAs = useAs;
    }

    public String getBodyType(){
        return bodyType;
    }
    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }

    public String getInfo(){
        return super.getInfo() + ", Body type: " + this.bodyType + ", Usage: " + this.useAs;
    }
}
