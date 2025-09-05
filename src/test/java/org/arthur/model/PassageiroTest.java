package org.arthur.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassageiroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void temDesconto() {
        Passageiro p1 = new Passageiro("Arthur", 10, "123456");
        Passageiro p2 = new Passageiro("Bruno", 30, "654321");
        Passageiro p3 = new Passageiro("Carlos", 70, "987654");

        assertTrue(p1.temDesconto());
        assertFalse(p2.temDesconto());
        assertTrue(p3.temDesconto());
    }
}