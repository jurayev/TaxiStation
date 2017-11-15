package kz.epam.tam.module3.lecture2.taxistation.model;

public class TaxiStation {

    protected long vehiclePrice;
    protected int fuelConsumption;
    protected String model;


    public TaxiStation(){}
    public TaxiStation(String model,long vehiclePrice,int fuelConsumption){
        this.vehiclePrice = vehiclePrice;
        this.fuelConsumption = fuelConsumption;
        this.model = model;
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

    public String getInfo(){
        return "Model: " + this.model + ", Price: " + this.vehiclePrice + ", Fuel consumption: " + this.fuelConsumption;
    }
}
