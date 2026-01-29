package Settimana3.esercizioTreni.entities;

public class PassaggioImpl implements Passaggio {

    Treno treno;
    Fermata fermata;
    int ora;
    int minuti;
    int ritardo;

    public PassaggioImpl(Treno treno, Fermata fermata, int ora, int minuti) {
        if(!treno.getPercorso().getFermate().contains(fermata)){
            throw new StazioneNonValida("Stazione non trovata");
        }

        if((ora>=24 || ora<fermata.getOra() || minuti>=60 || minuti<0)||
                (ora==fermata.getOra()&&minuti<fermata.getMinuti())) {
            throw new IllegalArgumentException();
        }
        this.treno=treno;
        this.fermata = fermata;
        this.ora = ora;
        this.minuti = minuti;
        ritardo = (ora- fermata.getOra())*60+minuti-fermata.getMinuti();

    }

    @Override
    public String getStazione() {
        return fermata.getStazione();
    }

    @Override
    public int getOra() {
        return ora;
    }

    @Override
    public int getMinuti() {
        return minuti;
    }

    @Override
    public int ritardo() {
        return ritardo;
    }
}
