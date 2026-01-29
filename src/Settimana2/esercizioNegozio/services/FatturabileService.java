package Settimana2.esercizioNegozio.services;

import Settimana2.esercizioNegozio.entities.Cliente;
import Settimana2.esercizioNegozio.entities.Fatturabile;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FatturabileService {

    // metodo che stampa una qualunque lista di oggetto di un tipo che estende Fatturabile
    public void stampaFatturabile(List<? extends Fatturabile> list){
        StringBuilder response = new StringBuilder();
        list.stream()
                .forEach(fatturabile -> response.append(fatturabile.toString()).append("\n"));

        System.out.println(response);
    }

    public void stampaFatturabileSpesaMassima(List<? extends Fatturabile> list){
        Optional<? extends Fatturabile> ft = list.stream()
                .sorted(Comparator.comparing(Fatturabile::getSpesaTotale).reversed())
                .findFirst();

        String tipo = ft.get().getClass().getSimpleName().toLowerCase();
        String mess = "";

        switch(tipo){
            case "cliente":
                mess = "che ha speso";
                break;
            case "prodotto":
                mess = "per cui è stato speso";
                break;
            default:
        }


        if(ft.isPresent()){
            System.out.printf("Il %s %s di più è:%n",tipo,mess);
            System.out.println(ft.get().toStringSpesa()+"\n");
        }
        else{
            System.out.printf("Nessun %s presente nella lista%n%n",tipo);
        }

    }

    public void stampaFatturabileMassimiAcquisti(List<? extends Fatturabile> list){
        Optional<? extends Fatturabile> ft = list.stream()
                .sorted(Comparator.comparing(Fatturabile::getAcquistiTotali).reversed())
                .findFirst();

        String tipo = ft.get().getClass().getSimpleName().toLowerCase();
        String mess = "";

        switch(tipo){
            case "cliente":
                mess = "che ha acquistato il maggior numero di prodotti";
                break;
            case "prodotto":
                mess = "di cui sono state acquistate più unità";
                break;
            default:
        }


        if(ft.isPresent()){
            System.out.printf("Il %s %s è:%n",tipo,mess);
            System.out.println(ft.get().toStringSpesa()+"\n");
        }
        else{
            System.out.printf("Nessun %s presente nella lista%n%n",tipo);
        }

    }

    public void stampaFatturabilePerSpesa(List<? extends Fatturabile> list){
        if(list.size()>0){
            String tipo = list.get(0).getClass().getSimpleName().toLowerCase();
            String tipi = tipo.substring(0,tipo.length()-1).concat("i");
            System.out.printf("Ecco la lista dei %s ordinati per spesa effettuata:%n",tipi);
            list.stream()
                    .sorted(Comparator.comparing(Fatturabile::getSpesaTotale).reversed())
                    .forEach(fatturabile -> System.out.println(fatturabile.toStringSpesa()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun elemento presente nella lista\n");
        }

    }

    public void stampaFatturabilePerSpesaMedia(List<Cliente> list){
        if(list.size()>0){
            System.out.println("Ecco la lista dei clienti ordinati per spesa media:");
            list.stream()
                    .sorted(Comparator.comparing(Cliente::getSpesaMedia).reversed())
                    .forEach(cliente -> System.out.println(cliente.toStringSpesaMedia()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun elemento presente nella lista\n");
        }

    }


    public void stampaFatturabilePerAcquisti(List<? extends Fatturabile> list){
        if(list.size()>0){
            String tipo = list.get(0).getClass().getSimpleName().toLowerCase();
            String tipi = tipo.substring(0,tipo.length()-1).concat("i");
            System.out.printf("Ecco la lista dei %s ordinati per numero di acquisti:%n",tipi);
            list.stream()
                    .sorted(Comparator.comparing(Fatturabile::getAcquistiTotali).reversed())
                    .forEach(fatturabile -> System.out.println(fatturabile.toStringAcquisti()));
            System.out.println("");
        }
        else{
            System.out.println("Nessun elemento presente nella lista\n");
        }

    }


}
