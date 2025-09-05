package org.arthur.model;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Viagem {
    private Estacao origem;
    private Estacao destino;
    private LocalDateTime partida;
    private LocalDateTime chegada;
    private Trem trem;
    private LocalDateTime duracao;

    public Viagem(Estacao origem, Estacao destino, LocalDateTime partida, LocalDateTime chegada, Trem trem) {
        this.origem = origem;
        this.destino = destino;
        this.partida = partida;
        this.chegada = chegada;
        this.trem = trem;
    }

    public Estacao getOrigem() {
        return origem;
    }

    public void setOrigem(Estacao origem) {
        this.origem = origem;
    }

    public Estacao getDestino() {
        return destino;
    }

    public void setDestino(Estacao destino) {
        this.destino = destino;
    }

    public LocalDateTime getPartida() {
        return partida;
    }

    public void setPartida(LocalDateTime partida) {
        this.partida = partida;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public void setChegada(LocalDateTime chegada) {
        this.chegada = chegada;
    }

    public Trem getTrem() {
        return trem;
    }

    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    public String duracaoHoras() {
        if (partida != null && chegada != null) {
            long minutes = java.time.Duration.between(partida, chegada).toMinutes();
            long hours = minutes / 60;
            long mins = minutes % 60;
            return String.format("%02d:%02d", hours, mins);
        }
        return null;
    }

}
