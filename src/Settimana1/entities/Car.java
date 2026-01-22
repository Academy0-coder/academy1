package Settimana1.entities;

import java.time.Year;

public class Car {

    private final String make;
    private final String model;
    private final Year year;
    private final Plate plate;
    private Gear gear;
    private int price;

    public Car(String make, String model, Year year, Plate plate, Gear gear) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.gear = gear;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }

    public Plate getPlate() {
        return plate;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "marca: " + make + '\'' +
                ", modello: " + model + '\'' +
                ", anno: " + year +
                ", targa: " + plate.getPlateNumber() +
                ", cambio " + gear.translate() +
                '}';
    }


}
