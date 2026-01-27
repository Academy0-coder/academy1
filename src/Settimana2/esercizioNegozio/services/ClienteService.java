package Settimana2.esercizioNegozio.services;

import Settimana2.esercizioNegozio.entities.Cliente;

import java.util.List;

public class ClienteService {

    FatturabileService fs = new FatturabileService();

    // metodo che stampa i nomi dei clienti, i loro id e la lista di prodotti acquistati
    // (in ordine di come sono stati inseriti in lista e quindi id)
    // (metodo legato al comando 2.1 del menù interattivo)
    public void stampaClienti(List<Cliente> list){
        fs.stampaFatturabile(list);
    }

    // metodo che stampa il nome del cliente che ha speso di più (con relativa spesa totale)
    // (legato al comando 2.2 del menù interattivo)
    public void stampaClienteSpesaMassima(List<Cliente> list){
        fs.stampaFatturabileSpesaMassima(list);
    }

    // metodo che stampa il nome del cliente che ha acquistato più prodotti (con il numero di acquisti)
    // (legato al comando 2.3 del menù interattivo)
    public void stampaClienteMassimiAcquisti(List<Cliente> list){
        fs.stampaFatturabileMassimiAcquisti(list);
    }

    // metodo che stampa i nomi dei clienti ordinati per spesa effettuata
    // (legato al comando 2.4 del menù interattivo)
    public void stampaClientiPerSpesa(List<Cliente> list){
        fs.stampaFatturabilePerSpesa(list);
    }

    // metodo che stampa i nomi dei clienti ordinati per acquisti effettuati
    // (legato al comando 2.5 del menù interattivo)
    public void stampaClientiPerAcquisti(List<Cliente> list) {
        fs.stampaFatturabilePerAcquisti(list);
    }


}
