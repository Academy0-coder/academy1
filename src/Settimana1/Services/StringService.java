package Settimana1.Services;

import java.util.HashMap;
import java.util.Map;

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
    public String inverti(String s){
        String inverted = "";

        // ciclo i singoli caratteri da destra a sinistra
        for(int i = s.length() -1; i>=0; i--){
            inverted += s.charAt(i);
        }
        return inverted;}


    /**
     * Questo metodo deve restituire il numero di vocali contenuti nella stringa in input
     * @param s
     * @return
     */
    public Integer contaVocali(String s){
        int count = 0;

        // Uso toCharArray per ottenere un'array di caratteri
        // Uso una regex per verificare l'uguaglianza ma devo castare il carattere di nuovo a stringa
        // Nota: probabilmente esiste un modo più efficiente
        for(Character c: s.toCharArray()){
            if(c.toString().matches("[AEIOUYaeiouy]")){
                count++;
            }
        }
        return count;
    }

    /**
     * Questo metodo deve restituire true se la stringa inserita è un palindromo
     * false se non lo e'
     * @param s
     * @return
     */
    public Boolean isPalindromo(String s){

        // rimuovo gli spazi dalla stringa sostituendoli con una "stringa vuota"
        // inoltre metto tutto in minuscolo per fare in modo che la stessa lettera maiuscola e minuscola non risulti diversa
        String t = s.replace(" ","").toLowerCase();

        // creo due contatori, uno che parte da sinistra e uno da destra
        int i = 0;
        int j = t.length()-1;

        // confronto le lettere nella posizione dei contatori, se sono diverse la stringa non è palindroma
        // se sono uguali sposto entrambi i contatori verso il centro e proseguo finché i contatori non sono nella stessa posizione
        while(i<j){
            if(t.charAt(i)!=t.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;

    }

    /**
     * Questo metodo deve restituire una nuova stringa avente la prima lettera maiuscola per ogni parola che compone
     * la stringa in input
     * @param s
     * @return
     */
    public String capitalize(String s){

        // splitto la stringa in un array con le singole parole (uso lo spazio come divisore)
        String[] words = s.split(" ");
        // creo una nuova stringa che avrà le iniziali maiuscole e le altre lettere minuscole
        String capitalized = "";

        // filtro ogni parola creandone una nuova con l'iniziale maiuscola e le altre lettere minuscole e riaggiungo lo spazio
        for(String w: words){
            String newWord = w.substring(0,1).toUpperCase().concat(w.substring(1).toLowerCase());
            capitalized += newWord + " ";
        }

        // tronco l'ulitmo spazio
        return capitalized.substring(0, capitalized.length()-1);
    }

    /**
     * Metodo che restituisca una nuova stringa contenente solo la prima occorrenza di
     * ogni carattere della stringa originale.
     * @param s
     * @return
     */
    public String rimuoviDuplicati(String s){

        char[] arr = s.toCharArray();

        String result = "";

        // creo una stringa vuota
        // filtro i caratteri della stringa originaria
        // se non sono ancora contenuti nella stringa nuova li aggiungo altrimenti non succede nulla
        // (non ci saranno così duplicati)
        for (char c: arr){

            if (!result.contains(Character.toString(c))){
                result += c;
            }
        }

        return result;
    }

    /**
     * Metodo che sostituisca sequenze di caratteri uguali con il carattere seguito dal numero di ripetizioni.
     * es. aaabbc -> a3b2c1
     * @param s
     * @return
     */
    public String comprimi(String s){
        // *Minuscolizzo* la stringa
        String min = s.toLowerCase();

        // Creo una mappa dove i caratteri sono le chiavi e il conteggio di quante volte si ripetono il valore
        Map<Character, Integer> characters = new HashMap<>();

        // ciclo i caratteri della stringa, se è la prima volta che appaiono inserisco una coppia (nuovo carattere / 1)
        // se esiste già sovrascrivo il valore di 1 (uso sempre put)
        for(char c: min.toCharArray()){
            if (!characters.containsKey(c)){
                characters.put(c,1);
            }
            else{
                characters.put(c,(characters.get(c))+1);
            }
        }

        String message = "";

        // popolo la stringa scremando la mappa aggiungendo prima la chiave e poi il valore per ogni coppia
        for(char c: characters.keySet()){
            message = message.concat(Character.toString(c).concat(Integer.toString(characters.get(c))));
        }
        return message;
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
