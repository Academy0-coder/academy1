package Settimana3.esercizioEsame.elezioni.entities;

import java.util.Optional;

public class CittadinoImpl implements Cittadino {

    private final String nome;
    private final String cognome;
    private boolean votato;
    private boolean candidato;
    private boolean capolista;
    private long numeroVoti;
    private Optional<Lista> lista;

    public CittadinoImpl(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        votato = false;
        candidato = false;
        capolista = false;
        numeroVoti = 0;
        lista = null;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCognome() {
        return cognome;
    }

    @Override
    public boolean haVotato() {
        return votato;
    }

    @Override
    public boolean isCapolista() {
        return capolista;
    }

    @Override
    public boolean isCandidato() {
        return candidato;
    }

    @Override
    public long getNumeroVoti() {
        return numeroVoti;
    }

    @Override
    public Optional<Lista> getLista() {
        return lista;
    }

    @Override
    public void setVotato(boolean votato) {
        this.votato = votato;
    }

    @Override
    public void setCandidato(boolean candidato) {
        this.candidato = candidato;
    }

    @Override
    public void setCapolista(boolean capolista) {
        this.capolista = capolista;
    }

    @Override
    public void addVoto() {
        numeroVoti ++;
    }

    @Override
    public void setLista(Lista lista) {
        this.lista = Optional.of(lista);
    }
}
