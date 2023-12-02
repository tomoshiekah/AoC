
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class day1
{
    public static void main(String [] args)
    {
        try {
            sonarSweep();
        }
        catch(IOException e){
            System.out.println("Blutwurst");
        } 
        
        try {
            sonarSlidingWindow();
        }
        catch(IOException e){
            System.out.println("Blutwurst");
        } 
    }

    public static void sonarSweep() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day1.txt");
        Scanner inFile = new Scanner(fr);
        int amount = -1;
        // Read lines from the file till end of file
        int [] floorDepth = new int [2];
        floorDepth[1] = 0;
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();
            // Display the line.

            floorDepth[0] = Integer.parseInt(line);

            if (floorDepth[0] > floorDepth[1]){
                amount = amount + 1;
            }

            floorDepth[1] = floorDepth[0];
        }
        inFile.close();
        System.out.println(amount);
    }

    public static void sonarSlidingWindow() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day1.txt");
        Scanner inFile = new Scanner(fr);
        int amount = 0;

        int [] floorDepth = {-1,-1,-1,-1};
        floorDepth[3] = -1;
        // Read lines from the file till end of file
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();

            floorDepth[3] = floorDepth[2];
            floorDepth[2] = floorDepth[1];
            floorDepth[1] = floorDepth[0];

            floorDepth[0] = Integer.parseInt(line);
            if (floorDepth[3] != -1){
                if (floorDepth[0] > floorDepth[3]){
                    amount = amount + 1;
                }
            }
        }
        inFile.close();
        System.out.println(amount);
    }
}

