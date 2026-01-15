package Settimana1.Services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringServiceTest {

    StringService test = new StringService();

    @Test
    void rimuoviDuplicatiCaratteriMisti(){
        String esempio = "ciccio 345324 !!!";
        assertEquals("cio 3452!", test.rimuoviDuplicati(esempio));
    }

    @Test
    void capitalizeTestoLungoConCaratteriMisti() {
        assertEquals("Oggi È Giovedì 15 Gennaio!", test.capitalize("oggI è GIOveDÌ 15 geNnaIo!"));
    }

    @Test
    void palindromoConNumeriFalso() {
        assertNotEquals(true,test.isPalindromo("43953249"));
    }

    @Test
    void palindromoConNumeriVero() {

        assertEquals(true,test.isPalindromo("4980894"));
    }

    @Test
    void palindromoCaratteriMistiConSpaziVirgolePunti(){
        assertEquals(true,test.isPalindromo("Adirati se non eri la, si credeva amassi l'orpello fine." +
                "Ivi divieni folle, prolissa. Ma a vederci salire non esitar, Ida"));

    }


    @Test
    void palindromoCaratteriMistiConLettereAccentate(){
        assertEquals(true,test.isPalindromo("Adirati se non eri là, si credeva amassi l'orpello fine." +
                "Ivi divieni folle, prolissa. Ma a vederci salire non esitar, Ida"));

    }
}