package Settimana2.esercizioNegozio.entities;

import java.text.NumberFormat;

public class Fattura {

    private int id;
    private double imponibile;
    private double totale;
    private int idCliente;
    private int idProdotto;

    public Fattura(int id, int idCliente, int idProdotto, int quantita) {
        this.id = id;
        imponibile = idProdotto * quantita;
        totale = imponibile*1.22;
        this.idCliente = idCliente;
        this.idProdotto = idProdotto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImponibile() {
        return imponibile;
    }

    public void setImponibile(double imponibile) {
        this.imponibile = imponibile;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }
}
