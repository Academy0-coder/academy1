package Settimana2.exercises.looseEnds;

import Settimana1.entities.Person;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EserciziLooseEnds {

    public static void main(String[] args) {

        // 3 Create a collection of at least five Person objects with first name & last name fields. Add a
        //few null objects to the collection in random places. Use an enhanced for-loop to iterate
        //over the collection and print out the first names of each person. Use Optional to prevent
        //NullPointerException and to print “Unknown” for the first names of null items.
        Person p1 = new Person("Giacomo","Rossi", LocalDate.of(1999,11,11));
        Person p2 = null;
        Person p3 = new Person("Giacomo","Verdi", LocalDate.of(2012,1,17));
        Person p4 = null;
        Person p5 = new Person("Pippo","Bianchi", LocalDate.of(1992,4,1));
        Person p6 = new Person("Pluto","Gialli", LocalDate.of(1977,11,11));
        Person p7 = new Person("Bo","Neri", LocalDate.of(1944,8,11));

        List<Optional<Person>> list = List.of
                (Optional.ofNullable(p1),
                        Optional.ofNullable(p2),
                        Optional.ofNullable(p3),
                        Optional.ofNullable(p4),
                        Optional.ofNullable(p5),
                        Optional.ofNullable(p6),
                        Optional.ofNullable(p7));

        list.stream()
                .forEach(person ->
                {String message = person.isPresent()?
                        String.format("%s %s",person.get().getName(),person.get().getSurname()):
                        ("Unknown");
                    System.out.println(message);
                });

        System.out.println("");

//        1. Use the Optional API to display “Unknown” for null entries and entries whose first name
//        is shorter than 3 characters.

        list.stream()
                .forEach(person ->
                {if(person.isPresent() &&
                        person.get().getName().length()>=3){
                    System.out.printf("%s %s\n",person.get().getName(),person.get().getSurname());
                }
                else{
                    System.out.println("Unknown");
                }

                });

        System.out.println();

//        4 Assuming you captured user input of a date/time into a String like “July 12, 1984 13:47:00”
//        and assuming that date/time occurred at GMT-8, write code to parse that String and
//        convert it to GMT-0

        LocalDate ld = LocalDate.of(1000,10,20);
        System.out.println(ld.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("ciao");

        LocalDateTime seconds = LocalDateTime.of(2000,12,2,12,43,51);
        System.out.println(seconds);

        Scanner keyboard = new Scanner(System.in);
        String input;
//        String input = keyboard.nextLine();
//
//        LocalDate ldate = LocalDate.parse(input,DateTimeFormatter.ofPattern("MMMM d,yyyy"));

//        System.out.println(input);

        input = keyboard.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime ltime = LocalTime.parse(input, formatter);

        System.out.println(input);


        keyboard.close();


    }

}
