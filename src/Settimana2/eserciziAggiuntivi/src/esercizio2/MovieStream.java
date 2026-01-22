package Settimana2.eserciziAggiuntivi.src.esercizio2;

import Settimana2.eserciziAggiuntivi.src.entities.*;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MovieStream {

    // metodo che restituisce il tempo speso da un utente a guardare film
    // filtro per ogni film moltiplicando la durata del film per il numero di volte che è stato visto
    public static int timeSpent(MovieWatcher mw, Map<Integer, Movie> mMap){
        return (mw.getCronostoria().keySet().stream()
                .mapToInt(n -> (mMap.get(n).getDurata())* mw.getCronostoria().get(n)).sum());
    }

    public static void printTimeSpent(MovieWatcher mw, Map<Integer, Movie> mMap) {
        System.out.format("L'utente %s %s ha guardato film per un totale di ", mw.getNome(), mw.getCognome());
        System.out.print(timeSpent(mw, mMap));
        System.out.println(" minuti");
    }

    record MovieCount(Movie movie, int count){}


    // metodo che restitusice il film più visto da una lista di utenti e il numero di volte che è stato visto
    // viene creata una mappa che tiene conto dei film e di quante volte son stati visti
    // scremando gli utenti e i film visti la mappa viene aggiornata di conseguenza
    public static MovieCount mostSeen(List<MovieWatcher> list, Map<Integer, Movie> mMap, Set<Movie> s){
        Map<Movie,Integer> howOften = new HashMap<>();
        s.stream().forEach(m -> howOften.put(m,0));

        list.stream().forEach(mw -> mw.getCronostoria().
                forEach((n, value)-> howOften.put(mMap.get(n),howOften.get(mMap.get(n))+value)));


        AtomicInteger max = new AtomicInteger();
        howOften.keySet().stream().forEach(m -> max.set(Math.max(max.get(), howOften.get(m))));

        final int maxF = max.get();
        Movie result = howOften.keySet().stream().filter(m -> howOften.get(m)== maxF).findFirst().orElse(null);
        return new MovieCount(result,maxF);
    }

    public static void printMostSeen(List<MovieWatcher> list, Map<Integer, Movie> mMap, Set<Movie> s){
        StringBuilder messageB = new StringBuilder("Il film più visto dagli utenti ");
        list.stream().forEach(mw -> messageB.append(mw.getNome()).append(" ").append(mw.getCognome()).append(", "));
        String message = messageB.substring(0,messageB.length()-2);
        message = message.concat(" è: ").concat(mostSeen(list, mMap, s).movie.getTitolo());
        int total = mostSeen(list, mMap, s).count;
        char plurality = total==1? 'a':'e';
        message += ". È stato visto "+mostSeen(list, mMap, s).count+" volt"+plurality;
        System.out.println(message);
    }

    // Data una lista di utenti e un'età minima questo metodo restituisce l'utente (sotto forma di stringa)
    // che ha guardato per più tempo i film tra coloro che hanno almeno quell'età
    public static String getMovieWatcher(List<MovieWatcher> list, Map<Integer, Movie> mMap, int age){

        //costruisco una mappa di utenti col rispettivo tempo speso a guardare i film
        //richiamo il primo metodo per comodità
        Map<MovieWatcher,Integer> totalMinutes = new HashMap<>();
        list.stream().forEach(mw -> totalMinutes.put(mw,timeSpent(mw,mMap)));

        LocalDate yearsAgo = LocalDate.now().minusYears(age);


        //scarto gli utenti con età minore a quella passata
        // poi ordino in modo decrescente gli utenti rimasti per tempo di visione
        // infine prendo il primo elemento della nuova lista (cosa non ottimale perché scarto gli altri a parimerito)
        Optional<MovieWatcher> mostFan = totalMinutes.keySet().stream()
                .filter(mw -> mw.getDdn().isBefore(yearsAgo))
                .sorted(Comparator.comparingInt(totalMinutes::get).reversed())
                .findFirst();

        StringBuilder message = new StringBuilder();

        if(mostFan.isPresent()){
            message.append("Tra gli utenti con almeno ")
                    .append(age)
                    .append(" anni, quello ad aver guardato per più tempo i film è ")
                    .append(mostFan.get().getNome()).append(" ")
                    .append(mostFan.get().getCognome())
                    .append(" e ha guardato film per un totale di ")
                    .append(totalMinutes.get(mostFan))
                    .append(" minuti");
        }
        // se non ci sono utenti con età superiore a quella passata, viene stampato mess di avviso
        else{
            message.append("Non ci sono utenti con più di ")
                    .append(age)
                    .append(" anni");
        }

        return message.toString();


    }

    record DirectorCount(Persona regista, int count){}

    // metodo che dato un set di utenti restituisce il regista preferito (in base al film preferito) dalla maggior parte degli utenti
    public static DirectorCount favoriteDirector(Set<MovieWatcher> mws, Set<Movie> movies, List<Persona> directors){

        // creo una mappa che conti per ciascun regista il numero di utenti che hanno come film preferito un loro film
        Map<Persona,Integer> directorMap = new HashMap<>();
        directors.stream().forEach(p -> directorMap.put(p,0));
        mws.stream().mapToInt(MovieWatcher::getFavoriteMovie)
                .mapToObj(n -> findDirector(movies,n))
                .forEach(p -> directorMap.put(p,directorMap.get(p)+1));

        // ordino i registi in base al numero di utenti che li hanno come preferiti (in modo decrescente)
        // e salvo il primo regista della lista
        Persona favDirector = directorMap.keySet().stream()
                .sorted(Comparator.comparingInt(directorMap::get).reversed())
                .findFirst().orElse(null);

        return new DirectorCount(favDirector,directorMap.get(favDirector));
    }

    public static void printDirector(Set<MovieWatcher> mws, Set<Movie> movies, List<Persona> directors){

        DirectorCount fav = favoriteDirector(mws,movies,directors);
        System.out.println("L'artista preferito degli utenti è: "
                +fav.regista.getNome()+" "+fav.regista.getCognome()+".\n"
                +fav.count+" utenti hanno come film preferito un film che ha diretto");

    }

    // metodo che prende in input un id e restituisce il regista che ha diretto il film con quell'Id
    public static Persona findDirector(Set<Movie> movies, int n){
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId() == n)
                .findFirst();

        try{
            movie.get();
            return movie.get().getRegista();
        }
        catch (NullPointerException npe){

            npe.printStackTrace();
        }

        return null;

    }

}
