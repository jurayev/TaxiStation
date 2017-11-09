package kz.epam.tam.module3.lecture2.task1.data.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileWriter {

    public void writeToFile() {


        String str;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JavaProjects\\TaxiStation\\results.txt"));
            String text = "ashdaysdy\n213\nsjdjasdjkasjdn\nasdhahsd";
            writer.write(text);
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}


