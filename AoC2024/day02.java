package AoC2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day02 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = readInput(args[0]);
        ArrayList<List<Integer>> levels = getLevels(input);

        System.out.println(amountOfSafeLevels(levels));
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

    public static ArrayList<List<Integer>> getLevels(ArrayList<String> input){
        ArrayList<List<Integer>> levels = new ArrayList<List<Integer>>();
        for (int i = 0; i < input.size(); i++) {
            List<String> strList = Arrays.asList(input.get(i).split(" "));
            List<Integer> intList = new ArrayList<Integer>();
            for(String s : strList) intList.add(Integer.valueOf(s));
            levels.add(intList);
        }
        return levels;
    }

    public static int amountOfSafeLevels(ArrayList<List<Integer>> levels){
        int safeLevels = 0;
        for (List<Integer> level : levels) {
            boolean safe = true;
            boolean descending;
            if(level.get(0) < level.get(1)){
                descending = true;
            }else{
                descending = false;
            }

            for (int i = 0; i < level.size()-1; i++) {
                int difference;
                if (descending) {
                    difference = level.get(i+1) - level.get(i);
                }else{
                    difference = level.get(i) - level.get(i+1);
                }

                if (difference < 1 || difference > 3){
                    safe = false;
                    break;
                }
            }

            if (safe){
                safeLevels++;
            }
        }
        
        return safeLevels;
    }
}
