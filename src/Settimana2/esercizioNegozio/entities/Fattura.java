package Settimana2.esercizioNegozio.entities;

import Settimana2.esercizioNegozio.services.Negozio;

import java.text.NumberFormat;
import java.util.Locale;

public class Fattura {

    private int id;
    private double imponibile;
    private double totale;
    private int idCliente;
    private int idProdotto;

    Negozio store = new Negozio();
    NumberFormat prezzo = NumberFormat.getCurrencyInstance(Locale.ITALY);

    public Fattura(int id, int idCliente, int idProdotto, int quantita) {
        this.id = id;
        imponibile = store.getProdotto(idProdotto).getPrezzo() * quantita;
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

    @Override
    public String toString(){

        Prodotto p = store.getProdotto(idProdotto);
        int quantita = Math.toIntExact(Math.round(imponibile / p.getPrezzo()));
        String nomeProdotto = p.getNome().toLowerCase();
        Cliente c = store.getCliente(idCliente);
        String desinenza;
        String verbo = quantita==1?"È":"Sono";

        if(quantita==1&&p.getGenere()==Genere.F){
            desinenza = "a";
        } else if (quantita==1&&p.getGenere()==Genere.M) {
            desinenza = "o";
        } else if (p.getGenere()==Genere.F) {
            desinenza = "e";
        } else {
            desinenza = "i";
        }

        StringBuilder message = new StringBuilder();
        message.append("Fattura n° "+id+":\n")
                .append("Intestata a "+c.getNome()+" "+c.getCognome()+"\n")
                .append(verbo+" stat"+desinenza+" comprat"+desinenza+" "+quantita+" "+nomeProdotto+"\n")
                .append("Imponibile: "+prezzo.format(imponibile)+"\n")
                .append("Totale(IVA inclusa): "+prezzo.format(totale)+"\n");

        return message.toString();

    }
}
