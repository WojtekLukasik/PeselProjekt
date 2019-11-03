package pesel;

import java.util.List;
import java.io.FileWriter;

public class FileSaver {

    //List<String> lines
    private String fileName = "D:\\pesel.txt";

    public FileSaver(String fileName){
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
        System.out.println("Pliki zapisane poprawnie.");
    }

//        try{
//        FileWriter fw=new FileWriter("D:\\testout.txt");
//        fw.write("Welcome to javaTpoint.");
//        fw.close();
//    }catch(Exception e){System.out.println(e);}
//        System.out.println("Success...");


}
