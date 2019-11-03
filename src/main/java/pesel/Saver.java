package pesel;

import java.util.List;
import java.io.FileWriter;

public class Saver {

    //List<String> lines
    private String fileName;

    public Saver(String fileName){
        this.fileName = fileName;
    }

    public void Write(String data){
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Numbers saved properly.");
    }
}
