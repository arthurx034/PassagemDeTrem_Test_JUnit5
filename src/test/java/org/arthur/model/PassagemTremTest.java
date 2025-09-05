package org.arthur.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassagemTremTest {
    Estacao estacaoA;
    Estacao estacaoB;
    Trem trem;
    Viagem viagem;
    Passageiro passageiro;
    Bilhete bilhete;

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
        Passageiro passageiro = new Passageiro("Arthur", 10, "123456");
        bilhete = new Bilhete(passageiro, viagem, 100.0);
    }

    @Test
    void validarEmbarque() {
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
        trem.embarcarPassageiro();
        assertEquals(1, trem.getOcupacaoAtual());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trem.embarcarPassageiro();
        });
        assertEquals("Não tem vagas disponiveis", exception.getMessage());
    }

    @Test
    void calcularPreco() {
        assertEquals(80.0, bilhete.calcularPreco());
    }
}
