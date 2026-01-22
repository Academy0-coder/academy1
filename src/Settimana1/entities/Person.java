package Settimana1.entities;

import java.time.LocalDate;

public class Person {

    private String name;
    private String surname;
    private LocalDate dob;

    public Person(String name, String surname, LocalDate dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "nome ='" + name + '\'' +
                ", cognome ='" + surname + '\'' +
                ", data di nascita =" + dob;
    }
}
