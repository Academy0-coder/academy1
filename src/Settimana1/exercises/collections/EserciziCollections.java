package Settimana1.exercises.collections;

import Settimana1.entities.*;

import java.time.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class EserciziCollections {

    public static void main (String[] args){

        // 1  Write code that allows you to model and store a collection of at least 5 cars and keeps
        // them in the order in which they were entered. Print them out to the screen also.

        Car car1 = new Car("Audi","A4", Year.of(2020), new Plate("EE222GG"), Gear.AUTOMATIC);
        Car car2 = new Car("Fiat","Panda",Year.of(2023), new Plate("FF999LL"), Gear.MANUAL);
        Car car3 = new Car("Nissan","Qashqai",Year.of(2017), new Plate("DD111FH"), Gear.AUTOMATIC);
        Car car4 = new Car("Toyota","Yaris",Year.of(2019), new Plate("EA001EA"), Gear.MANUAL);
        Car car5 = new Car("Toyota","Corolla",Year.of(2024), new Plate("FY011YF"), Gear.AUTOMATIC);

        List<Car> carDealer = List.of(car1,car2,car3,car4,car5);

        carDealer.stream().forEach(System.out::println);

        // 2  Same as exercise 1 except we don’t care about retaining the order and we want to ensure
        //that duplicates will not exist.

        Set<Car> carSet = Set.of(car1,car2,car3,car4,car5);

        carSet.stream().forEach(System.out::println);

        // 3 Same as exercise 1 but associate an owner’s first name with each car. Do not add owner’s
        //name to your car model class.

        Map<Car,String> carOwners = new HashMap<>();
        carOwners.put(car1,"Peppe");
        carOwners.put(car2,"Gianni");
        carOwners.put(car3,"Peppe");
        carOwners.put(car4,"Maria");
        carOwners.put(car5,"Andrea");

        carOwners.keySet().stream()
                .forEach(getCarTable(carOwners));

        // 5 Allow the cars from exercise 2 to be printed in “natural” order by model.

        carsOrdered(carSet).forEach(System.out::println);

        // 6 Same as exercise 5 but allow program to remove a model by passing the model name as
        //an argument to the main() method.

        removeCar(carSet,"Corolla").forEach(System.out::println);





    }

    private static Stream<Car> carsOrdered(Set<Car> carSet) {
        return carSet.stream()
                .sorted(Comparator.comparing(Car::getMake));
    }

    private static Stream<Car> removeCar(Set<Car> carSet, String model) {
        return carsOrdered(carSet).filter(c -> !(c.getModel().equalsIgnoreCase(model)));
    }

    private static Consumer<Car> getCarTable(Map<Car, String> carOwners) {
        return c -> System.out.println(carOwners.get(c) + ": " + c.toString());
    }
}
