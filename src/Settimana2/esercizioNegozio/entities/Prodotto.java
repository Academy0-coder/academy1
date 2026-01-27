package Settimana2.esercizioNegozio.entities;

import java.text.NumberFormat;
import java.util.Locale;

public class Prodotto {

    private final int id;
    private final String nome;
    private double prezzo;
    private int quantita;
    private Genere genere;

    public int getQtaVenduta() {
        return qtaVenduta;
    }

    public void setQtaVenduta(int qtaVenduta) {
        this.qtaVenduta = qtaVenduta;
    }

    private int qtaVenduta;

    public Prodotto(int id, String nome, double prezzo, int quantita, Genere genere) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.genere = genere;
        this.qtaVenduta =0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Genere getGenere() {return genere;}

    @Override
    public String toString(){
        StringBuilder message = new StringBuilder();
        message.append("Prodotto: "+getNome()+", ")
                .append("Id = "+this.getId());
        return message.toString();
    }

    public String toStringSpesa(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+": ")
                .append("spesa effettuata = "+NumberFormat.getCurrencyInstance(Locale.ITALY).format(getPrezzo()*getQtaVenduta()));

        return response.toString();

    }

    public String toStringAcquisti(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+": ")
                .append("acquisti totali = "+getQtaVenduta());

        return response.toString();

    }

}
