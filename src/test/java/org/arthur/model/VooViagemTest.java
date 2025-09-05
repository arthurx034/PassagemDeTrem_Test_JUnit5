package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VooViagemTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calcularPreco() {
        Estacao estacaoA = new Estacao("Estacao A", "Cidade A");
        Estacao estacaoB = new Estacao("Estacao B", "Cidade B");
        Trem trem
                = new Trem("T123", 100, 0);
        Viagem viagem = new Viagem(
                estacaoA,
                estacaoB,
                null,
                null,
                trem
        );
        Passageiro p1 = new Passageiro("Arthur", 10, "123456");
        Bilhete bilhete1 = new Bilhete(p1, viagem, 100.0);
        assertEquals(80.0, bilhete1.calcularPreco());
    }

    @Test
    void validarEmbarque() {
        Estacao estacaoA = new Estacao("Estacao A", "Cidade A");
        Estacao estacaoB = new Estacao("Estacao B", "Cidade B");
        Trem trem
                = new Trem("T123", 100, 0);
        Viagem viagem = new Viagem(
                estacaoA,
                estacaoB,
                null,
                null,
                trem
        );
        Passageiro passageiro = new Passageiro("Arthur", 10, "123456");
        Bilhete bilhete = new Bilhete(passageiro, viagem, 100.0);
        assertTrue(bilhete.validarEmbarque(viagem));
        Viagem outraViagem = new Viagem(
                estacaoB,
                estacaoA,
                null,
                null,
                trem
        );
        assertFalse(bilhete.validarEmbarque(outraViagem));
    }

    @Test
    void embarcarPassageiro() {
        Trem trem = new Trem("T123", 100, 0);
        trem.embarcarPassageiro();
        assertEquals(0, trem.getOcupacaoAtual());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trem.embarcarPassageiro();
        });
        assertEquals("Não tem vagas disponiveis", exception.getMessage());
    }

    

}
