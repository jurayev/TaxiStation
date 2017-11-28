package kz.epam.tam.module3.lecture234.taxistation.data.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class TxtFileWriter {

    public void writeToFile(long countCar,List<String> addedCarsList, List<String> sortedList, String search,String errors) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(ResourceBundle.getBundle("filepath").getString("resultstxt")));
            String data = "All operations are recorded.\n\n" + "Add cars to taxi station:\n" + addedCarsList + ";\n\nBudget is " + countCar + ";\n\nSort By fuel consumption:\n" + sortedList
                    + ";\n\n" + search +";\n\n";
            if(errors == null){
            writer.write(data);
            }else {
                writer.write(data + "Found Errors:\n" + errors);
            }
            writer.newLine();
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}



