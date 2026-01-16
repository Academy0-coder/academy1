package Settimana1;

import Settimana1.Services.StringService;

public class MainOldSchool {
    public static void main (String[] args){
        StringService stringService = new StringService();

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
        //Commit per pull request
    }
}
