package Settimana2.esercizioNegozio.services;

import Settimana2.esercizioNegozio.entities.Prodotto;

import java.util.List;

public class ProdottoService {

    FatturabileService fs = new FatturabileService();

    // metodo che stampa i nomi dei prodotti, i loro id e la quantità disponibile in magazzino
    // (in ordine di come sono stati inseriti in lista e quindi id)
    // (metodo legato al comando 3.1 del menù interattivo)
    public void stampaProdotti(List<Prodotto> list){
        fs.stampaFatturabile(list);
    }

    // metodo che stampa il nome del prodotto per cui è stato speso di più (con relativa spesa totale)
    // (legato al comando 3.2 del menù interattivo)
    public void stampaProdottoSpesaMassima(List<Prodotto> list){
        fs.stampaFatturabileSpesaMassima(list);
    }

    // metodo che stampa il nome del prodotto si cui sono state acquistate più unità (con il numero di acquisti)
    // (legato al comando 3.3 del menù interattivo)
    public void stampaProdottoMassimiAcquisti(List<Prodotto> list){
        fs.stampaFatturabileMassimiAcquisti(list);
    }

    // metodo che stampa i nomi dei prodotti ordinati per entrate (in ordine decrescente)
    // (legato al comando 3.4 del menù interattivo)
    public void stampaProdottiPerSpesa(List<Prodotto> list){
        fs.stampaFatturabilePerSpesa(list);
    }

    // metodo che stampa i nomi dei prodotti ordinati per numero di acquisti (decrescente)
    // (legato al comando 3.5 del menù interattivo)
    public void stampaProdottiPerAcquisti(List<Prodotto> list){
        fs.stampaFatturabilePerAcquisti(list);
    }
}
