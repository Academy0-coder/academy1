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

                store.transazione(enter);
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

            case "6":
                store.clienteSpesaMassima();
                break;

            case "7":
                store.clienteAcquistiMassimi();
                break;

            case "8":
                store.prodottoSpesaMassima();
                break;

            case "9":
                store.prodottoAcquistiMassimi();
                break;

            default:
                operative = false;

        }

    }

    System.out.println("Grazie e arrivederci");

    enter.close();


}


