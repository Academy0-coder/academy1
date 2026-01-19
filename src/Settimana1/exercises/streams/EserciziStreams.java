package Settimana1.exercises.streams;

import Settimana1.entities.Car;
import Settimana1.entities.Gear;
import Settimana1.entities.Plate;

import java.time.*;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class EserciziStreams {

    public static void main(String[] args) {

        // 1 Using the same car collection approach as in the last section’s exercises, create a
        //collection of cars but use the Streams API to print out only the cars’ model names.

        Car car1 = new Car("Audi","A4",Year.of(2020), new Plate("EE222GG"), Gear.AUTOMATIC);
        Car car2 = new Car("Fiat","Panda",Year.of(2023), new Plate("FF999LL"), Gear.MANUAL);
        Car car3 = new Car("Nissan","Qashqai",Year.of(2017), new Plate("DD111FH"), Gear.AUTOMATIC);
        Car car4 = new Car("Toyota","Yaris",Year.of(2019), new Plate("EA001EA"), Gear.MANUAL);
        Car car5 = new Car("Toyota","Corolla",Year.of(2024), new Plate("FY011YF"), Gear.AUTOMATIC);

        List<Car> carDealer = List.of(car1,car2,car3,car4,car5);

        carDealer.stream().forEach(c -> System.out.println(c.getModel()));

        // 2 How could you use the Streams API to filter out (not show) all cars made before a certain
        //year? (If you modeled Car year using the Year date/time class, it has a method isAfter())
        carDealer.stream().filter(c -> c.getYear().isAfter(Year.of(2018))).forEach(System.out::println);

        // 3 How could you create a stream of cars without first explicitly creating a collection of cars?
        Stream.of(car1,car2,car3,car4,car5).forEach(System.out::println);

        // 4 Add an additional integer price field to your Car class/record. Use Streams to add total cost
        //of all cars in your collection/stream.
        car1.setPrice(40000);
        car2.setPrice(10000);
        car3.setPrice(30000);
        car4.setPrice(15000);
        car5.setPrice(25000);
        double sumPrice = (double) carDealer.stream().mapToInt(Car::getPrice).sum();
        System.out.println(sumPrice);

        // 4.1 Use Streams to find average price of all cars (two ways to do this too) - no code
        //provided
        System.out.println(sumPrice/carDealer.size());
        System.out.println(carDealer.stream().mapToInt(Car::getPrice).average());

        // 5 Use the Streams API to sort a stream of cars in reverse order by model
        carDealer.stream().sorted((x,y)-> CharSequence.compare(y.getModel(), x.getModel())).forEach(System.out::println);

        // in alterntativa
        carDealer.stream().sorted(Comparator.comparing(Car::getModel).reversed()).forEach(System.out::println);

    }
}
