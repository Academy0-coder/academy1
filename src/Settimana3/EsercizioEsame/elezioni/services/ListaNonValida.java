package Settimana3.EsercizioEsame.elezioni.services;

public class ListaNonValida extends RuntimeException {
    public ListaNonValida() {super();}
    public ListaNonValida(String message) {
        super(message);
    }
}
