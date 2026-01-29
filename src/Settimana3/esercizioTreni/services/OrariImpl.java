package Settimana3.esercizioTreni.services;

import Settimana3.esercizioTreni.entities.Percorso;

import java.time.LocalDate;
import java.util.List;

public class OrariImpl implements Orari {
    @Override
    public void creaPercorso(Percorso percorso) {

    }

    @Override
    public List<Percorso> getPercorsi() {
        return List.of();
    }

    @Override
    public Percorso getPercorso(String codice) {
        return null;
    }

    @Override
    public void nuovoTreno(String codice, LocalDate data) {

    }
}
