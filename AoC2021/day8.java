import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class day8 {
    public static void main(String [] args)
    {
        try {
            sevenSegment();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 

    }

    public static void sevenSegment() throws IOException{

        FileReader fr = new FileReader("day8.txt");
        Scanner inFile = new Scanner(fr);
        int amount = 0;
        while(inFile.hasNext()){
            String line = inFile.nextLine();
            String [] split = line.split("\\|");
            String [] code = split[0].split(" ");
            Arrays.sort(code, Comparator.comparingInt(String::length));
            
            String [] output = split[1].split(" ");
            String displayN = "";
            for (int i = 1; i < output.length; i++){
                
                if(output[i].length() == 2){
                    displayN = displayN + "1";
                }else if(output[i].length() == 3){
                    displayN = displayN + "7";
                }else if(output[i].length() == 4){
                    displayN = displayN + "4";
                }else if(output[i].length() == 7){
                    displayN = displayN + "8";
                }else if(output[i].length() == 5){
                    int counter = 0;
                    for(int j = 0; j < output[i].length(); j++){
                        if (code[0].contains(output[i].substring(j,j+1))){
                            counter++;
                        }
                    }
                    if(counter == 2){
                        displayN = displayN + "3";
                    } else {
                        counter = 0;
                        for(int j = 0; j < output[i].length(); j++){
                            if (code[2].contains(output[i].substring(j,j+1))){
                                counter++;
                            }
                        }
                    
                        if (counter == 3){
                            displayN = displayN + "5";
                        }else{
                            displayN = displayN + "2";
                        }
                    }

                }else if(output[i].length() == 6){
                    int counter = 0;
                    for(int j = 0; j < output[i].length(); j++){
                        if (code[0].contains(output[i].substring(j,j+1))){
                            counter++;
                        }
                    }
                    if(counter != 2){
                        displayN = displayN + "6";
                    } else {
                        counter = 0;
                        for(int j = 0; j < output[i].length(); j++){
                            if (code[2].contains(output[i].substring(j,j+1))){
                                counter++;
                            }
                        }
                        if (counter == 4){
                            displayN = displayN + "9";
                        }else{
                            displayN = displayN + "0";
                        }
                    }
                }
            }
            amount = amount + Integer.parseInt(displayN);
        }
        inFile.close();
        System.out.println(amount);
    }
}
