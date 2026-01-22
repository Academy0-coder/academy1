package Settimana2.esercizioNegozio.entities;

import java.text.NumberFormat;

public class Prodotto {

    private int id;
    String nome;
    double prezzo;
    int quantità;


    public Prodotto(int id, String nome, double prezzo, int quantità) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
}
