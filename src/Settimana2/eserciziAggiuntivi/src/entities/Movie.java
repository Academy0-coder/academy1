package Settimana2.eserciziAggiuntivi.src.entities;

import java.time.Year;
import java.util.Optional;
import java.util.Set;

public class Movie {

    private int id;
    private String titolo;
    private Persona regista;
    private int durata;
    private Year anno;
    private boolean storiaVera;
    private Tipologia tipo;

    public Movie(int id, String titolo, Persona regista, int durata, Year anno, boolean storiaVera, Tipologia tipo) {
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
        this.durata = durata;
        this.anno = anno;
        this.storiaVera = storiaVera;
        this.tipo = tipo;
    }

    public Movie(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Persona getRegista() {
        return regista;
    }

    public void setRegista(Persona regista) {
        this.regista = regista;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Year getAnno() {
        return anno;
    }

    public void setAnno(Year anno) {
        this.anno = anno;
    }

    public boolean isStoriaVera() {
        return storiaVera;
    }

    public void setStoriaVera(boolean storiaVera) {
        this.storiaVera = storiaVera;
    }

    public Tipologia getTipo() {
        return tipo;
    }

    public void setTipo(Tipologia tipo) {
        this.tipo = tipo;
    }


}
