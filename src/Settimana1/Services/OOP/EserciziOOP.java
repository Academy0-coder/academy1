package Settimana1.Services.OOP;

import Settimana1.Services.StringService;

import java.util.Arrays;
import java.util.Random;

import static Settimana1.Services.Utility.*;

public class EserciziOOP {


    public static void main (String[] args){

        // 1. Use an Enum to model the days of the week and print them using a loop
        for(Days day: Days.values()){
            System.out.println(day);
        }

        // 1.1 Print them with the first letter capitalized (without changing the Enum constants)
        for(Days day: Days.values()){
            System.out.println(maiuscolize(day.toString()));
        }

        // 1.2 Alternate between printing the first letter capitalized or whatever letter is approximately
        //in the middle of the word. For example: Sunday, monDay, Tuesday, wednEsday, etc.
        boolean switcher = true;
        for(Days day: Days.values()){
            if(switcher){
                System.out.println(maiuscolize(day.toString()));
            }
            else{
                System.out.println(maiuscolizeCentered(day.toString()));
            }

            switcher = !switcher;

        }

        // 1.3 Print 10 randomly-chosen days of the week
        for(int i=0; i<10; i++){

            System.out.println(Days.values()[randomized(7)]);
        }

        // 2. Write code to print the following using only an Enum & loop without using any conditionals
        //(if/else/switch/etc.)
        //We eat pot roast on Sunday
        //We eat spaghetti on Monday
        //We eat tacos on Tuesday
        //We eat chicken on Wednesday
        //We eat meatloaf on Thursday
        //We eat hamburgers on Friday
        //We eat pizza on Saturday

        for(Days day: Days.values()){
            System.out.println("We eat "+day.getMeal()+" on "+day);
        }

        // 2.1 Do it again but capitalize the meal names too. “pot roast” should become “Pot Roast”.
        //(No solution provided because you’ve done this before in earlier exercise - but try to do
        //it without looking at previous work - for practice)
        for(Days day: Days.values()){
            System.out.println("We eat "+maiuscolizeAllFirst(day.getMeal())+" on "+day);
        }

        // Esercizio 3 prova
        System.out.println(getMealsForDays("friday, thursday, monday, saturday, tuesday"));


    }


    // 3 Write a method that takes the following input String (in bold) and returns the following
    //output String using an Enum like (print the output):
    //getMealsForDays(“friday, thursday, monday, saturday, tuesday”)
    //Output: hamburgers, meatloaf, spaghetti, etc…

    public static String getMealsForDays(String inputDays){
        String[] arrDays = inputDays.split(", ");
        for(int i=0; i<arrDays.length; i++){
            if(containsArr(enumToString(Days.values()),arrDays[i])){
                arrDays[i] = Days.values()[i].getMeal();
            }
            else{
                arrDays[i] = "wrong input";
            }
        }
        return stringRecomposerWithCommas(arrDays);
    }


}
