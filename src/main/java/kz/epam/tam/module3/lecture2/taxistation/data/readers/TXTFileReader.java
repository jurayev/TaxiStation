package kz.epam.tam.module3.lecture2.taxistation.data.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TXTFileReader {
    private static final ResourceBundle configBundle = ResourceBundle.getBundle("filepath");

    public String[][] readData(){
        BufferedReader reader = null;
        String line;
        System.out.println("Please enter number of cars to be added");
        int n = new Scanner(System.in).nextInt();
        String[][] data= new String[n][];
        try{
            reader = new BufferedReader(new FileReader(configBundle.getString("txt")));
            for(int i = 0; i < n; i++){
                line = reader.readLine();
                data[i] = line.split(",");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return data;
    }
}
