package lecture3;

import org.testng.annotations.Test;

import java.io.*;

public class TestClass {

    @Test
    public void toIntegerTest(){
        Long var = 233123123124L;
        String str = var.toString();

    }

    @Test
    public void toIntTest(){
        String numberAsString = "1qwe";
        int number = Integer.parseInt(numberAsString);
        System.out.println("The number is: " + number);
    }

    @Test
    public void ReaderTest(){
        BufferedReader reader = null;
        String line = null;
        String[] data = {};
        try{
            reader = new BufferedReader(new FileReader("c:\\automation\\TaxiStation\\car.txt"));
            while ((line = reader.readLine()) != null) {
                 data = line.split(" ");
            }
            System.out.println(data[0] + data[1]);
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch (IOException e){
            e.getMessage();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ee) {
                System.out.println(ee.getMessage());
            }
        }

    }
    public static void writeToFileTest(String text) {
        String str;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\automation\\TaxiStation\\results.txt"));
            writer.newLine();
            writer.append(text);
            writer.flush();
            writer.newLine();
            writer.append(text);
            writer.flush();
            writer.newLine();
            writer.append(text);
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void writerTest(){
        TestClass.writeToFileTest("text to append1");
        TestClass.writeToFileTest("text to append2");
    }

    @Test
    public void replaceAllTest(){
        String somestr = "-asd5";
        System.out.println(somestr);
        String newstr = somestr.replaceAll("[^0-9]", "");
        System.out.println(newstr);

    }

}

