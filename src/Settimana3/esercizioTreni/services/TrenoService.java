package Settimana3.esercizioTreni.services;

import Settimana3.esercizioTreni.entities.Categoria;
import Settimana3.esercizioTreni.entities.Passaggio;
import Settimana3.esercizioTreni.entities.Percorso;
import Settimana3.esercizioTreni.entities.TrenoImpl;

import java.time.LocalDate;

public class TrenoService extends TrenoImpl {


    public TrenoService(Percorso percorso, LocalDate data) {
        super(percorso, data);
    }


    @Override
    public int ritardoMassimo() {
        return getPassaggi().stream().mapToInt(Passaggio::ritardo).max().orElse(0);
    }

    @Override
    public int ritardoFinale() {
        return getPassaggi().getLast().ritardo();
    }
}
