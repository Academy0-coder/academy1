package Settimana3.esercizioTreni.services;

import Settimana3.esercizioTreni.entities.Categoria;
import Settimana3.esercizioTreni.entities.Percorso;

import java.time.LocalDate;
import java.util.List;

public interface Orari {

    public void creaPercorso(String codice, Categoria categoria);
    public List<Percorso> getPercorsi();
    public Percorso getPercorso(String codice);
    public void nuovoTreno(String codice, LocalDate data);


}
