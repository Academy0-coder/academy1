package Settimana2.esercizioNegozio.entities;

import java.util.*;

public class Negozio {

    List<Prodotto> listaProdotti;
    List<Fattura> listaFatture;
    List<Cliente> listaClienti;

    Prodotto p1 = new Prodotto(1,"Pentole",26.43,1000);
    Prodotto p2 = new Prodotto(2,"Coperchi",5.78,500);
    Prodotto p3 = new Prodotto(3,"Diavoli",666.66,666);
    Prodotto p4 = new Prodotto(4,"Mestoli",8.02,200);
    Prodotto p5 = new Prodotto(5,"Scolapasta",11.00,700);
    Prodotto p6 = new Prodotto(6,"Vasi",74.00,10);
    Prodotto p7 = new Prodotto(7,"Centrini",9.99,10000);

    Cliente c1 = new Cliente(1,"Francesco","Rossi", new HashMap<>(), new ArrayList<>());
    Cliente c2 = new Cliente(2,"Roberto","Rossi", new HashMap<>(), new ArrayList<>());
    Cliente c3 = new Cliente(3,"Francesco","Neri", new HashMap<>(), new ArrayList<>());
    Cliente c4 = new Cliente(4,"Fernando","Bianchi", new HashMap<>(), new ArrayList<>());
    Cliente c5 = new Cliente(5,"Bernardo","Verdi", new HashMap<>(), new ArrayList<>());
    Cliente c6 = new Cliente(6,"Eugenio","Gialli", new HashMap<>(), new ArrayList<>());
    Cliente c7 = new Cliente(7,"Marisa","Blu", new HashMap<>(), new ArrayList<>());


    public Negozio() {
        listaProdotti = List.of(p1,p2,p3,p4,p5,p6,p7);
        listaFatture = new ArrayList<>();
        this.listaClienti = List.of(c1,c2,c3,c4,c5,c5,c6,c7);
    }

    public Cliente getCliente(int id){

        Optional<Cliente> opt = listaClienti.stream()
                .filter(Cliente -> Cliente.getId() == id)
                .findFirst();

        try{
            Cliente cl = opt.get();
            return cl;
        }
        catch(NullPointerException npe){
            npe.printStackTrace();
        }
        return null;
    }

    public Prodotto getProdotto(int id){

        Optional<Prodotto> opt = listaProdotti.stream()
                .filter(Prodotto -> Prodotto.getId() == id)
                .findFirst();

        try{
            Prodotto pr = opt.get();
            return pr;
        }
        catch(NullPointerException npe){
            npe.printStackTrace();
        }
        return null;
    }

    public void eseguiTransazione(int idCliente, int idProdotto, int quantita){

        listaFatture.add(new Fattura(listaFatture.size()+1, idCliente, idProdotto, quantita));

        Cliente cliente = getCliente(idCliente);
        Prodotto prodotto = getProdotto(idProdotto);
        Map<Prodotto,Integer> mapCliente = cliente.getMappaProdotti();

        if(mapCliente.containsKey(prodotto)){
            mapCliente.put(prodotto,mapCliente.get(prodotto)+quantita);
        }
        else{
            mapCliente.put(prodotto,quantita);
        }


    }

    public List<Prodotto> getProdotti() {
        return listaProdotti;
    }

    public void setProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public List<Fattura> getFatture() {
        return listaFatture;
    }

    public void setFatture(List<Fattura> listaFatture) {
        this.listaFatture = listaFatture;
    }

    public List<Cliente> getClienti() {
        return listaClienti;
    }

    public void setClienti(List<Cliente> listaClienti) {
        this.listaClienti = listaClienti;
    }

    public String stampaClienti(){
        StringBuilder response = new StringBuilder();
        listaClienti.stream()
                .forEach(Cliente -> response.append(Cliente.toString()).append("\n"));
        return response.toString();
    }


}
