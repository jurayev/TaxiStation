package kz.epam.tam.module3.lecture2.taxistation.data.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtFileWriter {
    private static final String PATH_TO_RESULTS_TXT = "src\\main\\resources\\results.txt";

    public void writeToFile(long countCar, List<String> sortedByConsumptionList, String search) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_RESULTS_TXT));
            writer.write("All results are recorded" + "\nBudget is " + countCar + ";\nSort By fuel consumption:\n" + sortedByConsumptionList
                    + ";\n" + search);
            writer.newLine();
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}



