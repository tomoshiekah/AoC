import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class day15 {
    public static void main(String [] args)
    {
        try {
            chiton();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
        
    }

    public static void chiton() throws IOException{
        FileReader fr = new FileReader("day14.txt");
        Scanner inFile = new Scanner(fr);
        while(inFile.hasNext()){
            //String line = inFile.nextLine();
            //todo oder so S
        }
        inFile.close();
    }
}
