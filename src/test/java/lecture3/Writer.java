package lecture3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeToFileTest() {
        String str;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\automation\\TaxiStation\\results.txt"));
            String text = "ashdaysdy\n213\nsjdjasdjkasjdn\nasdhahsd12";
            writer.newLine();
            writer.append("text to append1");
            writer.flush();
            writer.newLine();
            writer.append("text to append2");
            writer.flush();
            writer.newLine();
            writer.append("text to append3");
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
