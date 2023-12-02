import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class nodaybubblesort
{
    public static void main(String [] args)
    {
        try {
            bubblesort();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 

    }

    public static void bubblesort() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("nodaybubblesort.txt");
        Scanner inFile = new Scanner(fr);
        String number = inFile.nextLine();
        inFile.close();

        String [] numberstring = number.split(",");
        int [] numbers = new int[numberstring.length];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(numberstring[i]);
        }

        int temp;
        for(int i = 0; i < numbers.length; i++){
            boolean swapped = false;
            for(int j = 1; j < numbers.length-i; j++){
                if(numbers[j-1] > numbers[j]){
                    temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}