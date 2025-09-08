package org.arthur.model;

import java.util.List;
import java.util.Optional;

public interface ViagemRepository {
    Optional<Viagem> buscarPorId(int id);
    List<Viagem> buscarPorEstacao(String estacao);
    void salvar(Viagem viagem);
}
