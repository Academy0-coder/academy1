package Settimana3.esercizioTreni.entities;

import java.time.LocalDate;

public interface Treno {

    public Percorso getPercorso();
    public int getGiorno();
    public int getMese();
    public int getAnno();
    public void registraPassaggio(Fermata fermata, int ora, int minuti, boolean last);
    public boolean arrivato();
    public int ritardoMassimo();
    public int ritardoFinale();


}
