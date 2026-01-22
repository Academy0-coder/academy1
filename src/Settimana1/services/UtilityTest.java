package Settimana1.services;

import Settimana1.entities.Days;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {


    @Test
    void containsArrTest() {
        assertEquals(true,Utility.containsArr(Days.values(),Days.WEDNESDAY));
    }
}