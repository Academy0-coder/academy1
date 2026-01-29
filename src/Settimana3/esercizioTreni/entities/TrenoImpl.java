package Settimana3.esercizioTreni.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class TrenoImpl implements Treno {

    private final Percorso percorso;
    private List<Passaggio> passaggi;
    private final LocalDate data;
    private boolean arrivato;

    public TrenoImpl(Percorso percorso, LocalDate data) {
        this.percorso = percorso;
        passaggi = new ArrayList<>();
        this.data = data;
    }

    @Override
    public Percorso getPercorso() {
        return percorso;
    }

    @Override
    public int getGiorno(){
        return data.getDayOfMonth();
    };

    @Override
    public int getMese(){
        return data.getMonthValue();
    };

    @Override
    public int getAnno(){
        return data.getYear();
    };

    @Override
    public void registraPassaggio(Fermata fermata, int ora, int minuti, boolean last){
        arrivato = last;
        passaggi.add(new PassaggioImpl(this, fermata, ora, minuti));
    };

    @Override
    public boolean arrivato() {
        return arrivato;
    }

    public List<Passaggio> getPassaggi() {
        return passaggi;
    }
}
