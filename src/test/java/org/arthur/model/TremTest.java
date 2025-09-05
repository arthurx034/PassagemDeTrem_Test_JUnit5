package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TremTest {

    Trem trem1;
    Trem trem2;

    @BeforeEach
    void setUp() {
        trem1 = new Trem("T123", 3, 2);
        trem2 = new Trem("T123", 2, 1);
    }

    @Test
    void temVagas() {
        assertTrue(trem1.temVagas());
        trem1.embarcarPassageiro();
        assertFalse(trem1.temVagas());
    }

    @Test
    void embarcarPassageiro() {
        trem2.embarcarPassageiro();
        assertEquals(2, trem2.getOcupacaoAtual());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trem2.embarcarPassageiro();
        });
        assertEquals("Não tem vagas disponiveis", exception.getMessage());
    }

    @Test
    void desembarcarPassageiro() {
        trem2.desembarcarPassageiro();
        assertEquals(0, trem2.getOcupacaoAtual());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trem2.desembarcarPassageiro();
        });
        assertEquals("Trem vazio", exception.getMessage());
    }
}