package kz.epam.tam.module3.lecture234.taxistation.exceptions;

public class InvalidListSizeException extends Exception {

    private Integer cause;

    public InvalidListSizeException(String message){
        super(message);
    }
    public InvalidListSizeException(String message,Integer cause){
        super(message);
        this.cause = cause;
    }

    public Integer getExceptionCause() {
        return cause;
    }
}
