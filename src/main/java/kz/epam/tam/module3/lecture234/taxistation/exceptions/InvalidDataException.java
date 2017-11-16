package kz.epam.tam.module3.lecture234.taxistation.exceptions;

public class InvalidDataException extends Exception {

    private String price;
    private String consumption;

    public InvalidDataException(String message,String price,String consumption){
        super(message);
        this.price = price;
        this.consumption = consumption;
    }

    public String getExceptionPrice() {
        return price;
    }
    public String getExceptionConsumption(){
        return consumption;
    }
}
