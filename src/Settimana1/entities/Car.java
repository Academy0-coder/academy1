package Settimana1.entities;

public class Car {

    private final String make;
    private final String model;
    private final int year;
    private final Plate plate;
    private Gear gear;

    public Car(String make, String model, int year, Plate plate, Gear gear) {
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

    public int getYear() {
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
