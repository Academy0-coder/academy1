package Settimana3.esercizioTreni.entities;

import Settimana3.esercizioTreni.services.TrenoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class PercorsoImpl implements Percorso {

    private final String codice;
    private final Categoria categoria;
    private List<Fermata> fermate;
    private List<Treno> treni;

    public PercorsoImpl(String codice, Categoria categoria) {
        this.codice = codice;
        this.categoria = categoria;
        fermate = new ArrayList<>();
        treni = new ArrayList<>();
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String getCodice() {
        return codice;
    }

    @Override
    public List<Fermata> getFermate() {
        return fermate;
    }

    @Override
    public List<Treno> getTreni() {
        return treni;
    }

    @Override
    public Treno getTreno(int registered){
        if(registered<=0||registered>treni.size()){
            return null;
        }
        return treni.get(registered-1);
    }

    @Override
    public void aggiungiFermata(String stazione, int ora, int minuti){
        fermate.add(new FermataImpl(stazione, ora, minuti));
    }

    @Override
    public void aggiungiTreno(LocalDate data){
        treni.add(new TrenoService(this, data));
    }



}
