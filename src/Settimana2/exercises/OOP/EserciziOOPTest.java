package Settimana2.exercises.OOP;

import org.junit.jupiter.api.Test;

import static Settimana2.exercises.OOP.EserciziOOP.position;
import static org.junit.jupiter.api.Assertions.*;

class EserciziOOPTest {

    @Test
    void position_a() {
        assertEquals(position("a"),1);
    };

    @Test
    void position_z() {
        assertEquals(position("z"),26);
    };

    @Test
    void position_w() {
        assertEquals(position("w"),23);
    };

    @Test
    void position_f() {
        assertEquals(position("f"),6);
    };

    @Test
    void position_c() {
        assertEquals(position("c"),3);
    };

    @Test
    void position_h() {
        assertEquals(position("h"),8);
    };



}