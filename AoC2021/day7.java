import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day7 {
    public static void main(String [] args)
    {
        try {
            crabAlignment();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 

    }

    public static void crabAlignment() throws IOException{

        FileReader fr = new FileReader("day7.txt");
        Scanner inFile = new Scanner(fr);
        String line = inFile.nextLine();
        inFile.close();

        String [] split = line.split(",");
        ArrayList<Integer> oPosition = new ArrayList<>();
        for (String string : split) {
            oPosition.add(Integer.parseInt(string));
        }
        
        int [] fuel = new int [oPosition.size()];
        for (int n = 0; n < oPosition.size(); n++){
            for(int i = 0; i < oPosition.size(); i++){
                if (oPosition.get(i) < n){
                    for(int j = 0; j < (n-oPosition.get(i)); j++){
                        fuel[n] = fuel[n] + (n-oPosition.get(i)-j);
                    }
                }else{
                    for(int j = 0; j < (oPosition.get(i)-n); j++){
                        fuel[n] = fuel[n] + (oPosition.get(i)-n-j);
                    }
                }
            }
        }
        Arrays.sort(fuel);
        System.out.println(fuel[0]);
    }
}
