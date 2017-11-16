package kz.epam.tam.module3.lecture2.taxistation.data.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class TxtFileWriter {
    private static final ResourceBundle configBundle = ResourceBundle.getBundle("filepath");

    public void writeToFile(long countCar, List<String> sortedByConsumptionList, String search) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(configBundle.getString("resultstxt")));
            writer.write("All results are recorded" + "\nBudget is " + countCar + ";\nSort By fuel consumption:\n" + sortedByConsumptionList
                    + ";\n" + search);
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



