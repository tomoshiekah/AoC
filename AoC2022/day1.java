import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        try {
            mostcalories();
        } catch (IOException e) {
            System.out.println("Blutwurst");
        }
    }

    static int amount[] = { -1, -1, -1 };

    public static void mostcalories() throws IOException {
        // Open the file.
        FileReader fr = new FileReader("day1.txt");
        Scanner inFile = new Scanner(fr);

        // Read lines from the file till end of file
        ArrayList<Integer> calories = new ArrayList<Integer>();
        int i = 0;
        calories.add(i, 0);

        while (inFile.hasNext()) {
            // Read the next line.
            String line = inFile.nextLine();
            // Display the line.
            if (!line.isEmpty()) {
                calories.set(i, calories.get(i) + Integer.parseInt(line));
            } else {
                höchstes(calories.get(i));
                i++;
                calories.add(i, 0);
            }
        }
        inFile.close();
        System.out.println(amount[0]);
        System.out.println(amount[0]+amount[1]+amount[2]);
    }

    public static void höchstes(int calories){
        if(calories > amount[0]){
            amount[2] = amount[1];
            amount[1] = amount[0];
            amount[0] = calories;
        }else if(calories > amount[1]){
            amount[2] = amount[1];
            amount[1] = calories;
        }else if(calories > amount[2]){
            amount[2] = calories;
        }
    }
}