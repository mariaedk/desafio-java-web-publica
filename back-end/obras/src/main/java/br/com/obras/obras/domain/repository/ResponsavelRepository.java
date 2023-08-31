package br.com.obras.obras.domain.repository;

import br.com.obras.obras.domain.entities.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
    Optional<Responsavel> findByCpf(String cpf);

    // Consulta JPQL
    @Query("SELECT r FROM Responsavel r " +
            "JOIN r.servicos s " +
            "JOIN s.obra o " +
            "WHERE o.numeroObra = :numeroObra")
    List<Responsavel> buscarResponsaveisPorNumeroObra(@Param("numeroObra") Long numeroObra);

}
