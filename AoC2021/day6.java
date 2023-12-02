
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class day6
{
    public static void main(String [] args)
    {
        try {
            lanternfish(256);
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 

    }

    public static void lanternfish(int days) throws IOException{
        // Open the file.
        long [] amount = {0,0,0,0,0,0,0,0,0};
        FileReader fr = new FileReader("day6.txt");
        try (Scanner inFile = new Scanner(fr)){
            // Read the next line.
            String line = inFile.nextLine();
            String [] split = line.split(",");
            for (String str : split) {
                for(int i = 0; i < amount.length;i++){
                    if(Integer.parseInt(str) == i){
                        amount[i] = amount[i] + 1;
                    }
                }
                    
            }
            
        }

        long new0;

        for(int i = 0; i < days; i++){
            new0 = amount[1];
            for(int j = 1; j < amount.length-1; j++){
                amount[j] = amount[j+1];
                
            }
            amount[8] = amount[0];
            amount[6] = amount[6] + amount[0];
            amount[0] = new0;
        }
        
        long finalAmount = 0;
        for (int i = 0; i < amount.length; i++){
            finalAmount = finalAmount + amount[i];
        }

        System.out.println(finalAmount);
    }
}
