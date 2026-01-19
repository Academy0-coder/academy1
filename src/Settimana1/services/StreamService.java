package Settimana1.services;

import Settimana1.entities.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamService {

    StringService strService = new StringService();

    public Boolean trovaPeppe(List<Cliente> l){

        Optional<Cliente> peppe = l.stream().filter(cl -> cl.getName().equalsIgnoreCase("peppe")).findAny();
        return peppe.isPresent();
    }

    public List<Cliente> filtraPeppe(List<Cliente> l){

        Stream<Cliente> peppeStream = l.stream().filter(cl -> cl.getName().equalsIgnoreCase("peppe"));
        return peppeStream.toList();
    }

    public int contaPeppe(List<Cliente> l){

        long countPeppe = l.stream().filter(cl -> cl.getName().equalsIgnoreCase("peppe")).count();
        return (int) countPeppe;
    }

    public Boolean trovaDominio(List<Cliente> l, String name, String domain){

        Optional<Cliente> anyCliente = l.stream().filter(cl -> cl.getName().equalsIgnoreCase(name))
                .filter(cl -> strService.ottieniDominio(cl.getEmail()).equalsIgnoreCase(domain)).findAny();
        return anyCliente.isPresent();
    }

    public String cercaClienteDallEMail(List<Cliente> l, String email){

        Optional<Cliente> cliente = l.stream()
                .filter(cl -> cl.getEmail().equalsIgnoreCase(email))
                .findFirst();
        return (cliente.isPresent()? cliente.toString(): "Nessun cliente trovato");
    }

    public String cercaClientiPerAzienda(List<Cliente> l, String domain) {

        Stream<Cliente> clStream = l.stream()
                .filter(cl -> strService.ottieniDominio(cl.getEmail()).equalsIgnoreCase(domain));
        StringBuilder list = new StringBuilder();
       clStream.forEach(cl -> list.append(cl.toString()));
       return list.toString();


    }


}
