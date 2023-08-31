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

    @Query(value = "SELECT r.* FROM responsavel r " +
            "JOIN servico s ON r.id_responsavel = s.id_responsavel " +
            "JOIN obra o ON s.nr_obra = o.nr_obra " +
            "WHERE o.nr_obra = :numeroObra", nativeQuery = true)
    List<Responsavel> buscarResponsaveisPorNumeroObra(@Param("numeroObra") Long numeroObra);

}
