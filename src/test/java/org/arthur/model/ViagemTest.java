package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ViagemTest {

    private Viagem viagem;

    @BeforeEach
    void setUp() {
        Viagem viagem = new Viagem(
                new Estacao("Estacao A", "Cidade A"),
                new Estacao("Estacao B", "Cidade B"),
                LocalDateTime.of(2024, 6, 1, 14, 0),
                LocalDateTime.of(2024, 6, 1, 18, 0),
                new Trem("T123", 100, 0)
        );
    }

    @Test
    void getOrigem() {
        assertEquals("Estacao A", viagem.getOrigem().getNome());
    }

    @Test
    void getDestino() {
        assertEquals("Estacao B", viagem.getDestino().getNome());
    }

    @Test
    void duracaoHoras() {
        assertEquals("04:00", viagem.duracaoHoras());
    }
}