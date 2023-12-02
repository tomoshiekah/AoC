import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day10 {
    public static void main(String [] args)
    {
        try {
            syntaxScoring();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 
        
    }

    public static void syntaxScoring() throws IOException{
        FileReader fr = new FileReader("day10.txt");
        Scanner inFile = new Scanner(fr);
        ArrayList <String> opened = new ArrayList<>();
        String closing = ")]}>";
        int score = 0;
        ArrayList <Long> completionScore = new ArrayList<>();
        while(inFile.hasNext()){
            String line = inFile.nextLine();
            for(int i = 0; i < line.length(); i++){
                if(closing.contains(line.substring(i,i+1))){
                    if(mirror(line.substring(i,i+1)).equals(opened.get(0))){
                        opened.remove(0);
                    }else{
                        score = score + ScoreTable(line.substring(i, i+1));
                        opened.clear();
                        break;
                    }
                }else{
                    opened.add(0,line.substring(i,i+1));
                }
            }
            if (opened.size() > 0){
                completionScore.add(0,(long) 0);
                for(int i = 0; i < opened.size();){
                    completionScore.set(0, completionScore.get(0)*5 + completionScoreTable(mirror(opened.get(0))));
                    opened.remove(0);
                }
            }
        }
        inFile.close();
        Collections.sort(completionScore);
        System.out.println("Score complete:" + completionScore.get(completionScore.size()/2));
        System.out.println("Score corrupted:" + score);
    }

    public static String mirror(String br){
        if(br.equals(")")){
            return "(";
        }else if(br.equals("]")){
            return "[";
        }else if(br.equals("}")){
            return "{";
        }else if(br.equals(">")){
            return "<";
        }else if(br.equals("(")){
            return ")";
        }else if(br.equals("[")){
            return "]";
        }else if(br.equals("{")){
            return "}";
        }else{
            return ">";
        }
    }

    public static int ScoreTable(String bracket){
        int [] scoreTable = {3,57,1197,25137};
        String [] brackets ={")","]","}",">"};
        for(int i = 0; i < scoreTable.length; i++){
            if(bracket.equals(brackets[i])){
                return scoreTable[i];
            }
        }
        return 0;
    }

    public static int completionScoreTable(String bracket){
        String [] brackets ={")","]","}",">"};
        for(int i = 0; i < brackets.length; i++){
            if(bracket.equals(brackets[i])){
                return i+1;
            }
        }
        return 0;
    }
}

