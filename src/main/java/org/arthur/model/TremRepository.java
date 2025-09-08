package org.arthur.model;

import org.arthur.model.Bilhete;
import org.arthur.model.Passageiro;
import org.arthur.model.Trem;
import org.arthur.model.Viagem;

import java.util.List;
import java.util.Optional;

public interface TremRepository {
    Optional<Trem> buscarPorCodigo(String codigo);
    void salvar(Trem trem);
    boolean existeTrem(String codigo);
}

