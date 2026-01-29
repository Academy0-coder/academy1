package Settimana3.esercizioTreni;

import Settimana3.esercizioTreni.repository.Repo;

public class main {

    static void main(String[] args) {

        Repo start = new Repo();

        System.out.println(start.getPercorsi().get(0).ritardoMassimo());
        System.out.println(start.getPercorsi().get(0).ritardoMedio());


    }

}
