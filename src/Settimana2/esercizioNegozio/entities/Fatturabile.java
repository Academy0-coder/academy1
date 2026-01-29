package Settimana2.esercizioNegozio.entities;

public abstract class Fatturabile {

    private final int id;
    private final String nome;
    private double spesaTotale;
    private int acquistiTotali;

    public Fatturabile(int id, String nome) {
        this.id = id;
        this.nome = nome;
        spesaTotale = 0.0;
        acquistiTotali = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSpesaTotale() {
        return spesaTotale;
    }

    public void setSpesaTotale(double spesaTotale) {
        this.spesaTotale = spesaTotale;
    }

    public int getAcquistiTotali() {
        return acquistiTotali;
    }

    public void setAcquistiTotali(int acquistiTotali) {
        this.acquistiTotali = acquistiTotali;
    }

    public abstract String toString();
    public abstract String toStringSpesa();
    public abstract String toStringAcquisti();
}
