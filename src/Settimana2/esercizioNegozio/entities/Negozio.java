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
    Prodotto p6 = new Prodotto(6,"Vasi",74.00,1);
    Prodotto p7 = new Prodotto(7,"Centrini",9.99,10000);

    Cliente c1 = new Cliente(1,"Francesco","Rossi", new HashMap<>(), new ArrayList<>());
    Cliente c2 = new Cliente(2,"Roberto","Rossi", new HashMap<>(), new ArrayList<>());
    Cliente c3 = new Cliente(3,"Francesco","Neri", new HashMap<>(), new ArrayList<>());
    Cliente c4 = new Cliente(4,"Fernando","Bianchi", new HashMap<>(), new ArrayList<>());
    Cliente c5 = new Cliente(5,"Bernardo","Verdi", new HashMap<>(), new ArrayList<>());
    Cliente c6 = new Cliente(6,"Eugenio","Gialli", new HashMap<>(), new ArrayList<>());
    Cliente c7 = new Cliente(7,"Marisa","Blu", new HashMap<>(), new ArrayList<>());

    //constructor
    public Negozio() {
        listaProdotti = List.of(p1,p2,p3,p4,p5,p6,p7);
        listaFatture = new ArrayList<>();
        listaClienti = List.of(c1,c2,c3,c4,c5,c6,c7);
    }

    //getter e setter
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


    // stampa menù interattivo
    public void getInteractiveMenu(){
        System.out.println("Digitare 1 per effettuare una nuova transazione\n" +
                "Digitare 2 per verificare la lista di prodotti, i loro id e le quantità rimaste in magazzino\n"+
                "Digitare 3 per verificare la lista di clienti e i loro id\n"+
                "Digitare 4 per verificare la lista di clienti con i prodotti già acquistati\n"+
                "Digitare 5 per verificare la lista di fatture\n"+
                "Digitare qualunque altra chiave per uscire dal programma");
    }

    // metodo 1
    public void eseguiTransazione(int idCliente, int idProdotto, int quantita){

        Cliente cliente = getCliente(idCliente);
        Prodotto prodotto = getProdotto(idProdotto);


        if(prodotto.getQuantità()<quantita){

            System.out.printf("Attenzione, transazione non possibile, sono rimasti solo %d %s in magazzino\n",
                    prodotto.getQuantità(),
                    prodotto.getNome().toLowerCase());
        }
        else {

            listaFatture.add(new Fattura(listaFatture.size()+1, idCliente, idProdotto, quantita));

            prodotto.setQuantità(prodotto.getQuantità()-quantita);


            Map<Prodotto,Integer> mapCliente = cliente.getMappaProdotti();

            if(mapCliente.containsKey(prodotto)){
                mapCliente.put(prodotto,mapCliente.get(prodotto)+quantita);
            }
            else{
                mapCliente.put(prodotto,quantita);
            }

            System.out.println("Transazione eseguita correttamente");

        }


    }

    // metodo 2
    public void visualizzaProdotti(){
        StringBuilder response = new StringBuilder();
        listaProdotti.stream()
                .forEach(Prodotto -> response
                        .append(Prodotto.getNome()+": ")
                        .append("Id = "+Prodotto.getId()+", ")
                        .append("quantità ancora in magazzino = "+Prodotto.getQuantità()+"\n"));

        System.out.println(response);
    }

    // metodo 3
    public void visualizzaClienti(){
        StringBuilder response = new StringBuilder();
        listaClienti.stream()
                .forEach(Cliente -> response
                        .append(Cliente.getNome()+" ")
                        .append(Cliente.getCognome()+": ")
                        .append("Id = "+Cliente.getId()+"\n"));

        System.out.println(response);
    }

    // metodo 4
    public void stampaClienti(){
        StringBuilder response = new StringBuilder();
        listaClienti.stream()
                .forEach(Cliente -> response.append(Cliente.toString()).append("\n"));
        System.out.println(response);
    }

    // metodo 5
    public void stampaFatture(){
        StringBuilder response = new StringBuilder();
        listaFatture.stream()
                .forEach(Fattura -> response.append(Fattura.toString()).append("\n"));
        System.out.println(response);
    }


    public Integer checkString(String str){
        try{
            int num = Integer.parseInt(str);
            return num;
        }
        catch(NumberFormatException e){
            System.out.println("L'id dev'essere un numero intero");
            return null;
        }

    }

    public Cliente getCliente(int id){

        Optional<Cliente> opt = listaClienti.stream()
                .filter(Cliente -> Cliente.getId() == id)
                .findFirst();

        try{
            Cliente cl = opt.get();
            return cl;
        }
        catch(NoSuchElementException e){
            System.out.printf("Non esistono clienti con numero di id %d\n",id);
            return null;
        }

    }

    public Cliente getCliente(String idS){

        return getCliente(checkString(idS));
    }

    public void findCliente(String id){

        int idN = Integer.parseInt(id);

        Optional<Cliente> opt = listaClienti.stream()
                .filter(Cliente -> Cliente.getId() == idN)
                .findFirst();

        Cliente cl = opt.get();
    }

    public void findProdotto(String id){

        int idN = Integer.parseInt(id);

        Optional<Prodotto> opt = listaProdotti.stream()
                .filter(Prodotto -> Prodotto.getId() == idN)
                .findFirst();

        Prodotto pr = opt.get();
    }

    public Prodotto getProdotto(int id){

        Optional<Prodotto> opt = listaProdotti.stream()
                .filter(Prodotto -> Prodotto.getId() == id)
                .findFirst();

        try{
            Prodotto pr = opt.get();
            return pr;
        }
        catch(NoSuchElementException e){
            System.out.printf("Non esistono prodotti con numero di id %d\n",id);
            return null;
        }

    }

    public Prodotto getProdotto(String idS){

        try{
            int id = Integer.parseInt(idS);
            return getProdotto(id);
        }
        catch(NumberFormatException e){
            System.out.println("L'id dev'essere un numero intero");
        }
        return null;
    }




}
