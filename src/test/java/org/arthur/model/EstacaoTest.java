package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstacaoTest {

    private Estacao estacao;

    @BeforeEach
    void setUp() {
        Estacao estacao = new Estacao("Estacao A", "Cidade A");
    }

    @Test
    void getNome() {
        assertEquals("Estacao A", estacao.getNome());
    }

    @Test
    void getCidade() {
        assertEquals("Cidade A", estacao.getCidade());
    }
}