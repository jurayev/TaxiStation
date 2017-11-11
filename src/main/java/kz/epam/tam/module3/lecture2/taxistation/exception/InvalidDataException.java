package kz.epam.tam.module3.lecture2.taxistation.exception;

public class InvalidDataException extends Exception {

    private String price;  /// it is obligatory value which is used by budget counter method,so it has to be positive(excluding 0)
    private String consumption; /// it is obligatory value which is used by fuel consumption sorting method,so it has to be positive(excluding 0)

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
