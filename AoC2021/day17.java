import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class day17 {
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
        String line = inFile.nextLine();
        inFile.close();
        line = line.replaceAll("[^\\d]", " ");
        line = line.trim();
        line = line.replaceAll(" +", " ");
        int [] targetArea = {Integer.parseInt(line.split(" ")[0]),
                            Integer.parseInt(line.split(" ")[1]),
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),};
        
        
    }
}

