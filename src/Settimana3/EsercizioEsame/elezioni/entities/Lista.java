package Settimana3.EsercizioEsame.elezioni.entities;

import Settimana3.EsercizioEsame.elezioni.services.CandidatoNonValido;

import java.util.List;

public interface Lista {

    public String getNome();
    public String getMotto();

    public void assegnaCapolista(Cittadino capolista) throws CandidatoNonValido;
    public void aggiungiCandidato(Cittadino capolista) throws CandidatoNonValido;

    public Cittadino getCapolista();
    public List<Cittadino> getCandidati();
    public long getNumeroVoti();
    public void addVoto();
    public double getPercentualeVoti(List<Lista> liste);

}
