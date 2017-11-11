package kz.epam.tam.module3.lecture2.task1.data.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TxtFileReader {

    public String[][] readFile(String absPath){
        BufferedReader reader = null;
        String line;
        System.out.println("Please enter number of Vehicle to be added");
        int n = new Scanner(System.in).nextInt();
        String[][] data= new String[n][];
        try{
            reader = new BufferedReader(new FileReader(absPath));
            for(int i = 0; i < n; i++){
                line = reader.readLine();
                data[i] = line.split(",");
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException ee){
            ee.getMessage();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException eee) {
                System.out.println(eee.getMessage());
            }
        }
        return data;
    }
}
