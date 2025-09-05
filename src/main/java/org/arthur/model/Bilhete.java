package org.arthur.model;

public class Bilhete {
    private Passageiro passageiro;
    private Viagem viagem;
    private double precoBase;

    public Bilhete(Passageiro passageiro, Viagem viagem, double precoBase) {
        this.passageiro = passageiro;
        this.viagem = viagem;
        this.precoBase = precoBase;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double calcularPreco() {
        if (passageiro.temDesconto()) {
            return precoBase * 0.8; // 20% de desconto
        }
        return precoBase;
    }

    public boolean validarEmbarque(Viagem viagem) {
        return this.viagem.equals(viagem);
    }
}
