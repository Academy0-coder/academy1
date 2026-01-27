package Settimana2.exercises.OOP;

import java.util.Scanner;
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

    static void main(String[] args) {

    }





}
