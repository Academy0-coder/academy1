import Settimana2.esercizioNegozio.entities.Negozio;

public static void main(String[] args) {

    NumberFormat prezzo = NumberFormat.getCurrencyInstance(Locale.ITALY);

    Negozio store = new Negozio();

    // System.out.println(prezzo.format(20000));

    store.eseguiTransazione(2,4,3);
    System.out.println(store.stampaClienti());

}
