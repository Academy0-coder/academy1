package Settimana3.esercizioTreni.services;

import Settimana3.esercizioTreni.entities.Categoria;
import Settimana3.esercizioTreni.entities.Percorso;
import Settimana3.esercizioTreni.entities.PercorsoNonValido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OrariImpl implements Orari {

    private List<Percorso> percorsi;

    public OrariImpl() {
        percorsi = new ArrayList<>();
    }

    @Override
    public void creaPercorso(String codice, Categoria categoria) {

        List<Percorso> ononimi = percorsi.stream().filter(Percorso -> codice.equals(Percorso.getCodice())).toList();
        if(!ononimi.isEmpty()){
            throw new PercorsoNonValido("Esiste già un percorso con codice "+codice);
        }
        percorsi.add(new PercorsoService(codice,categoria));

    }

    @Override
    public List<Percorso> getPercorsi() {
        return percorsi;
    }

    @Override
    public Percorso getPercorso(String codice) {

        Optional<Percorso> percorso = percorsi.stream().filter(Percorso -> codice.equals(Percorso.getCodice())).findFirst();
        if(percorso.isPresent()){
            return percorso.get();
        }
        else{
            throw new PercorsoNonValido("Non esistono percorsi con codice "+codice);
        }
    }

    @Override
    public void nuovoTreno(String codice, LocalDate data) {

        Optional<Percorso> percorsoOpt = percorsi.stream().filter(Percorso -> codice.equals(Percorso.getCodice())).findFirst();
        if(percorsoOpt.isPresent()){
            Percorso percorso = percorsoOpt.get();
            percorso.aggiungiTreno(data);
        }
        else{
            throw new PercorsoNonValido("Non esistono percorsi con codice "+codice);
        }

    }
}
