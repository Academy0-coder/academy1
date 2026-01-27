package Settimana2.esercizioNegozio.entities;

import java.text.NumberFormat;
import java.util.Locale;

public class Prodotto extends Fatturabile {

    private double prezzo;
    private int quantita;
    final private Genere genere;

    public Prodotto(int id, String nome, double prezzo, int quantita, Genere genere) {
        super(id, nome);
        this.genere = genere;
        this.quantita = quantita;
        this.prezzo = prezzo;
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
        message.append("Prodotto: "+getNome()+": ")
                .append("Id = "+getId()+", ")
                .append("quantità ancora in magazzino = "+getQuantita());
        return message.toString();
    }

    @Override
    public String toStringSpesa(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+": ")
                .append("spesa effettuata = "+NumberFormat.getCurrencyInstance(Locale.ITALY).format(getPrezzo()* getAcquistiTotali()));

        return response.toString();

    }

    @Override
    public String toStringAcquisti(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+": ")
                .append("acquisti totali = "+ getAcquistiTotali());

        return response.toString();

    }

}
