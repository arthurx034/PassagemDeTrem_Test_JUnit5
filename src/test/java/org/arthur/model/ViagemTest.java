package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ViagemTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOrigem() {
    }

    @Test
    void getDestino() {
    }

    @Test
    void duracaoHoras() {
        Viagem viagem = new Viagem(
                new Estacao("Estacao A", "Cidade A"),
                new Estacao("Estacao B", "Cidade B"),
                LocalDateTime.of(2024, 6, 1, 14, 0),
                LocalDateTime.of(2024, 6, 1, 18, 0),
                new Trem("T123", 100, 0)
        );
        assertEquals("04:00", viagem.duracaoHoras());
    }
}