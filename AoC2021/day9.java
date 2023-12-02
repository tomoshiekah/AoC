import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day9 {
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

        ArrayList <String> basin = new ArrayList<>();
        FileReader fr = new FileReader("day9.txt");
        Scanner inFile = new Scanner(fr);
        int [][] heightmap = new int [300] [300];
        ArrayList <String> deepest = new ArrayList<>();
        for(int i = 0; i < heightmap.length;i++){
            for(int j = 0; j < heightmap[i].length;j++){
                heightmap[i][j] = 9;
            }
        }
        int row = 1;
        while(inFile.hasNext()){
            String line = inFile.nextLine();
            for(int j = 0; j < line.length();j++){
                heightmap[row][j+1] = Integer.parseInt(line.substring(j,j+1));
            }
            row++;
        }
        inFile.close();

        int risk = 0;
        for(int i = 1; i < heightmap.length-1;i++){
            for(int j = 1; j < heightmap[i].length-1;j++){
                if(heightmap[i][j] < heightmap[i][j-1] && 
                heightmap[i][j] < heightmap[i][j+1] && 
                heightmap[i][j] < heightmap[i-1][j] && 
                heightmap[i][j] < heightmap[i+1][j]){
                    risk = risk + 1 + heightmap[i][j];
                    deepest.add(i + "," + j);
                }
            }
        }
        System.out.println("Risk, lowest points:" + risk);

        ArrayList <Integer> size = new ArrayList<>();
        for (String str : deepest) {
            int [] deePoint = {Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1])};
            basin.clear();
            size.add(tryingToGetSize(deePoint[0], deePoint[1], heightmap, basin));
        }
        Collections.sort(size, Collections.reverseOrder());
        System.out.println(size.get(0)*size.get(1)*size.get(2));
    }

    public static int tryingToGetSize(int deepY, int deepX, int [][] map, ArrayList <String> basin){
        if(map[deepY][deepX] != 9){
            if (basin.contains(deepY +"," + deepX) == false){
                basin.add(deepY + "," + deepX);
                tryingToGetSize(deepY-1, deepX, map, basin);
                tryingToGetSize(deepY+1, deepX, map, basin);
                tryingToGetSize(deepY, deepX-1, map, basin);
                tryingToGetSize(deepY, deepX+1, map, basin);
            }
        }
        return basin.size();
        
    }
}

