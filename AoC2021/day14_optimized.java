import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day14_optimized {
    public static void main(String [] args)
    {
        try {
            polymerization(40);
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
    }

    public static void polymerization(long steps) throws IOException{
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

        HashMap <String, Long> combination = new HashMap<>();
        for (Map.Entry<String, String> hmap : pairInsertion.entrySet()){
            combination.put(hmap.getKey(), (long) 0);
        }

        for(int i = 0; i < template.length()-1; i++){
            combination.put(template.substring(i, i+2), combination.get(template.substring(i,i+2))+1);
        }

        for(long i = 0; i < steps; i++){
            HashMap<String, Long> currentStep = new HashMap<>();
            for (Map.Entry<String, Long> temp : combination.entrySet()) {
                currentStep.put(temp.getKey().substring(0,1) + pairInsertion.get(temp.getKey()), currentStep.getOrDefault(temp.getKey().substring(0,1) + pairInsertion.get(temp.getKey()), (long) 0) + temp.getValue());
                currentStep.put(pairInsertion.get(temp.getKey()) + temp.getKey().substring(1), currentStep.getOrDefault((pairInsertion.get(temp.getKey()) + temp.getKey().substring(1)), (long) 0) + temp.getValue());
            }
            combination = currentStep;
        }

        HashMap<String, Long> amountEach = new HashMap<>();
        for (Map.Entry<String, Long> temp : combination.entrySet()) {
            amountEach.put(temp.getKey().substring(0,1), amountEach.getOrDefault(temp.getKey().substring(0,1), (long) 0) + temp.getValue());
            amountEach.put(temp.getKey().substring(1), amountEach.getOrDefault(temp.getKey().substring(1), (long) 0) + temp.getValue());
        }

        long heighest = 0;
        long lowest = Long.MAX_VALUE;

        for (Map.Entry<String, Long> temp : amountEach.entrySet()) {
            if(temp.getValue()%2 != 0){
                temp.setValue((temp.getValue()-1)/2+1);
            }else{
                temp.setValue(temp.getValue()/2);
            }

            if(temp.getValue() > heighest){
                heighest = temp.getValue();
            }
            if(temp.getValue() < lowest){
                lowest = temp.getValue();
            }
        }
        System.out.println(heighest-lowest);
    }

    
}




