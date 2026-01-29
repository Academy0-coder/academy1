package Settimana3.esercizioTreni.entities;

import java.util.List;

public interface Percorso {

    public String getCodice();
    public Categoria getCategoria();
    public void aggiungiFermata(String stazione, int ora, int minuti);
    public List<Fermata> getFermata();
    public List<Treno> getTreni();

}
