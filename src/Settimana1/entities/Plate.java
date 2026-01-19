package Settimana1.entities;

import java.util.InputMismatchException;

public class Plate {

    private final String plateNumber;

    public Plate (String str){

        if(str.length()!=7){
            throw new InputMismatchException("La targa deve avere esattamente 7 cifre");
        }

        if(!str.equals(str.toUpperCase())){
            throw new InputMismatchException("Le cifre sulla targa devono essere tutte maiuscole");
        }

        if(!str.matches("[A-Z]{2}\\d{3}[A-Z]{2}")){
            throw new InputMismatchException("Sulla targa devono essere presenti 2 lettere seguite da 3 cifre numeriche seguite da altre 2 lettere");
        }

        this.plateNumber = str;

    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
