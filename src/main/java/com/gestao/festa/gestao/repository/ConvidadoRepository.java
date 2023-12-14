package com.gestao.festa.gestao.repository;

import com.gestao.festa.gestao.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
    @Query("SELECT c FROM Convidado c ORDER BY c.nome")
    List<Convidado> findAllOrderByNome();
}
