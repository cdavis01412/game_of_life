import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class FileManip {

    public static String read(String fileName) {
        String data = "";
        try{
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while(myReader.hasNextLine()) {
              data = data + myReader.nextLine() + "\n";
            }
            myReader.close();
         }   
        catch(FileNotFoundException e){
            System.out.println("File not found, check the path.");
        }
        return data;
    }

    public static void write(String content, String fileName){

        Writer output;
        try {
            output = new BufferedWriter(new FileWriter(fileName, true));
            output.write(content);        
            output.close();
        } catch (Exception e) {
            System.out.println("file could not be written");
        }
    }
}
