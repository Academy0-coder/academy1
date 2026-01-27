import Settimana2.esercizioNegozio.entities.Cliente;
import Settimana2.esercizioNegozio.entities.Negozio;
import Settimana2.esercizioNegozio.entities.Prodotto;

public static void main(String[] args) {

    Negozio store = new Negozio();

    Scanner enter = new Scanner(System.in);

    store.eseguiTransazione(2,4,3, false);
    store.eseguiTransazione(4,7,25, false);
    store.eseguiTransazione(4,2,12, false);
    store.eseguiTransazione(5,5,3, false);
    store.eseguiTransazione(5,5,10, false);
    store.eseguiTransazione(3,7,17, false);
    store.eseguiTransazione(6,8,2, false);
    store.eseguiTransazione(3,8,1, false);
    store.eseguiTransazione(7,9,33, false);

    store.avviaProgramma(enter);

    enter.close();


}


