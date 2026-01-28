package Settimana3.EsercizioEsame.elezioni.services;

import Settimana3.EsercizioEsame.elezioni.entities.*;


import java.util.Collection;
import java.util.List;

public interface Elezione {

    public Cittadino aggiungiElettore(String nome, String cognome) throws CittadinoNonValido;
    public Collection getElettori();
    public Cittadino getElettore(String nome, String cognome) throws CittadinoNonValido;

    public void registraLista(String nome, String motto);
    public Lista getLista(String nome);
    public List<Lista> getListe();

    public void vota(Cittadino votante, String lista, String nome, String cognome) throws TentatoDoppioVoto, TaglioNonPermesso, CittadinoNonValido;
    public void vota(Cittadino votante, String lista) throws TentatoDoppioVoto;

    public long getNumeroVotanti();
    public List<Lista> getRisultatiListe();
    public List<Cittadino> getRisultatiCandidati();

}
