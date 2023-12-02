import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4
{
    public static void main(String [] args)
    {
        try {
            bingo();
        }
        catch(IOException e){
            System.out.println("Bratwurst");
        } 

    }

    public static void bingo() throws IOException{
        // Open the file.
        FileReader fr = new FileReader("day4.txt");
        Scanner inFile = new Scanner(fr);

        String [][][] boards = new String [300][5][5];
        int board = -1;
        int row = 0;
        String draw = inFile.nextLine();
        String [] drawnN = draw.split(",");
        // Read lines from the file till end of file
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();
            line = line.replaceAll("  ", " ");

            if (line.length() != 0){
                if (line.substring(0,1).equals(" ")){
                    line = removeFirst(line);
                }
                boards[board][row]= line.split(" ");
                row++;
            }else {
                board++;
                row = 0;
            }

        }
        inFile.close();
        
        ArrayList<Integer> done = new ArrayList<Integer>();
        for (int l = 0; l < drawnN.length; l++){
            for(int i = 0; i < boards.length; i++){
                if (done.contains(i)){
                    continue;
                }
                int currentN = 0;
                for(int j = 0; j < boards[i].length; j++){
                    int columnMarked = 0;
                    for(int k = 0; k < boards[i][j].length && boards[i][j][k] != null; k++){
                        if (boards[i][j][k].equals(drawnN[l])){
                            boards[i][j][k] = "00";
                            currentN = Integer.parseInt(drawnN[l]);
                        }
                        if(boards[i][j][k].equals("00")){
                            columnMarked = columnMarked + 1;
                        }
                    }
                    if (columnMarked == boards[i][j].length){
                        int score = 0;
                        for(int m = 0; m < boards[i].length; m++){
                            for(int n = 0; n < boards[i][m].length; n++){
                                score = score + Integer.parseInt(boards[i][m][n]);
                            }
                        }
                        System.out.println(currentN*score);
                        done.add(i);
                    }
                }

                for(int k = 0; k < boards[i][0].length; k++){
                    int rowMarked = 0;
                    for(int j = 0; j < boards[i].length && boards[i][j][k] != null; j++){
                        if(boards[i][j][k].equals("00")){
                            rowMarked = rowMarked + 1;
                        }
                        if (rowMarked == boards[i].length){
                            int score = 0;
                            for(int m = 0; m < boards[i].length; m++){
                                for(int n = 0; n < boards[i][m].length; n++){
                                    score = score + Integer.parseInt(boards[i][m][n]);
                                }
                            }
                            System.out.println(currentN*score);
                            done.add(i);
                        }
                    }
                }
            }
        }
    }

    public static String removeFirst(String s){
        return s.substring(1);
    }

}
