import Settimana2.esercizioNegozio.entities.Cliente;
import Settimana2.esercizioNegozio.entities.Negozio;
import Settimana2.esercizioNegozio.entities.Prodotto;

public static void main(String[] args) {

    Negozio store = new Negozio();

    boolean operative = true;
    Scanner enter = new Scanner(System.in);


//    store.eseguiTransazione(2,4,3);
//    store.eseguiTransazione(4,7,25);
//    store.eseguiTransazione(4,2,12);
//    store.eseguiTransazione(5,5,3);
//    store.eseguiTransazione(5,5,10);
//    store.eseguiTransazione(3,7,17);

    System.out.println("Gentile utente, benvenuto nel portale per la gestione del negozio\n");
    String input;

    while(operative==true){

        store.getInteractiveMenu();
        input = enter.nextLine();

        switch(input){
            case "1":

                System.out.println("Inserisci l'id del cliente");
                input = enter.nextLine();
                try{
                    store.findCliente(input);
                } catch (NumberFormatException e1){
                    System.out.println("L'id dev'essere un numero intero");
                    break;
                } catch (NoSuchElementException e2) {
                    System.out.println("Non sono presenti clienti con quest'id nella lista");
                    break;
                }


                Cliente cl = store.getCliente(input);

                System.out.println("Inserisci l'id del prodotto");
                input = enter.nextLine();
                try{
                    store.findProdotto(input);
                } catch (NumberFormatException e1){
                    System.out.println("L'id dev'essere un numero intero");
                    break;
                } catch (NoSuchElementException e2) {
                    System.out.println("Non sono presenti prodotti con quest'id nella lista");
                    break;
                }

                Prodotto pr = store.getProdotto(input);

                System.out.println("Inserisci la quantità");
                input = enter.nextLine();
                int q = store.checkString(input);
                store.eseguiTransazione(cl.getId(),pr.getId(),q);
                break;

            case "2":
                store.visualizzaProdotti();
                break;

            case "3":
                store.visualizzaClienti();
                break;

            case "4":
                store.stampaClienti();
                break;

            case "5":
                store.stampaFatture();
                break;

            default:
                operative = false;

        }

    }

    System.out.println("Grazie e arrivederci");

    enter.close();

    //Trova il cliente che speso di più
    //Trova il cliente che ha acquistato più prodotti
    //Trova il prodotto più venduto
    //Trova il prodotto per cui sono stati spesi più soldi


}
