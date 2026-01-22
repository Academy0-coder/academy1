package Settimana1;

import Settimana1.services.StreamService;
import Settimana1.services.StringService;
import Settimana1.entities.Cliente;

import java.util.List;

public class MainOldSchool {
    public static void main (String[] args){
        StringService stringService = new StringService();
        StreamService streamService = new StreamService();

        System.out.println(stringService.maiuscola("Maiuscola"));
        System.out.println(stringService.inverti("Maiuscola"));
        System.out.println(stringService.contaVocali("Maiuscola"));
        System.out.println(stringService.isPalindromo("I topi non avevano nipoti"));
        System.out.println(stringService.capitalize("Maiuscola"));
        System.out.println(stringService.rimuoviDuplicati("Pappappero"));
        System.out.println(stringService.comprimi("AaaaBbbbCcDEeee"));
        System.out.println(stringService.censura("Maiuscola"));
        System.out.println(stringService.ottieniDominio("email@dominio.com"));
        System.out.println(stringService.verificaAnagramma("Tokyo", "Kyoto"));
        System.out.println(stringService.parolaPiuLunga("Quale e la parola piu lunga in questa frase"));
        //Commit per pull request 2
        Cliente cliente0 = new Cliente("Peppe", "Papero", "mariopapero@example.com");
        Cliente cliente1 = new Cliente("Maria", "Paperina", "paperella@piscina.com");
        Cliente cliente2 = new Cliente("Gianni", "Giannone", "giannone@piscina.com");
        Cliente cliente3 = new Cliente("Peppe", "Ruopolo", "peppone@example.com");
        Cliente cliente4 = new Cliente("Andrea", "Ruopolo", "andrea@ruopolo.com");
        List<Cliente> clientes = List.of(cliente0, cliente1, cliente2, cliente3, cliente4);
        System.out.println(streamService.trovaPeppe(clientes));
        System.out.println(streamService.filtraPeppe(clientes));
        System.out.println(streamService.contaPeppe(clientes));
        System.out.println(streamService.trovaDominio(clientes, "Peppe","example.com"));
        System.out.println(streamService.cercaClienteDallEMail(clientes,"paperella@piscina.com"));
        System.out.println(streamService.cercaClienteDallEMail(clientes,"paperella@idromassaggio.com"));
        System.out.println(streamService.cercaClientiPerAzienda(clientes,"piscina.com"));


    }
}
