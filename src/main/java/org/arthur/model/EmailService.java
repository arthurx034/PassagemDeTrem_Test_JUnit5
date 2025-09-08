package org.arthur.model;

public interface EmailService {
    void enviarConfirmacao(Passageiro passageiro, Bilhete bilhete);
    void enviarAlertaLotacao(Trem trem);
}
