import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day12 {
    public static void main(String [] args)
    {
        try {
            passagePathing();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
    }

    static int amount = 0;

    public static void passagePathing() throws IOException{
        FileReader fr = new FileReader("day12.txt");
        Scanner inFile = new Scanner(fr);
        HashMap <String, String> caves = new HashMap<>();
        while(inFile.hasNext()){
            String line = inFile.nextLine();
            String [] split = line.split("-");
            caves.put(split[0], caves.getOrDefault(split[0], "") + split[1] + ",");
            caves.put(split[1], caves.getOrDefault(split[1], "") + split[0] + ",");
        }
        inFile.close();
        ArrayList <String> ways = new ArrayList<>();
        boolean dSmall = true;
        recursiveWay("start", caves, ways, dSmall);
        System.out.println(amount);
    }

    public static void recursiveWay(String key, HashMap<String, String> caves, ArrayList<String> ways, boolean dSmall){
        String [] destinations = caves.get(key).split(",");
        if(!key.equals("end")){
            ways.add(key);
            for(int i = 0; i < destinations.length; i++){
                if(!ways.contains(destinations[i]) || destinations[i].substring(0,1).matches("[A-Z]")){
                    recursiveWay(destinations[i], caves, new ArrayList<>(ways), dSmall);
                }else if(!destinations[i].equals("start") && dSmall){
                    //dSmall = false;
                    recursiveWay(destinations[i], caves, new ArrayList<>(ways), false);
                }
            }
        }else{
            ways.add(key);
            System.out.println(ways);
            amount++;
        }
    }

    
}


