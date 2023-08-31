package br.com.obras.domain.repositories;

import br.com.obras.domain.entities.ObraPublica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraPublicaRepository extends JpaRepository<ObraPublica, Long> {}
