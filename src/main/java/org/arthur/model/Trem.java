package org.arthur.model;

public class Trem {
    private String codigo;
    private int capacidade;
    private int ocupacao;

    public Trem(String codigo, int capacidade) {
        this.codigo = codigo;
        this.capacidade = capacidade;
    }

    public Trem(String codigo, int capacidade, int ocupacao) {
        this.codigo = codigo;
        this.capacidade = capacidade;
        this.ocupacao = ocupacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getOcupacaoAtual() {
        return ocupacao;
    }

    public boolean temVagas() {
        if (capacidade == getOcupacaoAtual()) {
            return false;
        }
        return true;
    }

    public void embarcarPassageiro() {
        if (temVagas()) {
            ocupacao++;
        } else {
            throw new IllegalArgumentException("Não tem vagas disponiveis");
        }
    }

    public void desembarcarPassageiro() {
        if (ocupacao != 0) {
            ocupacao--;
        } else {
            throw new IllegalArgumentException("Trem vazio");
        }
    }
}
