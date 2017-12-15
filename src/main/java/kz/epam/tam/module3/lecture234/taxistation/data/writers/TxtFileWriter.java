package kz.epam.tam.module3.lecture234.taxistation.data.writers;

import kz.epam.tam.module3.lecture234.taxistation.property.PropertyProvider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileWriter {

    public void writeToFile(String data,boolean append) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(PropertyProvider.getProperty("resultstxt"),append));
            writer.write(data);
            writer.newLine();
            writer.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

