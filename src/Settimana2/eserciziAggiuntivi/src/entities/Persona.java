package Settimana2.eserciziAggiuntivi.src.entities;

import java.time.LocalDate;

public class Persona {

    private String nome;
    private String cognome;
    private LocalDate ddn;

    public Persona(String nome, String cognome, LocalDate ddn) {
        this.nome = nome;
        this.cognome = cognome;
        this.ddn = ddn;
    }

    public Persona(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDdn() {
        return ddn;
    }


    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    public int getAge(){
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonth().getValue();
        int currentDay = LocalDate.now().getDayOfMonth();
        int userYear = ddn.getYear();
        int userMonth = ddn.getMonth().getValue();
        int userDay = ddn.getDayOfMonth();
        boolean bPast;
        if (currentMonth > userMonth || (currentMonth == userMonth && currentDay >= userDay)){
            bPast = true;
        }
        else {
            bPast = false;
        }
        int intPast = bPast? 0: -1;

        return(currentYear-userYear+intPast);
    }
}
