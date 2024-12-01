package AoC2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day01 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = readInput(args[0]);
        int[][] locations = getLocations(input);

        System.out.println(getLocationDistance(locations));
        System.out.println(getSimilarityScore(locations));

    }

    public static ArrayList<String> readInput(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        ArrayList<String> lines = new ArrayList<>();

        String line = reader.readLine();
        while (line != null){
            lines.add(line);
            line = reader.readLine();
        }

        reader.close();
        return lines;
    }

    public static int[][] getLocations(ArrayList<String> lines){
        int[][] locations = new int[2][lines.size()];
        for (int i = 0; i < locations[0].length; i++) {
            String[] locationStrings = lines.get(i).split("   ");
            locations[0][i] = Integer.parseInt(locationStrings[0]);
            locations[1][i] = Integer.parseInt(locationStrings[1]);
        }

        Arrays.sort(locations[0]);
        Arrays.sort(locations[1]);

        return locations;
    }

    public static int getLocationDistance(int[][] locations){
        int distance = 0;
        for (int i = 0; i < locations[0].length; i++) {
            distance += Math.abs(locations[0][i] - locations[1][i]);
        }
        
        return distance;
    }

    public static int getSimilarityScore(int[][] locations){
        int similarityScore = 0;

        int rightIndex = 0;
        for (int leftNumber : locations[0]) {
            int amount = 0;
            while (rightIndex < locations[1].length) {
                if(leftNumber < locations[1][rightIndex]){
                    break;
                }else if (leftNumber == locations[1][rightIndex]){
                    amount++;
                }
                rightIndex++;
            }
            rightIndex -= amount;

            similarityScore += amount * leftNumber;
        }

        return similarityScore;
    }
    
}