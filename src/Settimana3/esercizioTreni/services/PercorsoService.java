package Settimana3.esercizioTreni.services;

import Settimana3.esercizioTreni.entities.Categoria;
import Settimana3.esercizioTreni.entities.PercorsoImpl;
import Settimana3.esercizioTreni.entities.Treno;

import java.util.stream.Stream;

public class PercorsoService extends PercorsoImpl {


    public PercorsoService(String codice, Categoria categoria) {
        super(codice, categoria);
    }


    @Override
    public double ritardoMedio() {

        if(getTreni().stream().filter(Treno::arrivato).count() == 0){
            return 0;
        }



        else{
            return getTreni().stream().filter(Treno::arrivato)
                    .mapToDouble(Treno::ritardoFinale)
                    .average().getAsDouble();
        }

    }


    @Override
    public int ritardoMassimo() {

        if(getTreni().stream().filter(Treno::arrivato).count() == 0){
            return 0;
        }



        else{
            return getTreni().stream().filter(Treno::arrivato)
                    .mapToInt(Treno::ritardoFinale)
                    .max().getAsInt();
        }
    }
}
