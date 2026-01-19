package Settimana1.entities;

public enum Gear {

    AUTOMATIC("automatico"),
    MANUAL("manuale");

    private final String traduzione;

    Gear(String traduzione){
        this.traduzione = traduzione;
    }

    public String translate(){
        return this.traduzione;
    }
}
