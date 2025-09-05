package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilheteTest {

    Estacao estacaoA;
    Estacao estacaoB;
    Trem trem;
    Viagem viagem;
    Passageiro p1, p2;
    Bilhete bilhete1;


    @BeforeEach
    void setUp() {
        Estacao estacaoA = new Estacao("Estacao A", "Cidade A");
        Estacao estacaoB = new Estacao("Estacao B", "Cidade B");
        trem = new Trem("T123", 100, 0);
        viagem = new Viagem(
                estacaoA,
                estacaoB,
                null,
                null,
                trem
        );
        p1 = new Passageiro("Arthur", 10, "123456");
        p2 = new Passageiro("Bruno", 18, "654321");
        bilhete1 = new Bilhete(p1, viagem, 100.0);
    }

    @Test
    void calcularPreco() {
        Bilhete bilhete2 = new Bilhete(p2, viagem, 100.0
        );
        assertEquals(80.0, bilhete1.calcularPreco());
        assertEquals(100.0, bilhete2.calcularPreco());
    }

    @Test
    void validarEmbarque() {
        assertTrue(bilhete1.validarEmbarque(viagem));
        Viagem outraViagem = new Viagem(
                estacaoB,
                estacaoA,
                null,
                null,
                trem
        );
        assertFalse(bilhete1.validarEmbarque(outraViagem));
    }
}