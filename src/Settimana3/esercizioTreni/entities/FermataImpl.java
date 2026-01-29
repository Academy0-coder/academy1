package Settimana3.esercizioTreni.entities;

public class FermataImpl implements Fermata {

    public final String stazione;
    public final int ora;
    public final int minuti;

    FermataImpl(String stazione, int ora, int minuti) {
        if(ora>=24 || ora<0 || minuti>=60 || minuti<0) {
            throw new IllegalArgumentException();
        }
        this.stazione = stazione;
        this.ora = ora;
        this.minuti = minuti;
    }

    public String getStazione() {
        return stazione;
    }

    public int getOra() {
        return ora;
    }

    public int getMinuti() {
        return minuti;
    }
}
