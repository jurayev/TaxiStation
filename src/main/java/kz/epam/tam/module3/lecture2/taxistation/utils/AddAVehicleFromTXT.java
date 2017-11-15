package kz.epam.tam.module3.lecture2.taxistation.utils;

import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import kz.epam.tam.module3.lecture2.taxistation.model.Van;
import kz.epam.tam.module3.lecture2.taxistation.data.readers.TXTFileReader;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidDataException;
import kz.epam.tam.module3.lecture2.taxistation.exception.InvalidListSizeException;

import java.util.ArrayList;
import java.util.List;


public class AddAVehicleFromTXT implements VehicleCreator{
    private  static final String PATH_TO_CAR_TXT = "src\\main\\resources\\car.txt";
    private  static final String PATH_TO_VAN_TXT = "src\\main\\resources\\van.txt";

    @Override
    public List<Car> fillBaseCharacteristicsCar() throws InvalidListSizeException, InvalidDataException  {
        List<Car> carList = new ArrayList<>();
        TXTFileReader data = new TXTFileReader();
        String[][] info = data.readData(PATH_TO_CAR_TXT);
        for(int i = 0; i < info.length; i++) {
            if (info[i].length != 4) {
                throw new InvalidListSizeException("A car must contain 4 obligatory fields.",info[i].length);
            }
            /*try{
                if(Long.parseLong(info[i][1]) <= 0 || Integer.parseInt(info[i][2]) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
            }catch (NumberFormatException e){
                if(Long.parseLong(info[i][1].replaceAll("[^0-9]", "")) <= 0 ||
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
            }*/
            try {
                if(Long.parseLong(info[i][1]) <= 0 || Integer.parseInt(info[i][2]) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
                carList.add(new Car(info[i][0], Long.parseLong(info[i][1]), Integer.parseInt(info[i][2]), info[i][3]));
            } catch (NumberFormatException e) {
                if(Long.parseLong(info[i][1].replaceAll("[^0-9]", "")) <= 0 ||
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
                carList.add(new Car(info[i][0], Long.parseLong(info[i][1].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")), info[i][3]));
            }
        }
        return carList;
    }
    public List<Van> fillBaseCharacteristicsVan() throws InvalidListSizeException, InvalidDataException{
        TXTFileReader data = new TXTFileReader();
        List<Van> vanList  = new ArrayList<>();
        String[][] info = data.readData(PATH_TO_VAN_TXT);
        for(int i =0; i < info.length; i++){
            if (info[i].length != 5) {
                throw new InvalidListSizeException("A van must contain 5 obligatory fields.");
            }
            try{
                if(Long.parseLong(info[i][1]) <= 0 || Integer.parseInt(info[i][2]) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
                vanList.add(new Van(info[i][0],Long.parseLong(info[i][1]),Integer.parseInt(info[i][2]),Integer.parseInt(info[i][3]),info[i][4]));
            }catch (NumberFormatException e){
                if(Long.parseLong(info[i][1].replaceAll("[^0-9]", "")) <= 0 ||
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")) <= 0){
                    throw new InvalidDataException("Validation has detected invalid input data. Price and consumption must be positive and not equals to zero. ",
                            info[i][1],info[i][2]);}
                vanList.add(new Van(info[i][0],Long.parseLong(info[i][1].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][2].replaceAll("[^0-9]", "")),
                        Integer.parseInt(info[i][3].replaceAll("[^0-9]", "")), info[i][4]));
            }
        }
        return vanList;
    }
    /*public static List<Car> fillBaseCharacteristicsCar(){
        Integer price = null;
        Integer cons = null;
        List<Car> carList  = new ArrayList<>();
        System.out.println("Type vehicle model");
        String model = sc.nextLine();
        System.out.println("Type vehicle body type");
        String btype = sc.nextLine();
        while(price == null || cons == null ){
            try{
                if(price == null){
                    System.out.println("Type vehicle price");
                    price = new Scanner(System.in).nextInt();
                    System.out.println("Type vehicle fuel consumption");
                    cons = new Scanner(System.in).nextInt();
                }
                else{
                    System.out.println("Type vehicle fuel consumption");
                    cons = new Scanner(System.in).nextInt();
                }

            }catch(InputMismatchException e){
                System.out.println("Oops,You have typed incorrect data type!Data must be only numeric");
            }
        }
        carList.add(new Car(model,price,cons,btype));
        return carList;
    }
    public static List<Van> fillBaseCharacteristicsVan(Scanner scanner){
        Integer price = null;
        Integer cons = null;
        List<Van> vanList  = new ArrayList<>();
        System.out.println("Type vehicle model");
        String model = sc.nextLine();
        try {
            System.out.println("Type vehicle price");
            price = scanner.nextInt();
            System.out.println("Type vehicle fuel consumption");
            cons = scanner.nextInt();
        }catch (InputMismatchException e){

        }
        System.out.println("Type vehicle fuel type");
        String ftype = sc.nextLine();
        System.out.println("Type vehicle number of seats");
        int nseats = scanner.nextInt();
        vanList.add(new Van(model,price,cons,nseats,ftype));
        return vanList;
    }*/
}
