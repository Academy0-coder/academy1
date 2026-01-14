package Settimana1.Services;

public class StringService {
    /**
     * Questo metodo deve restituire la stringa passata in input con tutti i caratteri che la compongono in maiuscolo
     * @param s
     * @return
     */
    public String maiuscola(String s){
        return s.toUpperCase();
    }

    /**
     * Questo metodo deve restituire la stringa passata in input invertita
     * es. Java -> avaJ
     * @param s
     * @return
     */
    public String inverti(String s){return "prova";}


    /**
     * Questo metodo deve restituire il numero di vocali contenuti nella stringa in input
     * @param s
     * @return
     */
    public Integer contaVocali(String s){
        return null;
    }

    /**
     * Questo metodo deve restituire true se la stringa inserita è un palindromo
     * false se non lo e'
     * @param s
     * @return
     */
    public Boolean isPalindromo(String s){
        return null;
    }

    /**
     * Questo metodo deve restituire una nuova stringa avente la prima lettera maiuscola per ogni parola che compone
     * la stringa in input
     * @param s
     * @return
     */
    public String capitalize(String s){
        return null;
    }

    /**
     * Metodo che restituisca una nuova stringa contenente solo la prima occorrenza di
     * ogni carattere della stringa originale.
     * @param s
     * @return
     */
    public String rimuoviDuplicati(String s){
        return null;
    }

    /**
     * Metodo che sostituisca sequenze di caratteri uguali con il carattere seguito dal numero di ripetizioni.
     * es. aaabbc -> a3b2c1
     * @param s
     * @return
     */
    public String comprimi(String s){
        return null;
    }

    /**
     * Questo metodo restituisce solo la lettera iniziale e finale della stringa passata in input
     * il resto dei caratteri sono sostituiti da asterischi *
     * @param s
     * @return
     */
    public String censura(String s){
        return null;
    }

    /**
     * Data una stringa email valida, restituisce solo la parte del dominio (quella dopo la @).
     * @param s
     * @return
     */
    public String ottieniDominio(String s){
        return null;
    }

    /**
     * Metodo che verifichi se due stringhe contengono gli stessi caratteri con la stessa frequenza
     * (es. "attore" e "teatro")
     * @param s1
     * @param s2
     * @return
     */
    public Boolean verificaAnagramma(String s1, String s2){
        return null;
    }

    /**
     * Metodo che accetti una frase e restituisca la parola che contiene più caratteri. Se ci sono più parole con la
     * stessa lunghezza massima, restituisci la prima trovata.
     * @param s
     * @return
     */
    public String parolaPiuLunga(String s){
        return null;
    }
}
