import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day13 {
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
        FileReader fr = new FileReader("day13.txt");
        Scanner inFile = new Scanner(fr);
        ArrayList <String> dots = new ArrayList<>();
        while(inFile.hasNext()){
            dots.add(inFile.nextLine());
            if(dots.get(dots.size()-1).equals("")){
                dots.remove(dots.size()-1);
                break;
            }

        }
        while(inFile.hasNext()){
            String [] instruction = inFile.nextLine().split("=");
            int foldline = Integer.parseInt(instruction[1]);
            if(instruction[0].contains("y")){
                for (int i = 0; i < dots.size();) {
                    int [] coordinate = {Integer.parseInt(dots.get(i).split(",")[0]), Integer.parseInt(dots.get(i).split(",")[1]),};
                    if(foldline < coordinate[1]){
                        int newY = coordinate[1] - 2 * (coordinate[1] - foldline);
                        if(!dots.contains(coordinate[0] + "," + newY)){
                            dots.add(coordinate[0] + "," + newY);
                        }
                        dots.remove(i);
                    }else{
                        i++;
                    }
                }
            }else{
                for (int i = 0; i < dots.size();) {
                    int [] coordinate = {Integer.parseInt(dots.get(i).split(",")[0]), Integer.parseInt(dots.get(i).split(",")[1]),};
                    if(foldline < coordinate[0]){
                        int newX = coordinate[0] - 2 * (coordinate[0] - foldline);
                        if(!dots.contains(newX + "," + coordinate[1])){
                            dots.add(newX + "," + coordinate[1]);
                        }
                        dots.remove(i);
                    }else{
                        i++;
                    }
                }
            }
        }
        inFile.close();
        for(int y = 0; y < 7; y++){
            for(int x = 0; x < 40; x++){
                if (dots.contains(x + "," + y)){
                    System.out.print("#");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
        System.out.println(dots.size());
    }
    
}



