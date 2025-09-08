package org.arthur.model;

public class BilheteService {
    private TremRepository tremRepository;
    private ViagemRepository viagemRepository;
    private EmailService emailService;

    public BilheteService(TremRepository tremRepository, ViagemRepository viagemRepository, EmailService emailService) {
        this.tremRepository = tremRepository;
        this.viagemRepository = viagemRepository;
        this.emailService = emailService;
    }

    public Bilhete emitirBilhete(String codigoTrem, String origem, String destino, Passageiro passageiro) {
        Trem trem = tremRepository.buscarPorCodigo(codigoTrem)
                .orElseThrow(() -> new IllegalArgumentException("Trem não encontrado"));

        Viagem viagem = viagemRepository.buscarPorId(1)
                .orElseThrow(() -> new IllegalArgumentException("Viagem não encontrada"));

        if (trem.getOcupacaoAtual() <= 0) {
            throw new IllegalStateException("Trem lotado");
        }
        Bilhete bilhete = new Bilhete(passageiro, viagem, 100.0);
        trem.setOcupacaoAtual(trem.getOcupacaoAtual() - 1);
        tremRepository.salvar(trem);
        emailService.enviarConfirmacao(passageiro, bilhete);
        if (trem.getOcupacaoAtual() == 0) {
            emailService.enviarAlertaLotacao(trem);
        }
        return bilhete;
        }
}
