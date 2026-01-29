package Settimana2.exercises.OOP;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EserciziOOP {

    // 4 Write a method that takes an input of 1 lowercase letter (and only 1 letter), like a - b - c - z,
    //    etc., and returns that letter’s ordinal position in the alphabet, i.e. a = 1, b = 2, c = 3… z =
    //            26. Do NOT use any conditionals (if/then/else/switch/etc.). Do not use an array. Write unit
    //    tests to test out the following inputs: a, z, w, f, c, h - which should return: 1, 26, 23, 6, 3, 8
    //    respectively
    public static int position (String letter){
        return letter.hashCode() - 96;
    }

    // 5 Write a method that does the opposite of #4 - taking a number, 1-26, and returns a
    //lowercase letter. 1 would return a, 2 = b, 26 = z, etc
    public static int reversedPosition (String letter){
        return 123 - letter.hashCode();
    }

    // 6 Write a method that takes the following inputs and returns the corresponding outputs:
    //8->0, 7->1, 6->2, 5->3, 4->4, 3->5, 2->6, 1->7
    public static int complementaryOfEight (int n){
        return 8-n;
    }

    // 7 If you modeled a chess board in Java using a two-dimensional array, how could you
    //convert chess notation, or coordinate notation of chess, to an element in that two-dimensional array?
    //For example, in the chess board image below, square a8 might map to
    //array[0][0], and h1 might map to array[7][7]. Make a method that takes an input String of a
    //chess coordinate and returns array coordinates. This exercise simply builds on the previous two.
    public class Chessboard{

        private String[][] chessboard;

        public Chessboard(){
            String[][] chessboard = new String[8][8];
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    String x = Character.toString('a'+i);
                    String y = Character.toString('8'-j);
                    chessboard[i][j] = x.concat(y);
                }
            }
            Pattern pat = Pattern.compile("[a-h][1-8]");
            this.chessboard=chessboard;
        }

        public String[][] getChessboard() {
            return chessboard;
        }

        public String getCell (String cell){
            if(Pattern.matches("[a-h][1-8]",cell)){
                int[] coord = new int[2];
                coord [0] = cell.toCharArray()[0]-'a';
                coord [1] = '8'-cell.toCharArray()[1];
                return String.valueOf(coord[0]).concat(",").concat(String.valueOf(coord[1]));

            }
            return null;
        }
    }


    static void main(String[] args) {

        EserciziOOP ex = new EserciziOOP();
        EserciziOOP.Chessboard chessboard = ex.new Chessboard();

        System.out.println(chessboard.getCell("a8"));
        System.out.println(chessboard.getCell("h1"));
        System.out.println(chessboard.getCell("g5"));
        System.out.println(chessboard.getCell("d4"));


    }





}
