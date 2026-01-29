package Settimana3.esercizioTreni.entities;

public class StazioneNonValida extends RuntimeException {
    public StazioneNonValida(String message) {
        super(message);
    }
}
