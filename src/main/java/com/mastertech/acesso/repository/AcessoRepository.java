package com.mastertech.acesso.repository;

import com.mastertech.acesso.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoRepository extends JpaRepository<Acesso, Integer> {

    Acesso findAcessoByIdClienteAndIdPorta(int clienteId, int portaId);
}
