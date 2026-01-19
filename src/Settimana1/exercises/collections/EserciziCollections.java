package Settimana1.exercises.collections;

import Settimana1.entities.Car;
import Settimana1.entities.Gear;
import Settimana1.entities.Plate;

import java.util.List;

public class EserciziCollections {

    public static void main (String[] args){

        // 1  Write code that allows you to model and store a collection of at least 5 cars and keeps
        // them in the order in which they were entered. Print them out to the screen also.

        Car car1 = new Car("Audi","A4",2020, new Plate("EE222GG"), Gear.AUTOMATIC);
        Car car2 = new Car("Fiat","Panda",2023, new Plate("FF999LL"), Gear.MANUAL);
        Car car3 = new Car("Nissan","Qashqai",2017, new Plate("DD111FH"), Gear.AUTOMATIC);
        Car car4 = new Car("Toyota","Yaris",2019, new Plate("EA001EA"), Gear.MANUAL);
        Car car5 = new Car("Toyota","Corolla",2024, new Plate("FY011YF"), Gear.AUTOMATIC);

        List<Car> carDealer = List.of(car1,car2,car3,car4,car5);

        carDealer.stream().forEach(System.out::println);




    }
}
