package Settimana2.esercizioNegozio.entities;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Cliente extends Fatturabile {

    private String cognome;
    private Map<Prodotto,Integer> mappaProdotti;
    private List<Fattura> listaFatture;


    public Cliente(int id, String nome, String cognome, Map<Prodotto, Integer> mappaProdotti, List<Fattura> listaFatture) {
        super(id,nome);
        this.cognome = cognome;
        this.mappaProdotti = mappaProdotti;
        this.listaFatture = listaFatture;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Map<Prodotto, Integer> getMappaProdotti() {
        return mappaProdotti;
    }

    public void setMappaProdotti(Map<Prodotto, Integer> mappaProdotti) {
        this.mappaProdotti = mappaProdotti;
    }

    public List<Fattura> getListaFatture() {
        return listaFatture;
    }

    public void setListaFatture(List<Fattura> listaFatture) {
        this.listaFatture = listaFatture;
    }


    @Override
    public String toString(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+" ")
                .append(cognome+", ")
                .append("Id = "+getId())
                .append(":\n");

        if(mappaProdotti.isEmpty()){
            response.append("Nessun prodotto acquistato\n");
        }

        else{

            response.append("Acquistati prodotti di ")
                    .append(mappaProdotti.size())
                    .append(" tipologi"+(mappaProdotti.size()==1?"a":"e"))
                    .append(" divers"+(mappaProdotti.size()==1?"a":"e")+"\n");
            mappaProdotti
                    .keySet()
                    .stream()
                    .forEach(p -> response.append(p.getNome())
                            .append(": ")
                            .append(mappaProdotti.get(p))
                            .append("\n"));

        }

        return response.toString();
    }

    @Override
    public String toStringSpesa(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+" ")
                .append(getCognome()+": ")
                .append("spesa effettuata = "+NumberFormat.getCurrencyInstance(Locale.ITALY).format(getSpesaTotale()));

        return response.toString();

    }

    @Override
    public String toStringAcquisti(){
        StringBuilder response = new StringBuilder();
        response.append(getNome()+" ")
                .append(getCognome()+": ")
                .append(getAcquistiTotali()+" prodotti acquistati");

        return response.toString();

    }


}
