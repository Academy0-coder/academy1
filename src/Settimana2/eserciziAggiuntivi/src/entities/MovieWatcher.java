package Settimana2.eserciziAggiuntivi.src.entities;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class MovieWatcher extends Persona{

    private int favoriteMovie;
    private Map<Integer,Integer> cronostoria;

    public MovieWatcher(String nome, String cognome, LocalDate ddn, int favoriteMovie, Map<Integer, Integer> cronostoria) {
        super(nome, cognome, ddn);
        this.favoriteMovie = favoriteMovie;
        this.cronostoria = cronostoria;
    }

    public MovieWatcher(Persona p, int favoriteMovie, Map<Integer, Integer> cronostoria) {
        super(p.getNome(),p.getCognome(),p.getDdn());
        this.favoriteMovie = favoriteMovie;
        this.cronostoria = cronostoria;
    }

    public MovieWatcher(int favoriteMovie, Map<Integer, Integer> cronostoria) {
        this.favoriteMovie = favoriteMovie;
        this.cronostoria = cronostoria;
    }

    public int getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(int favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }

    public Map<Integer, Integer> getCronostoria() {
        return cronostoria;
    }

    public void setCronostoria(Map<Integer, Integer> cronostoria) {
        this.cronostoria = cronostoria;
    }

}
