import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day16 {
    public static void main(String [] args)
    {
        try {
            packetDecoder();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
        
    }

    public static void packetDecoder() throws IOException{
        FileReader fr = new FileReader("day16.txt");
        Scanner inFile = new Scanner(fr);
        String line = inFile.nextLine();   
        inFile.close();
        line = hexinbinary(line);
        day16packet packet = new day16packet();
        packet.read(line);
        System.out.println(packet.combine());
        System.out.println(packet.allVersions());
        //int versions = 0;
        //ArrayList<Integer> values = new ArrayList<>();
        //System.out.println(decode(line, line.length(), values));
    }

    
    /*public static ArrayList<Integer> decode(String line, int length, ArrayList<Integer> values){
        //versions = versions + Integer.parseInt(line.substring(0,3),2);
        
        int first = 6;
        if(line.substring(3, 6).equals("100")){
            
            boolean end = false;
            while(!end){
                values.add(Integer.parseInt(line.substring(first, first+5),2));
                if(line.substring(first,first+1).equals("0")){
                    end = true;
                }
                first = first + 5;
                return values;
            }

        }else{
            if(line.substring(6, 7).equals("0")){
                int sublength = Integer.parseInt(line.substring(7,7+15), 2);
                decode(line.substring(7+15, 7+15+sublength), );
                first = 7+15;
            }else{
                int subamount = Integer.parseInt(line.substring(7, 7+11), 2);
                for(int i = 0; i < subamount; i++){
                    decode(line.substring(7+15, 7+15+), );
                }
                first = 7+11;
                
            }
        }

        /*if(line.substring(first).contains("1")){
            return decode(line.substring(first), versions);
        }else{
            return versions;
        }*
        
    }*/

    public static String hexinbinary(String hex){

        HashMap <String, String> hexBinary = new HashMap<>();
        hexBinary.put("0", "0000");
        hexBinary.put("1", "0001");
        hexBinary.put("2", "0010");
        hexBinary.put("3", "0011");
        hexBinary.put("4", "0100");
        hexBinary.put("5", "0101");
        hexBinary.put("6", "0110");
        hexBinary.put("7", "0111");
        hexBinary.put("8", "1000");
        hexBinary.put("9", "1001");
        hexBinary.put("A", "1010");
        hexBinary.put("B", "1011");
        hexBinary.put("C", "1100");
        hexBinary.put("D", "1101");
        hexBinary.put("E", "1110");
        hexBinary.put("F", "1111");

        String binary = "";
        for(int i = 0; i < hex.length(); i++){
            for (Map.Entry<String, String> map : hexBinary.entrySet()) {
                if(hex.substring(i, i+1).equals(map.getKey())){
                    binary = binary + map.getValue();
                    break;
                }
            }
        }

        return binary;
    }

}
