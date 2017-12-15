package kz.epam.tam.module3.lecture234.taxistation.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {

    private static Properties prop;

    public static void readProperties(String filePath){
        InputStream input = null;
        prop = new Properties();
        try {
            input = new FileInputStream(filePath);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

}
