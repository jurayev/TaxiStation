package kz.epam.tam.module3.lecture234.taxistation.model;

public class Taxi {

    private long vehiclePrice;
    private int fuelConsumption;
    protected String model;
    private String bodyType;
    private String taxiClass;


    public Taxi(){}

    public Taxi(String model, long vehiclePrice, int fuelConsumption, String bodyType, String taxiClass){
        this.model = model;
        this.vehiclePrice = vehiclePrice;
        this.fuelConsumption = fuelConsumption;
        this.bodyType = bodyType;
        this.taxiClass = taxiClass;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public long getVehiclePrice(){
        return vehiclePrice;
    }
    public void setVehiclePrice(long vehiclePrice){
        this.vehiclePrice = vehiclePrice;
    }
    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getTaxiClass() {
        return taxiClass;
    }

    public void setTaxiClass(String taxiClass) {
        this.taxiClass = taxiClass;
    }

    public String getInfo(){
        return "Model: " + this.model + ", Price: " + this.vehiclePrice + ", Fuel consumption: " + this.fuelConsumption +
                ", Body type: " + this.bodyType + ", Class: " + this.taxiClass;
    }
}






