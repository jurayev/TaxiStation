package kz.epam.tam.module3.lecture234.taxistation.model;

public class CargoTaxi extends Vehicle {

    private int capacity;
    private String shipping;

    public CargoTaxi(){super();}
    public CargoTaxi(String model, long vehiclePrice, int fuelConsumption, int capacity, String shipping){
        super(model, vehiclePrice, fuelConsumption);
        this.capacity = capacity;
        this.shipping = shipping;
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
    public String getInfo(){
        return super.getInfo() + ", Capacity: " + this.capacity + ", Shipping: " + this.shipping;
    }
}

