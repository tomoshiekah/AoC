import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day11 {
    public static void main(String [] args)
    {
        try {
            octupi(1000);
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
    }

    public static void octupi(int steps) throws IOException{
        int [][] energyLevels = fileToArray(10, 10, "day11.txt");
        int flashes = 0;
        for(int i = 1; i < steps; i++){
            for(int y = 0; y < energyLevels.length;y++){
                for(int x = 0; x < energyLevels[y].length; x++){
                    energyLevels[y][x]++;
                }
            }

            ArrayList <String> flashed = new ArrayList<>();
            for(int y = 0; y < energyLevels.length;y++){
                for(int x = 0; x < energyLevels[y].length; x++){
                    flashed = flash(y, x, flashed, energyLevels);
                }
            }
            if (flashed.size() == energyLevels.length*energyLevels[0].length){
                System.out.println("All Octupi flashed at step " + i);
                return;
            }
            flashes = flashes + flashed.size();
            for(String string : flashed){
                energyLevels[Integer.parseInt(string.substring(0,1))][Integer.parseInt(string.substring(1))] = 0;
            }
        }
        System.out.println(flashes);
    }

    public static int[][] fileToArray(int y, int x, String filename) throws IOException{
        FileReader fr = new FileReader(filename);
        Scanner inFile = new Scanner(fr);
        int [][] array = new int[y][x];
        int row = 0;
        while(inFile.hasNext()){
            String line = inFile.nextLine();
            for(int column = 0; column < line.length(); column++){
                array[row][column] = Integer.parseInt(line.substring(column, column+1));
            }
            row++;
        }
        inFile.close();
        return array;
    }

    public static ArrayList<String> flash(int y, int x, ArrayList<String> flashed, int[][] energyLevels){
        if(energyLevels[y][x] > 9 && flashed.contains("" + y + x) == false){
            flashed.add("" + y + x);
            for(int i = -1;i < 2;i++){
                for(int j = -1; j < 2;j++){
                    if(y+i >= 0 && y+i < energyLevels.length && x+j >= 0 && x+j < energyLevels[0].length){
                        energyLevels[y+i][x+j]++;
                    }
                }
            }

            for(int i = -1;i < 2;i++){
                for(int j = -1; j < 2;j++){
                    if(y+i >= 0 && y+i < energyLevels.length && x+j >= 0 && x+j < energyLevels[0].length){
                        flash(y+i, x+j, flashed, energyLevels);
                    }
                }
            }
        }
        return flashed;
    }
}


