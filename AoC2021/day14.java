import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day14 {
    public static void main(String [] args)
    {
        try {
            polymerization(10);
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
    }

    public static void polymerization(int steps) throws IOException{
        FileReader fr = new FileReader("day14.txt");
        Scanner inFile = new Scanner(fr);
        HashMap <String, String> pairInsertion = new HashMap<>();
        String template = inFile.nextLine();
        inFile.nextLine();
        while(inFile.hasNext()){
            String line = inFile.nextLine();
            String [] split = line.split(" ");
            pairInsertion.put(split[0], split[2]);
        }
        inFile.close();
        for(int i = 0; i < steps; i++){
            for(int j = 0; j < template.length()-1; j++){
                if(pairInsertion.containsKey(template.substring(j,j+2))){
                    template = template.substring(0,j+1) + pairInsertion.get(template.substring(j,j+2)) + template.substring(j+1);
                    j++;
                }
            }
        }
        HashMap<String, Long> amountEach = new HashMap<>();
        for (int i = 0; i < template.length(); i++) {
            if(amountEach.containsKey(template.substring(i,i+1))){
                amountEach.put(template.substring(i, i+1), amountEach.get(template.substring(i, i+1))+1);
            }else{
                amountEach.put(template.substring(i, i+1), (long) 1);
            }
        }

        long heighest = 0;
        long lowest = 10000;
        for (Map.Entry<String, Long> letter : amountEach.entrySet()) {
            if(letter.getValue() > heighest){
                heighest = letter.getValue();
            }
            if(letter.getValue() < lowest){
                lowest = letter.getValue();
            }
        }
        System.out.println(heighest-lowest);
    }

    
}



