package Settimana2.eserciziAggiuntivi.src.entities;

import java.util.List;
import java.util.Optional;

public class Position {

    public final int xCoord;
    public final int yCoord;

    public Position(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }

    // metodi che confrontano due punti, ne verificano l'adiacenza e in caso affermativo la rispettiva posizione
    public boolean isNorthOf(Position p){
        return this.samePosition(p.northOf());
    }

    public boolean isSouthOf(Position p){
        return this.samePosition(p.southOf());
    }

    public boolean isEastOf(Position p){
        return this.samePosition(p.eastOf());
    }

    public boolean isWestOf(Position p){
        return this.samePosition(p.westOf());
    }


    // metodi che restituiscono la posizione adiacente a quella data in una specifica direzione
    public Position northOf(){

        return new Position(this.xCoord-1,this.yCoord);

    }

    public Position southOf(){

        return new Position(this.xCoord+1,this.yCoord);

    }

    public Position eastOf(){

        return new Position(this.xCoord,this.yCoord+1);

    }

    public Position westOf(){

        return new Position(this.xCoord,this.yCoord-1);

    }

    // verifica se due posizioni hanno le stesse coordinate
    public boolean samePosition(Position p){
        return (this.xCoord==p.xCoord&&this.yCoord==p.yCoord);
    }


    @Override
    public String toString() {
        return "latitude: "+this.getX()+", longitude: "+this.getY();
    }
}
