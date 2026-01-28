package Settimana3.EsercizioEsame.elezioni.services;


public class CandidatoNonValido extends Exception {
  public CandidatoNonValido() {super();}
  public CandidatoNonValido(String msg) {
    super(msg);
  }
}
