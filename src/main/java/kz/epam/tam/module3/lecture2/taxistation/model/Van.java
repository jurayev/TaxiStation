package kz.epam.tam.module3.lecture2.taxistation.model;

public class Van extends TaxiStation {
    private static final String TYPE = "Van" ;
    private int numberOfSeats;
    private String fuelType;

    public Van(){super();}
    public Van(String model, long vehiclePrice, int fuelConsumption, int numberOfSeats, String fuelType){
        super(model, vehiclePrice, fuelConsumption);
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
    }
    public String getFuelType(){
        return fuelType;
    }
    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
    public int getNumberOfSeats(){
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats){
        this.numberOfSeats = numberOfSeats;
    }
///add getInfo method
    public String getInfo(){
        return super.getInfo() + ", Fuel: " + fuelType + ", Number of seats: " + numberOfSeats;
    }
}
