package Settimana3.esercizioTreni.entities;

import java.util.List;

public class PercorsoImpl implements Percorso {

    private final String codice;
    private final Categoria categoria;

    public PercorsoImpl(String codice, Categoria categoria) {
        this.codice = codice;
        this.categoria = categoria;
    }

    public String getCodice() {
        return codice;
    };

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public void aggiungiFermata(String stazione, int ora, int minuti) {

    }

    @Override
    public List<Fermata> getFermata() {
        return List.of();
    }

    @Override
    public List<Treno> getTreni() {
        return List.of();
    }

    ;

}
