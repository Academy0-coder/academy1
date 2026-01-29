package Settimana3.esercizioTreni.entities;

import java.time.LocalDate;

public interface Treno {

    public Percorso getPercorso();
    public int getGiorno();
    public int getMese();
    public int getAnno();
    public void registraPassaggio(String stazione, int ora, int minuti);


}
