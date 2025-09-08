package org.arthur.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassagemTremIntegrationTest {

    @Test
    void testeFluxoCompletoIntegracao() {
        // 1. Criar duas estações diferentes (origem e destino)
        Estacao origem = new Estacao("São Paulo", "SP");
        Estacao destino = new Estacao("Rio de Janeiro", "RJ");

        // 2. Criar um trem com capacidade limitada
        Trem trem = new Trem("T123", 2, 0); // Capacidade para 2 passageiros

        // 3. Criar uma viagem entre as estações utilizando o trem
        Viagem viagem = new Viagem(origem, destino, null, null, trem);

        // 4. Criar um passageiro
        Passageiro passageiro = new Passageiro("João Silva", 10, "123456789");

        // 5. Comprar um bilhete para o passageiro nessa viagem
        Bilhete bilhete = new Bilhete(passageiro, viagem, 100.0);

        // 6. Validar o embarque do passageiro
        assertTrue(bilhete.validarEmbarque(viagem), "Bilhete deve ser válido para a viagem");

        // 7. Garantir que a ocupação do trem aumentou
        assertEquals(0, trem.getOcupacaoAtual(), "Trem deve começar vazio");
        trem.embarcarPassageiro();
        assertEquals(1, trem.getOcupacaoAtual(), "Ocupação deve aumentar após embarque");

        // 8. Validar o preço final do bilhete considerando as regras de desconto
        assertEquals(80.0, bilhete.calcularPreco(), "Criança de 10 anos deve ter 20% de desconto");
    }

    @Test
    void testeCapacidadeMaximaTrem() {
        Estacao origem = new Estacao("A", "Cidade A");
        Estacao destino = new Estacao("B", "Cidade B");
        Trem trem = new Trem("T123", 1, 0); // Capacidade apenas 1

        Viagem viagem = new Viagem(origem, destino, null, null, trem);
        Passageiro passageiro = new Passageiro("Maria", 25, "987654321");
        Bilhete bilhete = new Bilhete(passageiro, viagem, 100.0);

        // Primeiro embarque - deve funcionar
        trem.embarcarPassageiro();
        assertEquals(1, trem.getOcupacaoAtual());

        // Segundo embarque - deve falhar
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> trem.embarcarPassageiro());
        assertEquals("Não tem vagas disponiveis", exception.getMessage());
    }

    @Test
    void testeDiferentesTiposPassageiro() {
        Estacao origem = new Estacao("A", "Cidade A");
        Estacao destino = new Estacao("B", "Cidade B");
        Trem trem = new Trem("T123", 10, 0);
        Viagem viagem = new Viagem(origem, destino, null, null, trem);

        // Testar adulto sem desconto
        Passageiro adulto = new Passageiro("Adulto", 30, "111111111");
        Bilhete bilheteAdulto = new Bilhete(adulto, viagem, 100.0);
        assertEquals(100.0, bilheteAdulto.calcularPreco());

        // Testar criança com desconto
        Passageiro crianca = new Passageiro("Criança", 8, "222222222");
        Bilhete bilheteCrianca = new Bilhete(crianca, viagem, 100.0);
        assertEquals(80.0, bilheteCrianca.calcularPreco());

        // Testar idoso com desconto
        Passageiro idoso = new Passageiro("Idoso", 65, "333333333");
        Bilhete bilheteIdoso = new Bilhete(idoso, viagem, 100.0);
        assertEquals(80.0, bilheteIdoso.calcularPreco());
    }

    @Test
    void testeValidacaoEmbarqueErrado() {
        Estacao origem = new Estacao("A", "Cidade A");
        Estacao destino = new Estacao("B", "Cidade B");
        Estacao outroDestino = new Estacao("C", "Cidade C");

        Trem trem = new Trem("T123", 10, 0);
        Viagem viagemCorreta = new Viagem(origem, destino, null, null, trem);
        Viagem viagemErrada = new Viagem(origem, outroDestino, null, null, trem);

        Passageiro passageiro = new Passageiro("João", 25, "123456789");
        Bilhete bilhete = new Bilhete(passageiro, viagemCorreta, 100.0);

        // Deve ser válido para a viagem correta
        assertTrue(bilhete.validarEmbarque(viagemCorreta));

        // Não deve ser válido para viagem diferente
        assertFalse(bilhete.validarEmbarque(viagemErrada));
    }
}