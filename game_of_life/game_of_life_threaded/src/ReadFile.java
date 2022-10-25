import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {

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
}
