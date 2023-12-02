
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class day5
{
    public static void main(String [] args)
    {
        try {
            hydrothermal();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 

    }

    public static void hydrothermal() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day5.txt");
        Scanner inFile = new Scanner(fr);

        int [][] diagram = new int [1000][1000];
        for (int i = 0; i < diagram.length; i++){
            for (int j = 0; j < diagram[i].length; j++){
                diagram[i][j] = 0;
            }
        }
        // Read lines from the file till end of file
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();
            String [] split = line.split(" ");
            String [] temp1 = split[0].split(",");
            String [] temp2 = split[2].split(",");
            int [] x = {Integer.parseInt(temp1[0]), Integer.parseInt(temp2[0])};
            int [] y = {Integer.parseInt(temp1[1]), Integer.parseInt(temp2[1])};

            if (x[0] == x[1]){
                if (y[0] < y[1]){
                    for(int i = y[0]; i <= y[1]; i++){
                        diagram[i][x[0]] = diagram[i][x[0]] + 1;
                    }
                }else {
                    //das Gleiche nochmal aber vertauschtem 1 und 0
                    for(int i = y[1]; i <= y[0]; i++){
                        diagram[i][x[0]] = diagram[i][x[0]] + 1;
                    }
                }
                
            }else if(y[0] == y[1]){
                if (x[0] < x[1]){
                    for(int i = x[0]; i <= x[1]; i++){
                        diagram[y[0]][i] = diagram[y[0]][i] + 1;
                    }
                }else {
                    //das Gleiche nochmal aber vertauschtem 1 und 0
                    for(int i = x[1]; i <= x[0]; i++){
                        diagram[y[0]][i] = diagram[y[0]][i] + 1;
                    }
                }

            }else if(x[0] < x[1]){
                int currentX = x[0];
                if (y[0] < y[1]){
                    for(int i = y[0]; i <= y[1]; i++){
                        diagram[i][currentX] = diagram[i][currentX] + 1;
                        currentX++;
                    }
                }else{
                    for(int i = y[0]; i >= y[1]; i--){
                        diagram[i][currentX] = diagram[i][currentX] + 1;
                        currentX++;
                    }
                }
            }else if(x[0] > x[1]){
                int currentX = x[0];
                if (y[0] < y[1]){
                    for(int i = y[0]; i <= y[1]; i++){
                        diagram[i][currentX] = diagram[i][currentX] + 1;
                        currentX--;
                    }
                }else{
                    for(int i = y[0]; i >= y[1]; i--){
                        diagram[i][currentX] = diagram[i][currentX] + 1;
                        currentX--;
                    }
                }
            }
        }
        inFile.close();

        int amount = 0;

        for(int i = 0; i < diagram.length; i++){
            for(int j = 0; j < diagram[0].length; j++){
                if (diagram[i][j] >= 2){
                    amount = amount + 1;
                }
            }
        }
        System.out.println(amount);
    }
}
