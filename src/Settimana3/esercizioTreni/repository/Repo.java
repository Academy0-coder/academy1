package Settimana3.esercizioTreni.repository;

import Settimana3.esercizioTreni.entities.Categoria;
import Settimana3.esercizioTreni.entities.Fermata;
import Settimana3.esercizioTreni.entities.Percorso;
import Settimana3.esercizioTreni.entities.Treno;
import Settimana3.esercizioTreni.services.Orari;
import Settimana3.esercizioTreni.services.OrariImpl;

import java.time.LocalDate;

public class Repo extends OrariImpl {


    public Repo() {

        creaPercorso("RV0001", Categoria.Regionale);
        creaPercorso("RV0002", Categoria.Regionale);
        creaPercorso("IR0001", Categoria.Interregionale);
        creaPercorso("IC0001", Categoria.Intercity);
        creaPercorso("ES0001", Categoria.Eurostar);
        creaPercorso("ES0002", Categoria.Eurostar);


        Percorso p1 = getPercorso("RV0001");
        Percorso p2 = getPercorso("RV0002");
        Percorso p3 = getPercorso("IR0001");
        Percorso p4 = getPercorso("IC0001");
        Percorso p5 = getPercorso("ES0001");
        Percorso p6 = getPercorso("ES0002");



        nuovoTreno("RV0001", LocalDate.of(2026,01,27));
        nuovoTreno("RV0001", LocalDate.of(2026,01,29));
        nuovoTreno("RV0002", LocalDate.of(2026,01,28));
        nuovoTreno("IR0001", LocalDate.of(2026,01,28));
        nuovoTreno("IR0001", LocalDate.of(2026,01,28));
        nuovoTreno("IC0001", LocalDate.of(2026,01,26));
        nuovoTreno("ES0001", LocalDate.of(2026,01,29));
        nuovoTreno("ES0002", LocalDate.of(2026,01,27));


        Treno t1 = p1.getTreno(1);
        Treno t3 = p1.getTreno(2);
        Treno t2 = p2.getTreno(1);
        Treno t4 = p3.getTreno(1);
        Treno t5 = p3.getTreno(2);
        Treno t6 = p4.getTreno(1);
        Treno t7 = p5.getTreno(1);
        Treno t8 = p6.getTreno(1);



        getPercorso("RV0001").aggiungiFermata("Asti",11,00);
        getPercorso("RV0001").aggiungiFermata("Montegrosso d'Asti",11,20);
        getPercorso("RV0001").aggiungiFermata("Nizza Monferrato",11,45);
        getPercorso("RV0001").aggiungiFermata("Mombaruzzo",12,00);
        getPercorso("RV0001").aggiungiFermata("Acqui Terme",12,25);


        Fermata f11 = p1.getFermate().get(0);
        Fermata f12 = p1.getFermate().get(1);
        Fermata f13 = p1.getFermate().get(2);
        Fermata f14 = p1.getFermate().get(3);
        Fermata f15 = p1.getFermate().get(4);

        t1.registraPassaggio(f11, 11,00,false);
        t1.registraPassaggio(f12, 11,20,false);
        t1.registraPassaggio(f13, 11,50,false);
        t1.registraPassaggio(f14, 12,20,false);
        t1.registraPassaggio(f15, 12,40,true);


        getPercorso("RV0002").aggiungiFermata("Alessandria",17,00);
        getPercorso("RV0002").aggiungiFermata("Oviglio",17,20);
        getPercorso("RV0002").aggiungiFermata("Nizza Monferrato",17,50);
        getPercorso("RV0002").aggiungiFermata("Canelli",18,05);
        getPercorso("RV0002").aggiungiFermata("Castagnole nelle Lanze",18,30);


        Fermata f21 = p2.getFermate().get(0);
        Fermata f22 = p2.getFermate().get(1);
        Fermata f23 = p2.getFermate().get(2);
        Fermata f24 = p2.getFermate().get(3);
        Fermata f25 = p2.getFermate().get(4);

        t2.registraPassaggio(f21, 17,00,false);
        t2.registraPassaggio(f22, 17,30,false);
        t2.registraPassaggio(f23, 17,55,false);
        t2.registraPassaggio(f24, 18,05,false);
        t2.registraPassaggio(f25, 18,40,true);
    }


}
