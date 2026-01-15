package Settimana1.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    // METODO DI UTILITY che serve a rimuovere gli accenti da una stringa
    public String removeAccents(String s){
        s = s.replace("à","a");
        s = s.replace("è","e");
        s = s.replace("é","e");
        s = s.replace("ì","i");
        s = s.replace("ò","o");
        s = s.replace("ù","u");
        return s;
    }



    public Boolean isPalindromo(String s){

        // Rendo il testo minuscolo, rimuovo gli accenti e i caratteri speciali (incluso lo spazio vuoto)
        String t = removeAccents(s.toLowerCase()).replaceAll("\\W","").replaceAll("_","");


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

        int l = s.length();

        //creo una stringa concatenando il primo carattere, l-2 asterischi e l'ultimo carattere
        String censored = s.substring(0,1);
        for(int i=1; i<l-1; i++){
            censored += "*";
        }
        censored += s.substring(l-1,l);

        return censored;
    }

    /**
     * Data una stringa email valida, restituisce solo la parte del dominio (quella dopo la @).
     * @param s
     * @return
     */
    public String ottieniDominio(String s){

        // utilizzo la regex come metodo (si potrebbe anche usare lo split sul @)
        // verifico che il dominio abbia tot caratteri seguiti dalla chiocciola
        // seguiti da altri tot caratteri, un punto e altri tot caratteri
        // quest'ultima parte la salvo nel gruppo dominio
        String regex = "\\w+@(?<domain>\\w+\\.\\w+)";

        // creo un pattern e un matcher
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(s);

        // se cè il match ritorno il gruppo dominio
        if (mat.matches()){
            return mat.group("domain").toString();
        }
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

        // utilizzo lo stesso sistema usato nel metodo comprimi
        // (avrei dovuto crearmi un metodo unico da richiamare per tutti i casi)
        // creo due mappe, una per parola che trovino i caratteri che contengono e in che quantità
        String min1 = s1.toLowerCase();
        String min2 = s2.toLowerCase();

        Map<Character, Integer> chars1 = new HashMap<>();
        Map<Character, Integer> chars2 = new HashMap<>();

        for(char c: min1.toCharArray()){
            if (!chars1.containsKey(c)){
                chars1.put(c,1);
            }
            else{
                chars1.put(c,(chars1.get(c))+1);
            }
        }

        for(char c: min2.toCharArray()){
            if (!chars2.containsKey(c)){
                chars2.put(c,1);
            }
            else{
                chars2.put(c,(chars2.get(c))+1);
            }
        }

        // verifico l'uguaglianza delle mappe
        return chars1.equals(chars2);
    }

    /**
     * Metodo che accetti una frase e restituisca la parola che contiene più caratteri. Se ci sono più parole con la
     * stessa lunghezza massima, restituisci la prima trovata.
     * @param s
     * @return
     */
    public String parolaPiuLunga(String s){

        // splitto la stringa nelle sue singole parole
        String[] words = s.split(" ");
        // partendo dalla prima parola itero in ordine per tutte le altre e se ne trovo una
        // strettamente più lunga la sostituisco
        String longest = words[0];
        for(int i = 1; i < words.length; i++){
            if(words[i].length()>longest.length()){
                longest = words[i];
            }
        }

        return longest;
    }
}
