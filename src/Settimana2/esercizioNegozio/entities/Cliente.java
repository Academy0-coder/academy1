package Settimana2.esercizioNegozio.entities;

import java.util.List;
import java.util.Map;

public class Cliente {

    private int id;
    private String nome;
    private String cognome;
    private Map<Prodotto,Integer> mappaProdotti;
    private List<Fattura> listaFatture;

    public Cliente(int id, String nome, String cognome, Map<Prodotto, Integer> mappaProdotti, List<Fattura> listaFatture) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mappaProdotti = mappaProdotti;
        this.listaFatture = listaFatture;
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
        response.append(nome)
                .append(" ")
                .append(cognome)
                .append(":\n");

        if(mappaProdotti.isEmpty()){
            response.append("Nessun prodotto acquistato");
        }

        else{
            response.append("Acquistati prodotti di ")
                    .append(mappaProdotti.size())
                    .append(" tipologie diverse\n");
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


}
