package Settimana3.esercizioTreni.entities;

import java.time.LocalDate;
import java.util.List;

public interface Percorso {

    public String getCodice();
    public Categoria getCategoria();
    public List<Fermata> getFermate();
    public List<Treno> getTreni();
    public Treno getTreno(int registered);
    public void aggiungiFermata(String stazione, int ora, int minuti);
    public void aggiungiTreno(LocalDate data);
    public double ritardoMedio();
    public int ritardoMassimo();

}
