package Settimana3.esercizioTreni.entities;

import java.time.LocalTime;

public interface Passaggio {

    public String getStazione();
    public int getOra();
    public int getMinuti();
    public int ritardo();
}
