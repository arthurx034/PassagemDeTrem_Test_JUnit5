package org.arthur.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BilheteServiceTest {

    private Trem trem;
    private Estacao origem;
    private Estacao destino;
    private Passageiro passageiro;
    private Viagem viagem;

    @Mock
    private TremRepository tremRepository;
    @Mock
    private ViagemRepository viagemRepository;
    @Mock
    private EmailService emailService;
    @InjectMocks
    private BilheteService bilheteService;

    @BeforeEach
    public void setup() {
        // Inicializa objetos de teste
        passageiro = new Passageiro("Arthur", 15, "1234567890");
        origem = new Estacao("Estacao A", "Cidade A");
        destino = new Estacao("Estacao B", "Cidade B");
        trem = new Trem("T123", 100, 50); // Capacidade 100, ocupação atual 50
        viagem = new Viagem(origem, destino, LocalDateTime.now(), LocalDateTime.now().plusHours(2), trem);
    }

    @Test
    public void testEmitirBilhete_Sucesso() {
        // Configurar mocks
        when(tremRepository.buscarPorCodigo("T123")).thenReturn(Optional.of(trem));
        when(viagemRepository.buscarPorId(anyInt())).thenReturn(Optional.of(viagem));
        doNothing().when(emailService).enviarConfirmacao(any(), any());

        // Executar método
        Bilhete bilheteEmitido = bilheteService.emitirBilhete("T123", "Estacao A", "Estacao B", passageiro);

        // Verificações
        assertNotNull(bilheteEmitido);
        assertEquals(passageiro, bilheteEmitido.getPassageiro());
        assertEquals(viagem, bilheteEmitido.getViagem());

        verify(tremRepository).buscarPorCodigo("T123");
        verify(viagemRepository).buscarPorId(anyInt());
        verify(emailService).enviarConfirmacao(eq(passageiro), any(Bilhete.class));
        verify(emailService, never()).enviarAlertaLotacao(any());
    }

    @Test
    public void testEmitirBilhete_TremLotado() {
        // Simular trem lotado
        trem.setOcupacaoAtual(trem.getCapacidade());

        // Configurar mocks
        when(tremRepository.buscarPorCodigo("T123")).thenReturn(Optional.of(trem));
        when(viagemRepository.buscarPorId(anyInt())).thenReturn(Optional.of(viagem));

        // Executar e verificar exceção
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> bilheteService.emitirBilhete("T123", "Estacao A", "Estacao B", passageiro)
        );
        assertEquals("Trem lotado", exception.getMessage());

        // Verificar interações
        verify(tremRepository).buscarPorCodigo("T123");
        verify(viagemRepository).buscarPorId(anyInt());
        verify(emailService, never()).enviarConfirmacao(any(), any());
        verify(emailService, never()).enviarAlertaLotacao(any());
    }
}
