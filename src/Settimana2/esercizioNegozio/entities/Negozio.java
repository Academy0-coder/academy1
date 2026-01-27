package Settimana2.esercizioNegozio.entities;

import java.util.*;

public class Negozio {

    List<Prodotto> listaProdotti;
    List<Fattura> listaFatture;
    List<Cliente> listaClienti;

    Prodotto p1 = new Prodotto(1,"Pentole",26.43,374, Genere.F);
    Prodotto p2 = new Prodotto(2,"Coperchi",5.78,219, Genere.M);
    Prodotto p3 = new Prodotto(3,"Padelle",19.57,180, Genere.F);
    Prodotto p4 = new Prodotto(4,"Mestoli",5.02,63, Genere.M);
    Prodotto p5 = new Prodotto(5,"Scolapasta",9.00,120, Genere.M);
    Prodotto p6 = new Prodotto(6,"Vasi",28.49,29, Genere.M);
    Prodotto p7 = new Prodotto(7,"Centrini",3.99,250, Genere.M);
    Prodotto p8 = new Prodotto(8,"Lavatrici",639.00,17, Genere.F);
    Prodotto p9 = new Prodotto(9,"Pile AAA", 2.25, 155, Genere.F);

    Cliente c1 = new Cliente(1,"Francesco","Rossi", new HashMap<>(), new ArrayList<>());
    Cliente c2 = new Cliente(2,"Roberto","Rossi", new HashMap<>(), new ArrayList<>());
    Cliente c3 = new Cliente(3,"Francesco","Neri", new HashMap<>(), new ArrayList<>());
    Cliente c4 = new Cliente(4,"Fernando","Bianchi", new HashMap<>(), new ArrayList<>());
    Cliente c5 = new Cliente(5,"Bernardo","Verdi", new HashMap<>(), new ArrayList<>());
    Cliente c6 = new Cliente(6,"Eugenio","Gialli", new HashMap<>(), new ArrayList<>());
    Cliente c7 = new Cliente(7,"Marisa","Blu", new HashMap<>(), new ArrayList<>());

    //constructor
    public Negozio() {
        listaProdotti = List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9);
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
                "Digitare 2 per visualizzare informazioni relative ai clienti\n"+
                "Digitare 3 per visualizzare informazioni relative ai prodotti\n"+
                "Digitare 4 per visualizzare la lista delle fatture emesse\n"+
                "Digitare qualunque altra chiave per uscire dal programma");
    }


    public void getClientsMenu(){
        System.out.println("Digitare 1 per visualizzare la lista di clienti, i loro id e i prodotti che hanno acquistato\n"+
                "Digitare 2 per visualizzare il cliente che ha speso di più\n"+
                "Digitare 3 per visualizzare il cliente che ha acquistato più prodotti\n"+
                "Digitare 4 per visualizzare la lista di clienti in ordine decrescente per spesa effettuata\n"+
                "Digitare 5 per visualizzare la lista di clienti in ordine decrescente per numero di prodotti acqusitati\n"+
                "Digitare qualunque altra chiave per tornare al menù principale");
    }


    public void getProductsMenu(){
        System.out.println("Digitare 1 per visualizzare la lista di prodotti, i loro id, il loro prezzo e le quantità rimaste in magazzino\n"+
                "Digitare 2 per visualizzare il prodotto per cui è stati spesi più denaro\n"+
                "Digitare 3 per visualizzare il prodotto per cui sono state acquistate più unità\n"+
                "Digitare 4 per visualizzare la lista di prodotti in ordine decrescente per la quantità di denaro spesa\n"+
                "Digitare 5 per visualizzare la lsita di prodotti in ordine decrescente per il numero di unità acquistate\n"+
                "Digitare qualunque altra chiave per tornare al menù principale");
    }




    // metodo che serve ad eseguire una transazione
    // prende in input idCliente, idProdotto e quantità
    public void eseguiTransazione(int idCliente, int idProdotto, int quantita, boolean print){

        Cliente cliente = getCliente(idCliente);
        Prodotto prodotto = getProdotto(idProdotto);


        if(prodotto.getQuantita()<quantita){

            // se non ci sono abbastanza unità nel magazzino stampa messaggio di avviso e "annulla" l'operazione
            System.out.printf("Attenzione, transazione non possibile, sono rimasti solo %d %s in magazzino\n",
                    prodotto.getQuantita(),
                    prodotto.getNome().toLowerCase());
        }
        else {

            // crea una nuova fattura intestata al cliente, con il tipo di prodotto
            // la quantità di prodotti acquistati, il costo iniziale e quello maggiorato di IVA
            listaFatture.add(new Fattura(listaFatture.size()+1, idCliente, idProdotto, quantita));

            // aggiorna i dati relativi alle quantità vendute di quel prodotto
            prodotto.setQuantita(prodotto.getQuantita()-quantita);
            prodotto.setQtaVenduta(prodotto.getQtaVenduta()+quantita);
            cliente.setAcquistiTotali(cliente.getAcquistiTotali()+quantita);
            cliente.setSpesaTotale(cliente.getSpesaTotale()+quantita*prodotto.getPrezzo());

            Map<Prodotto,Integer> mapCliente = cliente.getMappaProdotti();


            // aggiorna la mappa che tiene traccia dei prodotti acquistati dai clienti e le loro rispettive quantità
            if(mapCliente.containsKey(prodotto)){
                mapCliente.put(prodotto,mapCliente.get(prodotto)+quantita);
            }
            else{
                mapCliente.put(prodotto,quantita);
            }

            if(print){
                System.out.println("Transazione eseguita correttamente");
            }


        }


    }

    // metodo che ha come fine quello di eseguire una transazione
    // prende in input i dati inseriti dall'utente (è legato al comando 1 del menù interattivo)
    public void eseguiTransazione(Scanner enter) {

        String input;

        // richiesta all'utente di inserire l'id del cliente e verifica che sia valido
        System.out.println("Inserisci l'id del cliente");
        input = enter.nextLine();
        try{
            this.getCliente(input);
        } catch (NumberFormatException e1){
            System.out.println("L'id dev'essere un numero intero");
            return;
        } catch (NoSuchElementException e2) {
            System.out.println("Non sono presenti clienti con quest'id nella lista");
            return;
        }

        int cl = this.getCliente(input).getId();

        // richiesta all'utente di inserire l'id del prodotto e verifica che sia valido
        System.out.println("Inserisci l'id del prodotto");
        input = enter.nextLine();
        try{
            this.getProdotto(input);
        } catch (NumberFormatException e1){
            System.out.println("L'id dev'essere un numero intero");
            return;
        } catch (NoSuchElementException e2) {
            System.out.println("Non sono presenti prodotti con quest'id nella lista");
            return;
        }

        int pr = this.getProdotto(input).getId();

        // richiesta all'utente di inserire la quantità di prodotti e verifica che sia valido
        System.out.println("Inserisci la quantità");
        input = enter.nextLine();
        try{
            Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            System.out.println("L'id dev'essere un numero intero");
            return;
        }

        int num = Integer.parseInt(input);

        // se i dati sono validi richiamiamo il metodo esegui transazione con i dati inseriti dall'utente
        this.eseguiTransazione(cl,pr,num, true);
    }

    // metodo legato al comando 2 del menù interattivo
    // apre a sua volta un menu interattivo
    public void visualizzaClienti(Scanner enter){

        getClientsMenu();
        String input = enter.nextLine();

        switch(input){

            case "1":
                stampaClienti();
                break;
            case "2":
                stampaClienteSpesaMassima();
                break;
            case "3":
                stampaClienteMassimiAcquisti();
                break;
            case "4":
                stampaClientiPerSpesa();
                break;
            case "5":
                stampaClientiPerAcquisti();
                break;
            default:

        }

    }

    // metodo che stampa i nomi dei clienti, i loro id e la lista di prodotti acquistati
    // (in ordine di come sono stati inseriti in lista e quindi id)
    // (metodo legato al comando 2.1 del menù interattivo)
    public void stampaClienti(){
        StringBuilder response = new StringBuilder();
        listaClienti.stream()
                .forEach(Cliente -> response.append(Cliente.toString()).append("\n"));
        System.out.print(response);
    }


    // metodo che stampa il nome del cliente che ha speso di più (con relativa spesa totale)
    // (legato al comando 2.2 del menù interattivo)
    public void stampaClienteSpesaMassima(){
        Optional<Cliente> cl = listaClienti.stream()
                .sorted(Comparator.comparing(Cliente::getSpesaTotale).reversed())
                .findFirst();

        if(cl.isPresent()){
            System.out.println(("Il cliente che ha speso di più è:\n")
                    .concat(cl.get().toStringSpesa()+"\n"));
        }
        else{
            System.out.println("Nessun cliente presente nella lista\n");
        }

    }

    // metodo che stampa il nome del cliente che ha acquistato più prodotti (con il numero di acquisti)
    // (legato al comando 2.3 del menù interattivo)
    public void stampaClienteMassimiAcquisti(){
        Optional<Cliente> cl = listaClienti.stream()
                .sorted(Comparator.comparing(Cliente::getAcquistiTotali).reversed())
                .findFirst();

        if(cl.isPresent()){
            System.out.println(("Il cliente che ha acquistato il maggior numero di prodotti è:\n")
                    .concat(cl.get().toStringAcquisti()+"\n"));
        }
        else{
            System.out.println("Nessun cliente presente nella lista\n");
        }

    }

    // metodo che stampa i nomi dei clienti ordinati per spesa effettuata
    // (legato al comando 2.4 del menù interattivo)
    public void stampaClientiPerSpesa(){
        if(listaClienti.size()>0){
            System.out.println("Ecco la lista dei clienti ordinati per spesa effettuata:");
            listaClienti.stream()
                    .sorted(Comparator.comparing(Cliente::getSpesaTotale).reversed())
                    .forEach(cliente -> System.out.println(cliente.toStringSpesa()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun cliente presente nella lista\n");
        }

    }

    // metodo che stampa i nomi dei clienti ordinati per acquisti effettuati
    // (legato al comando 2.5 del menù interattivo)
    public void stampaClientiPerAcquisti(){
        if(listaClienti.size()>0){
            System.out.println("Ecco la lista dei clienti ordinati per acquisti effettuati:");
            listaClienti.stream()
                    .sorted(Comparator.comparing(Cliente::getAcquistiTotali).reversed())
                    .forEach(cliente -> System.out.println(cliente.toStringAcquisti()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun cliente presente nella lista\n");
        }

    }


    // metodo legato al comando 2 del menù interattivo
    // apre a sua volta un menu interattivo
    public void visualizzaProdotti(Scanner enter){

        getProductsMenu();
        String input = enter.nextLine();

        switch(input){

            case "1":
                stampaProdotti();
                break;
            case "2":
                stampaProdottoSpesaMassima();
                break;
            case "3":
                stampaProdottoMassimiAcquisti();
                break;
            case "4":
                stampaProdottiPerSpesa();
                break;
            case "5":
                stampaProdottiPerAcquisti();
                break;
            default:

        }

    }

    // metodo che stampa i nomi dei prodotti, i loro id e la quantità disponibile in magazzino
    // (in ordine di come sono stati inseriti in lista e quindi id)
    // (metodo legato al comando 3.1 del menù interattivo)
    public void stampaProdotti(){
        StringBuilder response = new StringBuilder();
        listaProdotti.stream()
                .forEach(Prodotto -> response
                        .append(Prodotto.getNome()+": ")
                        .append("Id = "+Prodotto.getId()+", ")
                        .append("quantità ancora in magazzino = "+Prodotto.getQuantita()+"\n"));

        System.out.println(response);
    }

    // metodo che stampa il nome del prodotto per cui è stato speso di più (con relativa spesa totale)
    // (legato al comando 3.2 del menù interattivo)
    public void stampaProdottoSpesaMassima(){
        Optional<Prodotto> pr = listaProdotti.stream().max(Comparator.comparing(prodotto -> {
            Prodotto p = (Prodotto) prodotto;
            return p.getQtaVenduta()*p.getPrezzo();}));

        if(pr.isPresent()){
            System.out.println(("Il prodotto per cui è stato speso più denaro è:\n")
                    .concat(pr.get().toStringSpesa()+"\n"));
        }
        else{
            System.out.println("Nessun prodotto presente nella lista\n");
        }

    }

    // metodo che stampa il nome del prodotto si cui sono state acquistate più unità (con il numero di acquisti)
    // (legato al comando 3.3 del menù interattivo)
    public void stampaProdottoMassimiAcquisti(){
        Optional<Prodotto> pr = listaProdotti.stream()
                .sorted(Comparator.comparing(Prodotto::getQtaVenduta).reversed())
                .findFirst();

        if(pr.isPresent()){
            System.out.println(("Il prodotto di cui sono state acquistate più unità è:\n")
                    .concat(pr.get().toStringAcquisti()+"\n"));
        }
        else{
            System.out.println("Nessun prodotto presente nella lista\n");
        }

    }

    // metodo che stampa i nomi dei prodotti ordinati per entrate (in ordine decrescente)
    // (legato al comando 3.4 del menù interattivo)
    public void stampaProdottiPerSpesa(){
        if(listaProdotti.size()>0){
            System.out.println("Ecco la lista dei prodotti ordinati per spesa effettuata:");
            listaProdotti.stream()
                    .sorted(Comparator.comparing(oggetto ->
                    {Prodotto pr = (Prodotto) oggetto;
                    return pr.getQtaVenduta()*pr.getPrezzo();}).reversed())
                    .forEach(prodotto -> System.out.println(prodotto.toStringSpesa()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun prodotto presente nella lista\n");
        }

    }


    // metodo che stampa i nomi dei prodotti ordinati per numero di acquisti (decrescente)
    // (legato al comando 3.5 del menù interattivo)
    public void stampaProdottiPerAcquisti(){
        if(listaProdotti.size()>0){
            System.out.println("Ecco la lista dei prodotti ordinati per numero di acquisti:");
            listaProdotti.stream()
                    .sorted(Comparator.comparing(Prodotto::getQtaVenduta).reversed())
                    .forEach(prodotto -> System.out.println(prodotto.toStringAcquisti()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun prodotto presente nella lista\n");
        }

    }


    // metodo che stampa le fatture effettuate
    // (legato al comando 4 del menù interattivo)
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

    // METODO IMPORTANTE
    // viene richiamato nel main e permette di avviaare il programma gestendo tutti  i metodi interni
    // si occupa di gestire il menù interattivo base (delegando i sottolivelli ad altri metodi)
    // gestisce gli input dell'utente e termina il programma se l'input inserito non è associato alle opzioni prestabilite
    public void avviaProgramma(Scanner enter){

        System.out.println("Gentile utente, benvenuto nel portale per la gestione del negozio\n");
        boolean operative = true;
        String input;

        while(operative==true){

            getInteractiveMenu();
            input = enter.nextLine();

            switch(input){
                case "1":
                    eseguiTransazione(enter);
                    break;

                case "2":
                    visualizzaClienti(enter);
                    break;

                case "3":
                    visualizzaProdotti(enter);
                    break;

                case "4":
                    stampaFatture();
                    break;

                default:
                    operative = false;

            }

        }

        System.out.println("Grazie e arrivederci");

    }


}
