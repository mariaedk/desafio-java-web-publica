package br.com.obras.obras.domain.repository;

import br.com.obras.obras.domain.entities.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {
    List<Obra> findAllByOrderByNumeroObra();

    @Query("SELECT o FROM Obra o " +
            "JOIN o.servicos s " +
            "WHERE s.responsavel.id = :responsavelId " +
            "ORDER BY o.numeroObra")
    List<Obra> listarObrasPorResponsavelOrdenadasPorNumeroObra(@Param("responsavelId") Long responsavelId);
}
