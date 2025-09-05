package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstacaoTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNome() {
        Estacao estacao = new Estacao("Estacao A", "Cidade A");
        assertEquals("Estacao A", estacao.getNome());
    }

    @Test
    void getCidade() {
        Estacao estacao = new Estacao("Estacao A", "Cidade A");
        assertEquals("Cidade A", estacao.getCidade());
    }
}