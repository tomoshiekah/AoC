import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3
{
    public static void main(String [] args)
    {
        try {
            diagnostic();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
        try {
            lifeSupport();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
    }

    public static String diagnostic() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day3.txt");
        Scanner inFile = new Scanner(fr);
        int [] zb = new int[12];
        int [] ob = new int[zb.length];
        String gamma = "";
        String epsilon = "";
        // Read lines from the file till end of file
        while (inFile.hasNext())
        {

            // Read the next line.
            String line = inFile.nextLine();
            char[] digits = line.toCharArray();
            for (int i = 0; i < digits.length; i++){
                if (digits[i] =='0'){
                    zb[i] = zb[i] + 1;
                }else{
                    ob[i] = ob[i] + 1;
                }
            }
        }
        inFile.close();
        for (int i = 0; i < zb.length; i++){
            if (zb[i] > ob [i]){
                gamma = gamma + "0";
                epsilon = epsilon + "1";
            }else{
                gamma = gamma + "1";
                epsilon = epsilon + "0";
            }
        }
        System.out.println(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
        return gamma;
    }

    public static void lifeSupport() throws IOException{
        String g = "";
        ArrayList<String> biNumbers = new ArrayList<String>(); // Create an ArrayList object

        FileReader fr = new FileReader("day3.txt");
        try (Scanner inFile = new Scanner(fr)) {
            // Read lines from the file till end of file
            while (inFile.hasNext())
            {
                biNumbers.add(inFile.nextLine());
            }
        }
        ArrayList<String> co2Rate = new ArrayList<>();
        co2Rate.addAll(biNumbers);
        for(int j = 0;biNumbers.size() > 1 && j < biNumbers.get(0).length(); j++){
            int zeros = 0;
            for(int i = 0; i < biNumbers.size(); i++){
                if (biNumbers.get(i).substring(j, j+1).equals("0")){
                    zeros = zeros + 1;
                }
            }
            
            if (zeros*2 > biNumbers.size()){
                g = "0";
            }else{
                g = "1";
            }
            for (int i = 0; i < biNumbers.size();){
                if (biNumbers.get(i).substring(j, j+1).equals(g) != true){
                    biNumbers.remove(i);
                } else {
                    i++;
                }
            }
            
        }
        
        for(int k = 0;co2Rate.size() > 1 && k < co2Rate.get(0).length(); k++){
            int zeros = 0;
            for(int i = 0; i < co2Rate.size(); i++){
                if (co2Rate.get(i).substring(k, k+1).equals("0")){
                    zeros = zeros + 1;
                }
            }
            
            if (zeros*2 > co2Rate.size()){
                g = "0";
            }else{
                g = "1";
            }
            
            for (int i = 0; i < co2Rate.size();){
                if (co2Rate.get(i).substring(k, k+1).equals(g)){
                    co2Rate.remove(i);
                } else {
                    i++;
                }
            }
        }
        
        
        System.out.println(Integer.parseInt(co2Rate.get(0), 2)*Integer.parseInt(biNumbers.get(0), 2));
    }
}
