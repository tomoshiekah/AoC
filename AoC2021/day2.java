
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class day2
{
    public static void main(String [] args)
    {
        try {
            dive();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
        try {
            diveAim();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
    }

    public static void dive() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day2.txt");
        Scanner inFile = new Scanner(fr);
        int forward = 0;
        int down = 0;

        // Read lines from the file till end of file
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();
            String [] split = line.split(" ");
            if (split[0].equals("forward")){
                forward = forward + Integer.parseInt(split[1]);
            }else if(split[0].equals("down")){
                down = down + Integer.parseInt(split[1]);
            }else{
                down = down - Integer.parseInt(split[1]);
            }
        }
        inFile.close();
        System.out.println(forward*down);
    }
    
    public static void diveAim() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day2.txt");
        Scanner inFile = new Scanner(fr);
        int forward = 0;
        int aim = 0;
        int down = 0;

        // Read lines from the file till end of file
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();
            String [] split = line.split(" ");
            if (split[0].equals("forward")){
                forward = forward + Integer.parseInt(split[1]);
                down =down + aim * Integer.parseInt(split[1]);
            }else if(split[0].equals("down")){
                aim = aim + Integer.parseInt(split[1]);
            }else{
                aim = aim - Integer.parseInt(split[1]);
            }
        }
        inFile.close();
        System.out.println(forward*down);
    }
}
